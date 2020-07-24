package extendstest;

import java.util.Arrays;

/*
java.util.Arrays是一个与数组相关的工具类，里面提供了大量的静态方法，用来实现数组的常见操作。

public static String toString(数组)：将参数数组变成字符串（按照默认的格式：[元素1，元素2，元素3.....]）
public static void sort(数组)：按照默认升序（从小到大）对数组元素进行排序。

【备注】：
1.如果是数值，sort默认按照升序从小到大
2.如果是字符串，sort默认按照字母升序
3.如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。（今后学习）
 */
public class ArraysText {
    public static void main(String[] args) {
        int[] intArray = {10,20,60,90,15};
        //
        String intStr = Arrays.toString(intArray);
        System.out.println(intStr);//[10, 20, 60, 90, 15]

        int[] array1 = {2,60,80,52,13,6,25,41};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));//[2, 6, 13, 25, 41, 52, 60, 80]

        String[] array2 = {"aaa","ccc","fff","ppp","kkk","bbb"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));//[aaa, bbb, ccc, fff, kkk, ppp]

    }
}



/*
题目：使用Arrays相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印。
 */
class Arraystext02 {
    public static void main(String[] args) {
        String str = "asb4iuac2bjfeg61fob";

        //如何进行升序排列：sort
        //必须是一个数组，才能用Arrays.sort方法
        //String ——> 数组，用toCharArray
        char[] chars = str.toCharArray();
        Arrays.sort(chars);//对字符数组进行升序排列

        //倒序遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }

    }
}