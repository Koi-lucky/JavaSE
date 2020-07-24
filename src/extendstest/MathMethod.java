package extendstest;
/*

java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作

public static double abs (double num):取绝对值。有多种重载
public static double ceil (double num):向上取整
public static double floor (double num):向下取整
public static long round (double num):四舍五入

Math.PI 代表近似的圆周率常量（double）。
 */

public class MathMethod {
    public static void main(String[] args) {
        //取绝对值
        System.out.println(Math.abs(3.6));//3.6
        System.out.println(Math.abs(0));//0
        System.out.println(Math.abs(-2.5));//2.5
        System.out.println("====================");

        //向上取整
        System.out.println(Math.ceil(25.6));//26.0
        System.out.println(Math.ceil(25.1));//26.0
        System.out.println(Math.ceil(25.0));//25.0
        System.out.println("====================");

        //向下取整，抹零
        System.out.println(Math.floor(56.9));//56.0
        System.out.println(Math.floor(56.1));//56.0
        System.out.println(Math.floor(56.0));//56.0
        System.out.println("====================");

        //四舍五入——只有整数位，没有小数位
        System.out.println(Math.round(96.3));//96
        System.out.println(Math.round(96.9));//97
        System.out.println(Math.round(96.0));//96


        //圆周率常量，以后不用自己定义，直接Math.PI调用
        System.out.println(Math.PI);
    }
}



/*
题目：请使用 Math 相关的API，计算在 -10.8 到 5.9 之间，绝对值大于 6 或者小于 2.1 的整数有多少个？
 */
class MathTest {
    public static void main(String[] args) {
        //定义最小值
        double min = -10.8;
        //定义最大值
        double max = 5.9;
        //定义变量计数
        int count = 0;
        //范围内循环
        for (double i = Math.ceil(min); i <= max; i++) {
            //获取绝对值并判断
            if(Math.abs(i) > 6 || Math.abs(i) < 2.1) {
                //计数
                count ++;
            }
        }

        System.out.println("所求的整数的个数为："+count);
    }
}