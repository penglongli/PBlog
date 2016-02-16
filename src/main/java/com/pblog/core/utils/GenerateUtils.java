package com.pblog.core.utils;

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
}
