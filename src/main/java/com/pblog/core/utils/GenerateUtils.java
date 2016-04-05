package com.pblog.core.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class GenerateUtils {

    /**
     * 以逗号分割字符串
     * @param tags
     * @return
     */
    public static List<String> spiltStringByComma(String tags){
        List<String> tagList = Lists.newArrayList();
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
    public static String getIpAddress(HttpServletRequest request){
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

    public static boolean judgeTimeStamp(String timeStamp){
        try {
            Date date = DateFormatUtils.formatStrToYM(timeStamp);
            if(date.compareTo(new Date()) == -1){
                return true;
            }else{
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }
}
