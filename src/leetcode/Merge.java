package leetcode;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 3, 0, 0, 0};
        int[] nums2 = { 2, 5, 6};
        merge(nums1,3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //两个都是有序数组，直接合并，合并之后再排序
        for (int i = m, j = 0; j < n; i++,j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
