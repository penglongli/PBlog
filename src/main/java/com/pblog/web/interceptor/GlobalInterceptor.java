package com.pblog.web.interceptor;

import com.pblog.core.utils.GenerateUtils;
import com.pblog.domain.WebsiteTraffic;
import com.pblog.service.log.WebsiteTrafficService;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class GlobalInterceptor implements HandlerInterceptor{

    private final static Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);

    @Resource(name = "websiteTrafficService")
    private WebsiteTrafficService websiteTrafficService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //判断设备
        String userAgentStr = request.getHeader("User-Agent");
        UserAgent userAgent = new UserAgent(userAgentStr);
        DeviceType deviceType = userAgent.getOperatingSystem().getDeviceType();

        //判断是否为手机端访问
        if(DeviceType.MOBILE.equals(deviceType)){
            request.setAttribute("mobile", true);
        } else if(DeviceType.TABLET.equals(deviceType)){
            request.setAttribute("mobile", false);
        }else{
            request.setAttribute("mobile", false);
        }

        //获取访客IP
        String realIp = GenerateUtils.getIpAddress(request);
        request.setAttribute("realIp", (realIp == null) ? "127.0.0.1" : realIp);

        WebsiteTraffic websiteTraffic = new WebsiteTraffic();
        websiteTraffic.setBrowser(userAgent.getBrowser().getName());
        websiteTraffic.setCreateTime(new Date());
        websiteTraffic.setOperateSystem(userAgent.getOperatingSystem().getName());
        websiteTraffic.setIpAddress((realIp == null) ? "127.0.0.1" : realIp);
        websiteTrafficService.save(websiteTraffic);

        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
