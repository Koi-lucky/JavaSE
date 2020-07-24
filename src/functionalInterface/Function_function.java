package functionalInterface;

import java.util.function.Function;

/**
 * function接口 用于 数据类型的转换
 */
public class Function_function {
    //定义一个方法，方法的参数传递一个字符串类型的整数，方法的参数传递一个function接口，
    // 泛型使用<String, Integer>把String类型转换为Integer型
    //使用function接口中的apply方法，进行数据类型的转换
    public static void change(String s, Function<String, Integer> fun) {
        Integer in = fun.apply(s);
        System.out.println(in);
    }

    public static void main(String[] args) {
        //定义一个字符串类型的整数
        String s = "12365";
        //调用change方法，传递字符串类型的整数，和lambda表达式
        change( s, (String str) -> {
            //把字符串类型的整数 转换为 Integer类型的整数
            return Integer.parseInt(str);
        });
    }
}
