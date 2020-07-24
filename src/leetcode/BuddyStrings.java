package leetcode;

import java.util.Arrays;

public class BuddyStrings {

    public static void main(String[] args) {
        String A = "ab";
        String B = "ba";
        System.out.println(buddyStrings( A, B));
    }

    public static boolean buddyStrings(String A, String B) {

        if(A.length() != B.length() || A.length() < 2 || B.length() < 2) {
            return false;
        }
        char[]  ch1 = A.trim().toCharArray();
        char[]  ch2 = B.trim().toCharArray();
        int count = 0;//用于统计两字符串中不相等的字符数
        int[] index = new int[10];
        if(Arrays.equals(ch1, ch2)) {
            for (int i = 0; i < ch1.length; i++) {
                for (int j = i + 1; j < ch1.length; j++) {
                    if(ch1[i] == ch1[j]) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0, j = 0; i < ch1.length && j < ch2.length; i++ , j++) {
            if(ch1[i] != ch2[j]) {
                index[count] = i;
                count ++;
            }
            if(count == 2) {
                char temp = ch1[index[0]];
                ch1[index[0]] = ch1[index[1]];
                ch1[index[1]] = temp;
                if(Arrays.equals(ch1, ch2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
