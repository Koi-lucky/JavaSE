package functionalInterface;

import java.util.function.Predicate;

/**
 * predicate 接口 用于判断 哪种场合用的数据类型，得到的结果是一个布尔值
 */
public class Function_predicate_or {
    //定义一个方法，参数传递的是String类型的字符串，传递一个predicate接口，泛型使用String，使用predicate中的test方法进行判断
    public static boolean checkString(String s, Predicate<String> pre) {
        return pre.test(s);
    }
    public static void main(String[] args) {
        //定义一个字符串，利用checkString方法进行判断
        String s = "abcde";
        /*
        boolean b = checkString( s, (String str) -> {
            //对参数传递的字符串进行判断，判断字符出长度是否大于五，并返回结果
            return str.length() > 5;
        });
        */
        //优化
        boolean b = checkString( s, str -> str.length() > 5);
        System.out.println(b);


        System.out.println("============");

        //or方法

        //定义一个字符串
        String ss = "bcdeffr";
        //调用checkString方法判断
        boolean bb = checkString1( ss, (String str) -> {
            //判断字符串长度是否大于5
            return str.length() > 5;
        },(String str) -> {
            // 判断字符串中是否含有a
            return str.contains("a");
        });
        System.out.println(bb);
    }

    //定义一个or方法，方法的参数传递两个predicate接口，
    // 一个用于判断字符串长度是否大于5，
    // 一个用于判断字符串中是否包含a，
    // 两个条件满足一个以上 就成立
    public static boolean checkString1(String s, Predicate<String> pre1, Predicate<String> pre2) {
        //return pre1.test(s) || pre2.test(s);
        //使用 or 方法
        return pre1.or(pre2).test(s);
    }
}
