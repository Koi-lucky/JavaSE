package com;

public class TestColorable {

    public static void main(String[] args) {
        //测试一下
        GeometricObject[] objects = {
                new Square(5),
                new Square(1),
                new Square(10),
                new Square(3),
                new Square(2.1)
        };
        for (int i = 0; i < objects.length; i++) {
            //输出五个图形的面积
            System.out.println("Area is " + ((Square)objects[i]).getArea());
            //判断是否对象是可着色的
            if(objects[i] instanceof Colorable) {
                ((Colorable)objects[i]).howToColor();
            }
        }
    }
}


//创建Colorable接口
interface Colorable {
    public abstract void howToColor();
}

//创建Square类
class Square extends GeometricObject implements Colorable{
    private double sides;
    //带参构造
    public Square(double sides) {
        this.sides = sides;
    }
    //实现Colorable接口的方法
    @Override
    public void howToColor() {
        System.out.println("Color all four sides!");
    }

    public double getArea() {
        return sides * sides;
    }
}