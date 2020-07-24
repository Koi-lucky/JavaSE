package text;

public class RectangleText {

    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle( 4, 40);
        System.out.println("矩形的宽为：" + rectangle1.width+ "，矩形的高为：" +rectangle1.height + "，矩形的面积为：" + rectangle1.getArea()+ "，矩形的周长为：" + rectangle1.getPerimeter());

        rectangle1.width = 3.5;
        rectangle1.height = 35.9;
        System.out.println("矩形的宽为：" + rectangle1.width+ "，矩形的高为：" +rectangle1.height + "，矩形的面积为：" + rectangle1.getArea()+ "，矩形的周长为：" + rectangle1.getPerimeter());

    }
}


class Rectangle {
    //定义两个数据：width和height
    double width = 1;
    double height = 1;
    //定义无参构造方法

    public Rectangle() {
    }

    //定义一个带参的构造方法

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //定义一个返回矩形面积的方法
    public double getArea() {
        return width * height;
    }
    //定义一个返回矩形周长的方法
    public double getPerimeter() {
        return (width + height) * 2;
    }
    //定义一个修改矩形相关数据的方法
    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}