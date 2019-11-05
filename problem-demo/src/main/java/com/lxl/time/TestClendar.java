package com.lxl.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestClendar {


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 查询时间范围筛选
     * 1.12个月以前的数据无法查询
     * 2.相差3个月以上的，按结束时间往前推3个月
     * 3.只能查询今天以前的数据
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static String[] getDate(String startDate, String endDate) {
        try {
            if(startDate.compareTo(endDate) > 0){
                return null;
            }
            String lastYear = getLastYear();
            if (lastYear.compareTo(endDate) > 0) {
                return null;//无法查询1年前数据
            }
            if (lastYear.compareTo(startDate) > 0) {
                startDate = lastYear;
            }
            String today = getToday();
            if (endDate.compareTo(today) > 0) {
                endDate = today;
            }
            String threeMonthAgo = getThreeMonthAgo(endDate);
            if (threeMonthAgo.compareTo(startDate) > 0) {
                startDate = threeMonthAgo;
            }
            return new String[]{startDate, endDate};
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getLastYear() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date time = c.getTime();
        return sdf.format(time);
    }

    public static String getToday() {
        return sdf.format(new Date());
    }

    public static String getThreeMonthAgo(String date) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            c.add(Calendar.MONTH, -3);
            Date time = c.getTime();
            return sdf.format(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String date1 = "2018-03-23";
        String date2 = "2019-12-01";
        String[] date = getDate(date1, date2);
        System.out.println(date[0]+"+++"+date[1]);
    }

}
