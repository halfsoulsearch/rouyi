package com.ruoyi.report.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 +-------------------------------------------------------
 | 描述：日期工具类
 +--------------------------------------------------------
 | 作者：llt
 +--------------------------------------------------------
 | 版权：Copyright (c) 2021 晋钢集团 All rights reserved.
 +--------------------------------------------------------
 | 日期：2021年4月9日14:16:27
 +--------------------------------------------------------
 **/

public class DateUtils {

    /**
     * 描述：获取当月天数
     *
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 描述：获取当月天数
     *
     * @param yearMonth
     * @return
     */
    public static int getDaysOfMonth(String yearMonth) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return getDaysOfMonth(sdf.parse(yearMonth));
    }

    /**
     * 获取本月的yyyy-MM
     *
     * @return
     */
    public static String getCurrentYearAndMonth() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(date);
    }

    /**
     * 获取当前时间 yyyy-MM-dd
     *
     * @return
     */
    public static String getCurrentYearAndMonthAndDay() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 获取前days时间 yyyy-MM-dd
     *
     * @return
     */
    public static String getCurrentYearAndMonthAndDayBeforeDays(short days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, days);
        return sdf.format(calendar.getTime());
    }


    /**
     * 获取上月的yyyy-MM
     *
     * @return
     */
    public static String getLastYearAndMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        return sdf.format(calendar.getTime());
    }

    /**
     * 返回一个日期的月份
     *
     * @param yearMonth
     * @return
     * @throws ParseException
     */
    public static int getMonth(String yearMonth) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.parse(yearMonth).getMonth() + 1;
    }

    /**
     * 按照指定的格式返回时间
     *
     * @param pattern
     * @return
     */
    public static String getCurrentDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date d = new Date();
        return sdf.format(d);
    }

    /**
     * 获取两个时间的月份差
     *
     * @param start
     * @param end
     * @return
     */
    public static int monthsBetween(String start, String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();

        bef.setTime(sdf.parse(start));
        if (end == null || "".equals(end)) {
            end = getCurrentDate("yyyy-MM-dd");
        }
        aft.setTime((sdf.parse(end)));

        int surplus = aft.get(Calendar.DATE) - bef.get(Calendar.DATE);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;

        //surplus = surplus <= 0 ? 1 : 0;

        return Math.abs(month + result);
    }

    /**
     * 将long日期类型转换为String
     * time 毫秒为单位
     * @return
     */
    public static String convertTimeStampToString(long time){
        String result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        return result;
    }
}