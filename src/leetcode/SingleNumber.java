package leetcode;

import java.util.LinkedList;

public class SingleNumber {

    public static void main(String[] args) {

        int[] nums = { 4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
            } else {
                list.remove((Object)nums[i]);//如果不加(Object)，则会调用到remove(int index)，会把num当成索引；如果加了(Object)，则会调用到remove(Object o)，删除o元素。
            }
        }
        return list.get(0);
    }
}
