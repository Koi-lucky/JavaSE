package leetcode;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
     int[] arr = { 4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i] ++;
                break;
            }
            digits[i] = 0;
        }
        int[] res;
        if(digits[0] == 0) {
            res = new int[digits.length + 1];
            res[0] = 1;
        } else {
            return digits;
        }
        return res;
    }
}
