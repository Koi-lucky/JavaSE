package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Intersection {

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1};
        int[] nums2 = { 2, 2};
        System.out.println(Arrays.toString(intersection( nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                //如果哈希表里面已经有目前的这个数
                //从nums2的第一位开始，重新放起
                nums2[index] = nums2[i];
                index++;//nums2数组下标后移
                set.remove(nums2[i]);//将已经移位之后的原数删除
            }
        }
        //循环结束后，nums2数组中的前index个数即为最终结果要求的数
        return Arrays.copyOfRange( nums2, 0, index);
    }
}
