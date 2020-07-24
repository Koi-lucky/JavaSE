package com;

public class CountSegments {

    public static void main(String[] args) {
        String s1 = "Hello, my name is John";
        String s2 = "";

        System.out.println(countSegments(s1));
        System.out.println(countSegments(s2));
    }

    public static int countSegments(String s) {
        return (s == null || s.trim().length() == 0) ? 0 : s.trim().split("\\s+").length;
    }
}
