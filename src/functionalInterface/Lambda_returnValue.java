package functionalInterface;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 【按字符串的长度进行【降序】排序】
 */
public class Lambda_returnValue {
    //定义一个方法，方法的返回值类型使用函数式接口Comparator
    public static Comparator<String> getComparator() {
        //方法的返回值是一个接口，
       /*
        // 1.所以我们可以使用这个接口的匿名内部类
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();//降序
            }
        }
        // 2.使用lambda表达式
        return (String o1, String o2) -> {
            return o2.length() - o1.length();//降序
        }
        */
        // 3.优化lambda表达式
        return (o1, o2) -> o2.length() - o1.length();
    }

    public static void main(String[] args) {
        //创建一个字符串数组
        String[] arr = {"aaa", "b", "ccccc", "dddddddddd", "eeee"};
        //输出排序前的数组
        System.out.println(Arrays.toString(arr));
        // 调用Array中的sort方法，对字符串数组进行排序
        Arrays.sort( arr, getComparator());
        // 输出排序后的数组
        System.out.println(Arrays.toString(arr));
    }
}
