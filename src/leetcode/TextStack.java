package leetcode;

import java.util.Stack;

public class TextStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.push("lxk");
        stack.push("lxy");
        stack.push("lxx");
        stack.push("lkk");

        //出栈
        //后进先出的顺序
        while(stack.size() > 0) {
            //弹栈
            System.out.println(stack.pop());
        }
    }
}
