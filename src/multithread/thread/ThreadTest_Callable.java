package multithread.thread;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/7 16:27
 */
public class ThreadTest_Callable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "执行了该方法体");
        return 1 + 2 == 3;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建目标对象
        ThreadTest_Callable tc = new ThreadTest_Callable();
        // 创建执行服务：
        ExecutorService es = Executors.newFixedThreadPool(3);
        // 提交执行：
        Future<Boolean> r1 = es.submit(tc);
        Future<Boolean> r2 = es.submit(tc);
        Future<Boolean> r3 = es.submit(tc);
        // 获取结果：
        boolean b1 = r1.get();
        boolean b2 = r2.get();
        boolean b3 = r3.get();
        // 关闭服务：
        es.shutdownNow();
    }
}
