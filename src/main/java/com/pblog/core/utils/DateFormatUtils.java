package com.pblog.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {

    /**
     * 取得时间的年和月
     * @param date
     * @return
     */
    public static String formatToYearMonth(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");

        return dateFormat.format(date);
    }

    /**
     * 取得日
     * @param date
     * @return
     */
    public static String formatToDay(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

        return dateFormat.format(date);
    }

}
