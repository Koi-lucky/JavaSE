package leetcode;

public class LongestPalindromeDemo {

    public static void main(String[] args) {

        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String ss = " ";
        int len = 0;//用于存储字符串的长度
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0 ; j--) {
                ss = s.substring( i, j);
                if(isPalidrome(ss)) {
                    if(ss.length() > len) {
                        len = ss.length();
                    }
                }
            }
        }
        return ss;
    }

    public static boolean isPalidrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString().equals(s);
    }
}
