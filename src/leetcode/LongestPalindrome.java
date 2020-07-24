package leetcode;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        //用数组存储每个字符出现的次数
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c] ++;
        }
        //存储回文串的最大长度
        int ans = 0;
        for (int i : count) {
            //对于每个字符 ch，假设它出现了 v 次，我们可以使用该字符 v / 2 * 2 次，在回文串的左侧和右侧分别放置 v / 2 个字符 ch，其中 / 为整数除法。例如若 "a" 出现了 5 次，那么我们可以使用 "a" 的次数为 4，回文串的左右两侧分别放置 2 个 "a"。
            //在遍历字符时，ans 每次会增加 v / 2 * 2，因此 ans 一直为偶数
            ans = ans + i / 2 * 2;
            if(i % 2 == 1 && ans % 2 == 0) {
                //在发现了第一个出现次数为奇数的字符后，我们将 ans 增加 1，这样 ans 变为奇数，
                //在后面发现其它出现奇数次的字符时，我们就不改变 ans 的值了
                ans = ans + 1;
            }
        }
        return ans;
    }
}
