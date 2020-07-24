package leetcode;

public class Compress {

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        if(chars.length == 1) {
            return 1;
        }
        int count = 0;
        StringBuffer str = new StringBuffer();
        for(int i = 0,j = i + 1;i < chars.length && j < chars.length; i++,j++) {
            count++;
            if(chars[i] !=  chars[j]) {
                str.append(chars[i]);
                str.append(count);
                count = 0;
            }
            if(j == chars.length - 1) {
                str.append(chars[j]);
                str.append(count + 1);
            }
        }
        if(chars.length > str.length()) {
            return str.length();
        }
        return chars.length;
    }
}
