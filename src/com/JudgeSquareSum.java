package com;

public class JudgeSquareSum {

    public static void main(String[] args) {
        int c = 100;
        System.out.println(judgeSquareSum1(c));
        System.out.println(judgeSquareSum2(c));
    }

    public static boolean judgeSquareSum1(int c) {

        int j = (int)Math.sqrt(c);
        int i = 0;
        while(i <= j) {
            if(i * i + j * j == c) {
                return true;
            } else {
                if(i * i + j * j < c) {
                    i ++;
                } else {
                    j --;
                }
            }
        }
        return false;
    }

    public static boolean judgeSquareSum2(int c) {
        for (int i = 0; i <= (int)Math.sqrt(c); i++) {
            int j = (int)Math.sqrt(c - i * i);
            if(j * j == c - i * i) {
                return true;
            }
        }
        return false;
    }
}
