package net_and_stream.stream;

/**
 * 通过【类名】直接引用【静态方法】
 * 类已经存在，静态方法也已经存在
 */
public class MethodRef_ClassName {
    //定义一个方法，参数传递要计算绝对值的整数，和函数式接口Calcable
    public static int method( int number, Calcable c) {
        return c.calsAbs(number);
    }
    public static void main(String[] args) {
        //调用method方法，传递计算绝对值的整数，和lambda表达式
        int num = method( -102, (int n) -> {
            //对参数进行绝对值的计算，并返回
            return Math.abs(n);
        });
        System.out.println(num);


        //优化
        int number = method(- 102, Math :: abs);
        System.out.println(number);
    }
}

//定义一个函数式接口
@FunctionalInterface
interface Calcable {
    //定义一个抽象方法，传递一个整数，对整数进行绝对值计算并返回
    public abstract int calsAbs(int number);
}