package leetcode;

public class IsValid {

    public static void main(String[] args) {

        String s = "(]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        if(s.equals("")) {
            return true;
        }
        while(true) {
            int len = s.length();
            s = s.replace("[]", "");
            s = s.replace("()", "");
            s = s.replace("{}", "");
            if(len == s.length()) {
                break;
            }
        }
        return (s.length() == 0) ? true : false;
    }
}
