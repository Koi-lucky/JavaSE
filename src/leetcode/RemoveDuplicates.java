package leetcode;

public class RemoveDuplicates {

    public static void main(String[] args) {
        //测试
        int[] a = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(int[] nums) {
        //快慢指针
        //让快指针先走，等跳过重复的值后，开始将快指针的值 赋给 慢指针的下一个数，此时，慢指针后移
        if(nums.length == 0) {
            return 0;
        }
        int i = 0;
        for(int j = 1;j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
