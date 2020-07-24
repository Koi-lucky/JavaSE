package datastructure;

import java.util.Scanner;

/**
 * 数组模拟环形队列
 * 【上一个“数组模拟队列”程序的优化】——>取模
 * 1.front的含义做了一个调整：front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素。
 *      front初始值为0
 * 2.rear的含义做了一个调整：rear指向队列最后一个元素的后一个位置，因为希望空出一个空间来做约定
 *      rear初始值为0
 * 3.判满：(rear + 1) % maxSize == front
 * 4.判空：rear == front
 * 5.队列中有效数据的个数：(rear + maxSize - front) % maxSize
 * 6.在原来的代码基础上，修改得到了一个“环形队列”
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //创建一个队列，长度为3
        CiccleArray queue = new CiccleArray(3);
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


class CiccleArray {

    private int maxSize;//定义队列的最大容量
    //front的含义做了一个调整：front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素
    //front初始值为0
    private int front;//队列头
    //rear的含义做了一个调整：rear指向队列最后一个元素的后一个位置，因为希望空出一个空间来做约定
    //rear初始值为0
    private int rear;//队列尾
    private int[] arr;//定义一个数组用于存放数据，模拟队列


    //创建队列的构造器
    public CiccleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判满
    public boolean isFill() {
        return (rear + 1) % maxSize == front;
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
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //从队列中取元素
    public int getQueue() {
        //判空
        if(isEmpty()) {
            //抛出一个异常
            throw new RuntimeException("队列为空，无法取出数据!");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时的变量里
        //2.将front后移，考虑取模
        //3.再将临时的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示一下此时队列中的数据
    public void showQueue() {
        //遍历
        if(isEmpty()) {
            System.out.println("队列为空，没有数据!");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        //遍历的元素的个数;(rear + maxSize - front) % maxSize
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    //求当前队列中的有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示一下头数据，注意：不是取出头数据
    public int headQueue() {
        //判空
        if(isEmpty()) {
            throw new RuntimeException("队列为空，无法取出数据!");
        }
        return arr[front];
    }
}
