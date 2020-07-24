package multithread;
/**
 * Lambda表达式——> 【有参有返回值】的练习
 *
 *      需求：
 *          1.给定一个计算器Calculator接口，内含cal抽象方法将两个int数字相加得到和
 *          2.使用Lambda表达式的标准格式，调用invokeCalc方法完成两个数的相加计算
 */
public class LambdaTest_Calculator {

    public static void main(String[] args) {
        //调用invokeCalc方法,方法的参数是一个接口
        //1.匿名内部类
        /*invokeCalc(10, 20, new Calculator() {
            @Override
            public int cal(int a, int b) {
                return a + b;
            }
        });*/

        //2.Lambda表达式
        invokeCalc( 120, 130, (int a, int b) -> {
            return a + b;
        });

        //3.优化 Lambda表达式——> 省略版Lambda表达式
        invokeCalc( 120, 130, ( a, b) -> a + b);
    }

    /**
     *  定义一个方法
     *  参数传递两个int型整数
     *  参数传递 Calculator接口
     *  方法内部调用 Calculator中的方法cal，计算两个整数的和
     */
    public static void invokeCalc( int a, int b, Calculator c) {
        int sum = c.cal( a, b);
        System.out.println(sum);
    }
}

interface Calculator {
    public abstract int cal(int a, int b);
}