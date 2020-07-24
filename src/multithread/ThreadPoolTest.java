package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *      Executors ：线程池的工厂类，用来生成线程池
 *              其中有一个静态方法： static ExecutorService newFixedThreadPool(int nThreads) 创建一个可重用固定线程数的线程池
 *                                  参数：int nThreads：创建线程池中包含的线程数量
 *                                  返回值：ExecutorService：接口，返回的是ExecutorService接口的实现类对象，我们可以使用ExecutorService接口接收（面向接口的编程）
 *      ExecutorService：线程池接口，用来从线程池中获取线程，调用start方法，执行线程任务
 *                      submit(Runnable task) 提交一个Runnable 任务用于执行
 *               关闭/销毁线程池的方法
 *                      void shutdown()
 *
 *
 * 线程池的使用步骤：
 *      1.使用线程池的工厂类 Executors 里面提供的静态方法 newFixedThreadPool 产生一个指定数量的线程池
 *      2.创建一个类，实现 Runnable 接口，重写run方法，设置线程任务
 *      3.调用 ExecutorService 中的方法 submit ，传递线程任务（实现类），开启线程，执行run方法
 *      4.调用 ExecutorService 中的方法 shutdown 销毁线程池（不建议执行）
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        //1.使用线程池的工厂类 Executors 里面提供的静态方法 newFixedThreadPool 产生一个指定数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //3.调用 ExecutorService 中的方法 submit ，传递线程任务（实现类），开启线程，执行run方法
        es.submit(new RunnableImpl05());
        //线程池会一直开启，使用完了线程池，会自动把线程归还给线程池，线程可以继续使用
        es.submit(new RunnableImpl05());
        es.submit(new RunnableImpl05());
        es.submit(new RunnableImpl05());

        //4.调用 ExecutorService 中的方法 shutdown 销毁线程池（不建议执行）
        es.shutdown();

//        es.submit(new RunnableImpl05());//抛异常，线程池都没有了，就不能获取线程了

    }
}

//2.创建一个类，实现 Runnable 接口，重写run方法，设置线程任务
class RunnableImpl05 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建了一个新线程");
    }
}