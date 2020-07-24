package multithread;

/**
 * 【创建多线程程序的第一种方式】——> 创建Thread类的子类（继承Thread类）
 *
 * 实现步骤：1.创建一个Thread类的子类
 *           2.在Thread类的子类中 重写run()方法 ，设置线程的任务（开启线程要做什么）
 *           3.创建Thread类的子类对象
 *           4.调用Thread类中的 start()方法 。开启新的线程， 执行 run()方法 ,
 *                  void start() 使该线程开始执行；Java虚拟机调用该线程的 run()方法
 *                  结果是两个线程并发的运行；当前线程（main线程）和另一个线程（创建的新线程，执行他的run()方法）
 *
 *  【特别注意】多次启动一个线程是非法的！！！特别是当线程已经结束执行后，不能再重新启动。
 *   Java程序属于 抢占式调度， 哪个线程的优先级高，哪个线程优先执行； 同一个优先级，随机选择一个执行
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();

        for (int i = 0; i < 20; i ++) {
            System.out.println("main : " + i);
        }
    }
}

//定义一个Thread类的子类
class Thread1 extends Thread{
    //重写Thread类中的run()方法，设置线程任务
    @Override
    public void run() {
        for (int i = 0; i < 20; i ++) {
            System.out.println("run : " + i);
        }
    }
}