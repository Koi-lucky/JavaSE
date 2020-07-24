package functionalInterface;

import java.util.function.Predicate;

public class Function_predicate_and {
    //定义一个and方法，方法的参数传递两个predicate接口，
    // 一个用于判断字符串长度是否大于5，
    // 一个用于判断字符串中是否包含a，
    // 两个条件必须同时满足
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
        //return pre1.test(s) && pre2.test(s);
        //使用 and 方法
        return pre1.and(pre2).test(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "bcdeffr";
        //调用checkString方法判断
        boolean b = checkString( s, (String str) -> {
            //判断字符串长度是否大于5
            return str.length() > 5;
        },(String str) -> {
            // 判断字符串中是否含有a
            return str.contains("a");
        });
        System.out.println(b);
    }

}
