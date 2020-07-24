package leetcode;

public class FirstUniqCharIndex {

    public static void main(String[] args) {
        String s = "aadadaad";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] count = new int[256];//一共就256个ASCII字符
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            count[ch[i]]++;//统计每个字符出现的次数
        }
        for (int i = 0; i < ch.length; i++) {
            if(count[ch[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
