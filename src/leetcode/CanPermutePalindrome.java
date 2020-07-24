package leetcode;

import java.util.HashSet;

public class CanPermutePalindrome {

    public static void main(String[] args) {

        String s = "tactcoa";
        System.out.println(canPermutePalindrome(s));
    }

    /**
     * 思路：
     * 每个字符出现的次数为偶数, 或者有且只有一个字符出现的次数为奇数时, 是回文的排列; 否则不是
     * 利用HashSet中的元素不重复性质来判定
     * 将字符串s转换成字符数组c1
     * 新建一个HashSet set
     * 利用循环将c1中的元素添加进set中
     * 若添加成功，则说明之前没有添加，即第一次添加
     * 若添加失败，则证明该元素在之前就已经添加过，所以将该元素移除即可
     * 循环结束后，若set的元素个数为0或者1，则证明该字符串符合条件
     * 否则不符合
     */
    public static boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(!set.add(c[i])) {
                set.remove(c[i]);
            }
        }
        return set.size() <= 1;
    }
}
