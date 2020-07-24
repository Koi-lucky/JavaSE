package com;

public class TestComparableCircle {

    public static void main(String[] args) {

        //测试一下ComparableCircle类
        ComparableCircle comparableCircle1 = new ComparableCircle(1.3);
        ComparableCircle comparableCircle2 = new ComparableCircle(2.5);

        if(comparableCircle1.compareTo(comparableCircle2) > 0) {
            System.out.println("这两个圆中面积最大的是：" + comparableCircle1.toString());
        } else {
            System.out.println("这两个圆中面积最大的是：" + comparableCircle2.toString());
        }
    }
}

//创建一个circle类
class Circle {

    private double radius;//定义半径

    //无参构造
    public Circle() {
    }
    // 带参构造
    public Circle(double radius) {
        this.radius = radius;
    }
    //访问器+修改器
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    //求圆的面积的方法
    public double getArea() {
        return radius * radius * Math.PI;
    }
    //toString方法输出对圆的描述
    @Override
    public String toString() {
        return "Circle{  radius = " + radius ;
    }
}


class ComparableCircle extends Circle implements Comparable<ComparableCircle>{

    //转调父类的带参构造方法
    public ComparableCircle(double radius) {
        super(radius);
    }
    //实现Comparable接口的compareTo方法
    @Override
    public int compareTo(ComparableCircle o) {
        if(getArea() > o.getArea()) {
            return 1;
        } else if(getArea() < o.getArea()) {
            return -1;
        } else
        return 0;
    }
    //实现cricle的toString方法
    @Override
    public String toString() {
        return super.toString() + ", Area = " + getArea() + "  }";
    }
}