package review;

import java.util.Scanner;
import java.util.Stack;

public class Reciprocal_Integers {

    public static void main(String[] args) {
        //提醒用户输入一个整数
        System.out.println("输入一个整数：");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        //定义一个栈，用于存放数
        Stack<String> stack = new Stack<>();
        //定一个字符型变量，用于存储符号
        char c =  ' ';
        //判断字符串第一个字符是不是符号位：负号
        if(s.substring( 0, 1).equals("-")) {
            c = s.substring( 0, 1).charAt(0);
            StringBuilder sb = new StringBuilder(s);
            sb.substring(1);
            //遍历字符串，将其逐个压入栈中
            for (int i = 1; i < sb.length(); i++) {
                stack.push(sb.substring(i, i + 1));
            }
        } else {
            //遍历字符串，将其逐个压入栈中
            for (int i = 0; i < s.length(); i++) {
                stack.push(s.substring(i, i + 1));
            }
        }
        //将整数倒序输出
        String ss = " ";
        if(c != ' ') {
            System.out.print(c);
            while(stack.size() != 0) {
                if(stack.peek().equals("0")) {
                    ss = stack.pop();
                } else {
                    while(stack.size() != 0) {
                        System.out.print(stack.pop());
                    }
                }
            }
        } else {
            while(stack.size() != 0) {
                if(stack.peek().equals("0")) {
                    ss = stack.pop();
                } else {
                    while(stack.size() != 0) {
                        System.out.print(stack.pop());
                    }
                }
            }
        }

        sc.close();
    }
}
