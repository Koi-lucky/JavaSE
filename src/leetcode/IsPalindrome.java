package leetcode;

public class IsPalindrome {

    public static void main(String[] args) {

        String s = "A.";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        String ss = s.replaceAll("[^0-9a-zA-Z]", "").replace(" ", "");
        if(ss == null || ss.length() == 1) {
            return true;
        }
        char[] ch = ss.toCharArray();
        int start = 0;
        int end = ss.length() - 1;
        while(start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return (ss.equalsIgnoreCase(String.valueOf(ch))) ? true : false;
    }
}
