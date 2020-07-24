package leetcode;

import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
