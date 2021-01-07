package multithread.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/7 20:35
 */
public class ThreadPool implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // 1.创建服务，创建线程池 —— newFixedThreadPool(int nThreads)
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 执行
        service.execute(new ThreadPool());
        service.execute(new ThreadPool());
        service.execute(new ThreadPool());
        service.execute(new ThreadPool());

        // 2.关闭连接
        service.shutdown();
    }
}
