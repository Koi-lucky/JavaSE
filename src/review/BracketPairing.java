package review;

import java.util.Scanner;
import java.util.Stack;

public class BracketPairing {

    public static void main(String[] args) {
        //提醒用户输入一个字符串
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();

            System.out.println(check(s));
        }
        sc.close();
    }

    public static boolean check(String s) {
        Stack<String> stack = new Stack<>();
        //直接判断字符串中是否成对的出现括号（）[]
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.substring( i, i + 1));
            } else if(s.charAt(i) == ')') {
                if(stack.size() == 0 || stack.pop() != "(") {
                    return false;
                }
            } else if(s.charAt(i) == ']'){
                if(s.charAt(i) == ']' || stack.pop() != "[") {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
