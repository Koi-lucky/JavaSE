package com;

import java.util.Date;

public class DateText {

    public static void main(String[] args) {
        Date date = new Date();//实例化一个Date对象，代表当前时间点
        System.out.println(date);//用toString()方法显示时间和日期
        long msec = date.getTime();//得到日期的毫秒数
        System.out.println("1970-1-1到现在的毫秒数时：" + msec);

    }
}

