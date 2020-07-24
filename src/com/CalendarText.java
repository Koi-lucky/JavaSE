package com;

import java.util.Calendar;

public class CalendarText {

    public static void main(String[] args) {
        String[] months = {"Jan" , "Feb", "Mar", "Apr", "May", "jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        //获得一个Calendar实例，表示当前时间
        Calendar calendar = Calendar.getInstance();
        //输出当前的时间年月日格式;
        System.out.println("Date:" + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
        //输出当前的时间时分秒格式
        System.out.println("Time:" + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
        //重新设置该时分秒
        calendar.set(Calendar.HOUR , 20);
        calendar.set(Calendar.MINUTE, 57);
        calendar.set(Calendar.SECOND , 20);
        //输出新设置的时间
        System.out.println("Update time:" + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));


    }
}
