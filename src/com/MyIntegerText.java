package com;

public class MyIntegerText {

    public static void main(String[] args) {

        MyInteger a = new MyInteger(128);
        System.out.println("该数是否是偶数、奇数或素数 ：" + a.isEven() +" "+ a.isOdd() +" "+ a.isPrim());
        System.out.println("该对象的值是否与指定值相等：" + a.equals(10));

    }
}

class MyInteger {

    private int value;

    //一个指定值的构造方法
    public MyInteger(int value) {
        this.value = value;
    }

    //get方法
    public int getValue() {
        return value;
    }

    //如果值分别为偶数 、 奇数或素数
    public boolean isEven() {
        if(getValue() % 2 == 0) {
            return true;
        }
        return false;
    }

    public boolean isOdd() {
        if(getValue() % 2 != 0) {
            return true;
        }
        return false;
    }

    public boolean isPrim() {
        for (int i = 2; i <= getValue() / 2; i++) {
            if(getValue() % i == 0) {
                return false;
            }
        }
        return true;
    }

    //相应的含特定值的三个静态方法
    public static boolean isEven(int value) {
        if(value % 2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isOdd(int value) {
        if(value % 2 != 0) {
            return true;
        }
        return false;
    }

    public static boolean isPrim(int value) {
        for (int i = 2; i <= value / 2; i++) {
            if(value % i == 0) {
                return false;
            }
        }
        return true;
    }

    //相应的含MyInteger值的三个静态方法
    public static boolean isEven(MyInteger integer) {
        if(integer.value % 2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isOdd(MyInteger integer) {
        if(integer.value % 2 != 0) {
            return true;
        }
        return false;
    }

    public static boolean isPrim(MyInteger integer) {
        for (int i = 2; i <= integer.value / 2; i++) {
            if(integer.value % i == 0) {
                return false;
            }
        }
        return true;
    }

    //两个equals方法
    public boolean equals(int num) {
        if(this.value == num) {
            return true;
        }
        return false;
    }

    public boolean equals(MyInteger integer) {
        if(this.value == integer.value) {
            return true;
        }
        return false;
    }

    //两个静态的转换方法
    public static int parseInt(char[] ch) {
        return Integer.parseInt(ch.toString());
    }

    public static int parseInt(String string) {
        return Integer.parseInt(string);
    }
}