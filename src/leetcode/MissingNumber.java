package leetcode;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(mid == nums[mid]) {
                left = mid + 1;;
            } else if(nums[mid] == mid + 1) {
                right = mid - 1;
            }
        }
        return left;
    }
}
