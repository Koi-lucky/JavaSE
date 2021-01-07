package multithread.thread;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/7 15:34
 */
public class ThreadTest02 implements Runnable {

    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        ThreadTest02 tt2 = new ThreadTest02();
        // 创建线程对象，通过线程对象来开启线程【代理模式】
        new Thread(tt2).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在看电视！！");
        }
    }

    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学Java~~~");
        }
    }
}
