package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do {
            try {
                System.out.println("请输入两个整数：");
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                System.out.println("这两个整数的和为：" + (num1 + num2));
                flag= false;
            }
            catch (InputMismatchException ex) {
                System.out.println("用户输入不正确，请再次输入：");
                sc.nextLine();
            }
        }while (flag);
        sc.close();
    }
}
