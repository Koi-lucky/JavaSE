package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * 使用两个栈，入队栈和出队栈；入队使用入队栈，出队使用出队栈；
 * 入队栈元素要转移到出队栈，必须保证：
 * 1.转移元素前出队栈为空
 * 2.转移元素后入队栈为空
 */
public class TwoStacksToQueue {

    //入队栈
    private static Stack<Integer> stackPush;
    //出队栈
    private static Stack<Integer> stackPop;

    public static void main(String[] args) {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
        Scanner input = new Scanner(System.in);
        int n = Integer.valueOf(input.nextLine());
        String string;
        //输入n行数
        for (int i = 0; i < n; i++) {
            string = input.nextLine();
            if(string.equals("peek")) {
                System.out.println(peek());
            } else if(string.equals("poll")) {
                System.out.println(poll());;
            } else {
                add(Integer.valueOf(string.split(" ")[1]));
                System.out.println();
            }
        }
    }

    public static void add(int value) {
        stackPush.push(value);
    }

    public static int poll() {
        //如果两个栈都为空
        if(stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("栈为空，此操作非法！");
        }
        //如果出队栈为空，则把入队栈中的元素一个一个弹出、并添加到出队栈中
        if(stackPop.isEmpty()) {
            //将入队栈中的元素弹出到出队栈中
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public static int peek() {
        //如果两个栈都为空
        if(stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("栈为空，此操作非法！");
        }
        //如果出队栈为空，则把入队栈中的元素一个一个弹出、并添加到出队栈中
        if(stackPop.isEmpty()) {
            //将入队栈中的元素弹出到出队栈中
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
