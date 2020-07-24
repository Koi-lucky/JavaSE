package leetcode;

import java.util.HashSet;

public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        //int[] nums ={ 1, 2, 3, 1, 2, 3};
        int[] nums = { 99, 99};
        System.out.println(containsNearbyDuplicate( nums, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
       if(nums.length < 2 || k < 1) {
           return false;
       }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                if(i > k - 1) {
                    set.remove(nums[i - k]);
                }
                set.add(nums[i]);
            }
        }
        return false;
    }
}
