package com;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    //无参构造
    public Triangle() {
        this( 1.0, 1.0, 1.0);
    }

    //带参构造
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //side1、side2、side3的访问器


    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    //返回三角形的面积
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }
    //返回三角形的周长
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    //toString方法

    @Override
    public String toString() {

        return "Triangle { " +
                "side1 = " + side1 +
                ", side2 = " + side2 +
                ", side3 = " + side3 +
                " ,";
    }
}
