package leetcode;

import java.util.Arrays;

public class FindTheDifference {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference( s, t));
    }

    public static char findTheDifference(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        //将两个数组进行排序
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++) {
            if(ch1[i] != ch2[i]) {
                //如果两个字母不相等，则直接输出该字符
                return ch2[i];
            }
        }
        //循环结束后没找到，表示新添加的数在数组最末尾。直接输出数组的最末尾的值
        return ch2[ch2.length - 1];
    }
}
