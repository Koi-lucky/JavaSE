package leetcode;

import java.util.Arrays;

public class intersect {

    public static void main(String[] args) {
        //测试
        int[] s1 = { 4, 9, 5};
        int[] s2 = { 9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect( s1, s2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
