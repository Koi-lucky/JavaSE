package leetcode;

public class DetectCapitalUse {

    public static void main(String[] args) {

        String s = "FlaG";
        System.out.println(detectCapitalUse(s));
    }

    public static boolean detectCapitalUse(String word) {
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) >= 'a') {
                lower++;
            } else {
                upper++;
            }
        }
        if(upper == word.length() || lower == word.length()) {
            return true;
        }
        if(upper == 1 && word.charAt(0) < 'a') {
            return true;
        }
        return false;
    }
}
