package leetcode;

public class CompressString {

    public static void main(String[] args) {

        String s = "IIIIeeeeOODDDssppppooQQQQppplllhU";
        System.out.println(new String(compressString(s)));
    }

    public static String compressString(String S) {
        if(S.length() == 1) {
            return S;
        }
        char[] ch = S.toCharArray();
        StringBuffer str = new StringBuffer();
        int count = 0;
        int k = 0;
        for (int i = 0, j = i + 1; i < ch.length && j < ch.length; i++ , j++) {
            ++count;
            if(ch[i] != ch[j]) {
                str.append(ch[i]);
                str.append(count);
                count = 0;
            }
            if(j == ch.length - 1) {
                str.append(ch[j]);
                str.append(count + 1);
            }
        }
        if(str.length() < S.length()) {
            return str.toString();
        }
        return S;
    }
}