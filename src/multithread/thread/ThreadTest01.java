package multithread.thread;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/7 15:34
 */
public class ThreadTest01 {

    public static void main(String[] args) {
        // main方法为主线程，main线程
        // 创建一个线程对象
        ThreadStart ts = new ThreadStart();
        // 调用start方法开启一个线程
        ts.start();

        System.out.println(Thread.currentThread().getName() + "运行了！");
    }
}

class ThreadStart extends Thread {
    // run方法线程体
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "已运行~");
    }
}