package leetcode;

import java.util.ArrayList;

public class ArrayIntersection {

    public static void main(String[] args) {

        int[] nums1 = { 4, 9, 5};
        int[] nums2 = { 9, 4, 9, 8, 4};
       intersection(nums1, nums2);
    }

    public static void intersection(int[] nums1, int[] nums2) {

        ArrayList list = new ArrayList<Integer>();
        int k = 0;
        int[] arr1 = new int[(nums1.length > nums2.length) ? nums1.length : nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    arr1[k] = nums1[i];
                    k ++;
                }
            }
        }
        for (int i = 0; i < arr1.length - 1; i++) {
            if(!list.contains(arr1[i])) {
                list.add(arr1[i]);
            }
        }
        System.out.println(list);
    }
}
