package leetcode;

public class CheckSubarraySum {

    public static void main(String[] args) {
        //测试
        int[] a = { 23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum( a, 0));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 1 ) {
            return false;
        }
        int sum = 0;//用于求子数组的和
        for (int i = 0; i < nums.length - 1; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(k != 0) {
                    if(sum % k == 0) {
                        return true;
                    }
                } else {
                    if(sum == 0 && k == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
