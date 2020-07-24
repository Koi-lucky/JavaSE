package com;

import java.util.Scanner;

public class TestTriangle {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入三角形的三条边;");
        triangle.setSide1(input.nextDouble());
        triangle.setSide2(input.nextDouble());
        triangle.setSide3(input.nextDouble());
        System.out.println("请输入三角形的颜色：");
        triangle.setColor(input.next());
        System.out.println("请输入三角形是否填充：");
        triangle.setFilled(input.hasNext());

        System.out.println("The area is " + triangle.getArea() + ", the perimeter is " + triangle.getPerimeter());
        System.out.println(triangle.toString() + "color：" + triangle.getColor() + "，and filled：" + triangle.isFilled() +" }");
    }
}
