package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class GetMinOfStack {
    private static Stack<Integer> stackData = new Stack<Integer>();
    private static Stack<Integer> stackMin = new Stack<Integer>();


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = in.readLine().split(" ");
            if (str[0].equals("push")) {
                push(Integer.parseInt(str[1]));
            } else if (str[0].equals("pop")) {
                pop();
            } else {
                int x = getMin();
                System.out.println(x);
            }
        }
    }

    public static void push(int newNum) {
        stackData.push(newNum);
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum < getMin()) {
            stackMin.push(newNum);
        } else {
            int newMin = stackMin.peek();
            stackMin.push(newMin);
        }
    }

    public static int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Error");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public static int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Error");
        }
        return stackMin.peek();
    }

}
