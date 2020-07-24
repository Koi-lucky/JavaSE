package leetcode;

import java.util.Arrays;

public class MissingNumberArrays {

    public static void main(String[] args) {

        //int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {

        //先对数组进行排序
        Arrays.sort(nums);
        int k = 0;
        //求这组数的和——错误的和
        for (int i = 0; i < nums.length; i++) {
            k = k + nums[i];
        }
        int sum = (1 + nums.length) * (nums.length) / 2;//正确的和；
        return sum - k;
    }
}
