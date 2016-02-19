package com.pblog.core.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GenerateUtils {

    /**
     * 以逗号分割字符串
     * @param tags
     * @return
     */
    public static List<String> spiltStringByComma(String tags){
        List<String> tagList = new ArrayList<String>();
        if(null != tags){
            String[] regexStr = tags.split(",");
            for (String str : regexStr){
                tagList.add(str);
            }
        }
        return tagList;
    }

    /**
     * 获取访客IP
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }
}
