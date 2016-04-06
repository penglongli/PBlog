package com.pblog.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtils {

    public static Long HOURS_LONG = 3600000L;

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

    /**
     * 为时间类型增加月份
     * @param timeStamp 时间
     * @param number 增加月份数
     * @return
     * @throws ParseException
     */
    public static Date addMonth(String timeStamp, int number) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(timeStamp);
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(Calendar.MONTH, number);
        date = calendar.getTime();

        return date;
    }

    /**
     *
     * 判断日期相减是否大于1小时
     * @param minuendDate 被减数
     * @param subtrahendDate 减数
     * @return 如果间隔大于等于1小时，则返回true; 如果间隔小于1小时，则返回false
     */
    public static boolean isThanOneHour(Date minuendDate, Date subtrahendDate){
        Long minuendLong = minuendDate.getTime();
        Long subtrahendLong = subtrahendDate.getTime();

        Long result = minuendLong - subtrahendLong;
        if((result / HOURS_LONG) < 1){
            return false;
        }else{
            return true;
        }
    }
}
