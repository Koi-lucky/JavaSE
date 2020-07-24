package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatText {

    public static void main(String[] args) {

        time();
        time2();
        time3();
    }

    //获取现在的日期（24小时制）
    public static void time() {
        SimpleDateFormat sdf = new SimpleDateFormat();//格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");//a为am/pm的标记
        Date date = new Date();//获取当前时间
        System.out.println("现在时间：" + sdf.format(date));
    }

    //获取现在的时间（12小时制）
    public static void time2() {
        SimpleDateFormat sdf = new SimpleDateFormat();//格式化时间
        sdf.applyPattern("yyyy-MM-dd hh:mm:ss a");
        Date date = new Date();
        System.out.println("现在时间：" + sdf.format(date));
    }
    //获取5天后的日期
    public static void time3() {
        SimpleDateFormat sdf = new SimpleDateFormat();//格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE , 5);//将现在的日期加5天
        Date date = calendar.getTime();
        System.out.println("五天后的时间：" + sdf.format(date));
    }
}
