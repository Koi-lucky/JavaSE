package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class FindErrorNums {

    public static void main(String[] args) {

        int[] nums ={ 1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {

        //先对数组进行排序，找出重复的值
        Arrays.sort(nums);
        //定义一个结果数组，长度为2，第一个空间表示重复的数，第二个空间表示缺少的数
        int[] res = new int[2];
        //用哈希表找出重复的数
        HashSet<Integer> set = new HashSet<>();
        for (int val : nums) {
            if(!set.add(val)) {
                res[0] = val;
                break;
            }
        }
        //利用求和来判断缺少那个数
        //先用原数组求出她的和（此时的和为错误的和）——> 等差数列求出这个数列的正确的和——> 用错误的和减去重复的那个数（此时得到的是：缺少数的和）——> 最后用正确的和减去缺少数的和（此时就得到了缺少的数）
        int rightSum = (1 + nums.length) * (nums.length) / 2;//等差数列求和
        int wrongSum = 0;
        for (int i = 0; i < nums.length; i++) {
            wrongSum = wrongSum + nums[i];
        }

        if(rightSum == wrongSum) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        res[1] = rightSum - (wrongSum - res[0]);
        return res;
    }
}
