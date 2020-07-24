package leetcode;

import java.util.HashSet;

public class FindDuplicate {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {

        //用哈希表判断那个数重复
        int k = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                k = nums[i];
                break;
            }
        }
        return k;
    }
}
