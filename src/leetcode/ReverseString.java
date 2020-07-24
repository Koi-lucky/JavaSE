package leetcode;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {

        char[] s = { 'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {

       //双指针解法
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];//临时变量
            s[i] = s[j];
            s[j] = temp;
            i ++;
            j --;
        }
        System.out.println(Arrays.toString(s));
    }
}
