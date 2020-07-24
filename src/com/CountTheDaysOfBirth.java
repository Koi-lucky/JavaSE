package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算一个人出生了多少天
 * 1.键盘输入出生日期
 * 2.将出生日期转换为Date模式 ——> DateFormat类中的parse方法（DateFormat为抽象类，只能使用它的子类SimpleDateFormat）
 * 3.再将其转换为毫秒
 * 4.获取当前日期，转换为毫秒值
 * 5.用当前日期的毫秒值 - 出生日期的毫秒值
 * 6.再把毫秒值的插值转换为天（s/1000/60/60/24）
 */
public class CountTheDaysOfBirth {

    public static void main(String[] args) throws ParseException {
        //1.键盘输入出生日期
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的出生日期：格式为yyyy-MM-dd");
        String birthdayDateString = sc.next();
        //2.将出生日期转换为Date模式 ——> DateFormat类中的parse方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = sdf.parse(birthdayDateString);//如果两个时间的格式不一致，parse方法会抛出异常，
        //3.再将其转换为毫秒
        long birthdayDateTime = birthdayDate.getTime();
        //4.获取当前日期，转换为毫秒值
        long todayTime = new Date().getTime();
        //5.用当前日期的毫秒值 - 出生日期的毫秒值
        long time = todayTime - birthdayDateTime;
        //6.再把毫秒值的插值转换为天（s/1000/60/60/24）
        System.out.println(time / 1000 / 60 / 60 / 24);
    }
}
