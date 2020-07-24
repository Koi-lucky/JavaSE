package leetcode;

public class ArraysSearch {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(search(nums, 8));
    }

    public static int search(int[] nums, int target) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        while(left < nums.length && nums[left++] == target) {
            count++;
        }
        return count;
    }
}
