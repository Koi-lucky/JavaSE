package leetcode;

public class Rob {

    public static void main(String[] args) {
        //测试
        int[] a = { 2, 7, 9, 3, 1};
        int[] b = { 1, 2, 3, 1};
        int[] c = { 1, 3, 1};
        System.out.println(rob(a));
        System.out.println(rob(b));
        System.out.println(rob(c));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
