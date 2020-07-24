package datastructure;

import java.util.Scanner;

public class ArrayStackText {

    public static void main(String[] args) {
        //测试数组模拟栈的代码
        //先创建一个对象模拟栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner input = new Scanner(System.in);


        while(loop) {
            System.out.println("show:表示显示栈");
            System.out.println("exit:表示退出程序");
            System.out.println("push:表示进栈");
            System.out.println("pop:表示出栈");
            System.out.println("请输入你的选择：");

            key = input.next();
            switch (key) {
                case"show":
                    stack.list();
                    break;
                case"push":
                    System.out.println("请输入一个数：");
                    int value = input.nextInt();
                    stack.push(value);
                    break;
                case"pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case"exit":
                    input.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }
}

//定义一个数组实现栈的类
class ArrayStack {
    private int maxSize;//定义栈的大小
    private int[] stack;
    private int top = -1;//定义一个栈顶指针

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判空
    public boolean isEmpty() {
        return top == -1;
    }

    ///入栈
    public void push(int value) {
        //判满
        if(isFull()) {
            System.out.println("栈满，无法加入数据！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        //判空
        if(isEmpty()) {
            throw new RuntimeException("栈空，没有数据！！");//抛出异常之后就不用写return
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈，也就是显示一下当前栈的情况
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据！！");
            return;
        }
        //从栈顶开始显示数据
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}