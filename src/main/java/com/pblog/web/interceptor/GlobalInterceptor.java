package com.pblog.web.interceptor;

import com.google.common.collect.Maps;
import com.pblog.core.utils.GenerateUtils;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class GlobalInterceptor implements HandlerInterceptor{

    private final static Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //判断设备
        String userAgentStr = request.getHeader("User-Agent");
        UserAgent userAgent = new UserAgent(userAgentStr);
        DeviceType deviceType = userAgent.getOperatingSystem().getDeviceType();
        if(DeviceType.MOBILE.equals(deviceType)){
            request.setAttribute("mobile", true);
        } else if(DeviceType.TABLET.equals(deviceType)){
            request.setAttribute("mobile", false);
        }else{
            request.setAttribute("mobile", false);
        }

        //判断是否来自微信
        /*String queryString = request.getQueryString();
        if(queryString != null && !queryString.equals("") && queryString.contains("uFrom=weixin")){
            request.setAttribute("weixin", true);
        }else{
            request.setAttribute("weixin", false);
        }*/

        //获取访客IP
        String realIp = GenerateUtils.getIpAddress(request);
        request.setAttribute("realIp", (realIp == null) ? "127.0.0.1" : realIp);

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
