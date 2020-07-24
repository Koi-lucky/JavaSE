package datastructure;

import java.util.Scanner;

/**
 * 用数组模拟队列
 * 【有一个问题】：数组不能复用，也就是数组只能使用一次（取出数据后，相应空出来的队列，无法继续使用）
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        //创建一个队列，长度为3
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//用于接收用户的输入
        Scanner sc = new Scanner(System.in);//用户输入
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):往队列中加入数据");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看此时队列的头数据");
            key = sc.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = sc.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        //TODO:handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {
                        //TODO:handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出~~");
    }
}


class ArrayQueue {

    private int maxSize;//定义队列的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//定义一个数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列的头部，分析出front是指向队列头的前一个位置，
        rear = -1;//指向队列尾，指向队列尾的最后一个数据（即就是队列最后一个数据）
    }

    //判满
    public boolean isFill() {
        return rear == maxSize - 1;
    }

    //判空
    public boolean isEmpty() {
        return front == rear;
    }

    //往队列中添加元素
    public void addQueue(int n) {
        //判满
        if(isFill()) {
            System.out.println("队列已满，无法加入数据！");
            return;
        }
        rear++;//让队尾指针rear后移
        arr[rear] = n;
    }

    //从队列中取元素
    public int getQueue() {
        //判空
        if(isEmpty()) {
            //抛出一个异常
            throw new RuntimeException("队列为空，无法取出数据!");
        }
        front++;
        return arr[front];
    }

    //显示一下此时队列中的数据
    public void showQueue() {
        //遍历
        if(isEmpty()) {
            System.out.println("队列为空，没有数据!");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    //显示一下头数据，注意：不是取出头数据
    public int headQueue() {
        //判空
        if(isEmpty()) {
            throw new RuntimeException("队列为空，无法取出数据!");
        }
        return arr[front + 1];
    }
}