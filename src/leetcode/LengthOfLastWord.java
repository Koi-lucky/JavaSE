package leetcode;

public class LengthOfLastWord {

    public static void main(String[] args) {

        String str = "Hello World";
        System.out.println(lengthOfLastWord(str));
    }

    public static int lengthOfLastWord(String s) {
        if(s.trim().equals("")) {
            return 0;
        }
        String[] ss = s.trim().split(" ");
        char[] ch = ss[ss.length - 1].toCharArray();
        int len = ch.length;
        return len;
    }
}
