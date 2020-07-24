package com;

public class ReverseWords {

    public static void main(String[] args) {
        String s = "  hello world!  ";

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        //将传进来的字符串先去掉首位的空格，再按字符串内的空格拆分
        String[] ss = s.trim().split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = ss.length - 1; i >= 0; i--) {
            if(ss[i].equals(" ")) {
                continue;
            }
            if(i == 0) {
                buffer.append(ss[i].trim());
            } else {
                //怕有多余的空格，去掉，再加上去
                buffer.append(ss[i].trim()).append(" ");
            }
        }
        return buffer.toString();
    }
}
