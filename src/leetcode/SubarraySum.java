package leetcode;

public class SubarraySum {

    public static void main(String[] args) {
        //测试
        int[] a = { 1, 2, 3};
        System.out.println(subarraySum( a, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        if(nums.length == 1) {
            if(nums[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }
        int sum = 0;//用于求子数组的和
        int count = 0;//计数器
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if(sum == k) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
