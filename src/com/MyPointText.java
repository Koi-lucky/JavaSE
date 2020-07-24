package com;

public class MyPointText {

    public static void main(String[] args) {

        MyPoint point1 = new MyPoint( 0, 0);
        MyPoint point2 = new MyPoint( 10, 30.5);
        System.out.printf("这两点间的距离为：%.2f" ,point1.distance(point2));
    }
}


class MyPoint {
    private double x;
    private double y;

    //无参构造方法
    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    //特定点的构造方法
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //两个get方法
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //返回从该点到 MyPoint 类型的指定点之间的距离
    public double distance(MyPoint point) {
        return Math.sqrt(Math.pow(this.x - point.x , 2) + Math.pow(this.y - point.y , 2));
    }

    //返回从该点到指定点之间的距离
    public double distance(int X, int Y) {
        return Math.sqrt(Math.pow(this.x - X , 2) + Math.pow(this.y - Y , 2));
    }

}