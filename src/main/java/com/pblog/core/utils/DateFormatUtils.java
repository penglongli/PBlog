package com.pblog.core.utils;

import java.text.ParseException;
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

    /**
     * 字符串转日期格式(格式：yyyy-MM)
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date formatStrToYM(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(dateStr);

        return date;
    }
}
