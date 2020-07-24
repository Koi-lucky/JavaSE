package com;

import java.util.Date;

public class TestPerson {

    public static void main(String[] args) {

        //五个类的测试
        //创建Person的对象
        Person p1 = new Person();
        p1.setName("李华");
        System.out.println("类别名：" + p1.toString() + "，人名：" + p1.getName());

        //创建Student的对象
        Student p2 = new Student();
        p2.setName("李白");
        System.out.println("类别名：" + p2.toString() + "，人名：" + p2.getName());

        //创建Employee的对象
        Employee p3 = new Employee();
        p3.setName("张三");
        System.out.println("类别名：" + p3.toString() + "，人名：" + p3.getName());

        //创建Faculty的对象
        Faculty p4 = new Faculty();
        p4.setName("李四");
        System.out.println("类别名：" + p4.toString() + "，人名：" + p4.getName());

        //创建Staff的对象
        Staff p5 = new Staff();
        p5.setName("王麻子");
        System.out.println("类别名：" + p5.toString() + "，人名：" + p5.getName());

    }
}

//人
class Person {

    private String name;//姓名
    private String address;//地址
    private String tel;//电话号码
    private String email;//电子邮件地址

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person" ;
    }
}

//学生类
class Student extends Person{

    private static int FIRST = 1;//大一
    private static int second = 2;//大二
    private static int third = 3;//大三
    private static int FOURTH = 4;//大四

    @Override
    public String toString() {
        return "Student";
    }
}

//员工类
class Employee extends Person{

    private String office;//办公室
    private double salary;//薪水
    private Date hiredDate;//受聘日期

    @Override
    public String toString() {
        return "Employee";
    }
}

//教员类
class Faculty extends Employee{

    private static int FIRST = 1;//大一
    private static int second = 2;//大二
    private static int third = 3;//大三
    private static int FOURTH = 4;//大四

    private Date date;//办公日期
    private String layer;//级别

    @Override
    public String toString() {
        return "Faculty";
    }
}

//职员类
class Staff extends Employee{

    private String title;//职务称号

    @Override
    public String toString() {
        return "Staff";
    }
}