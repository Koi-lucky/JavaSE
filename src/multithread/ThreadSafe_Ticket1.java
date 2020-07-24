package multithread;
/**
 * 卖票案例会出现线程安全问题：卖出了不存在的票和重复的票
 *
 * 【解决线程安全问题方法11111】——> 使用同步代码块
 *          (使用了一个锁对象，也叫同步锁、或者对象锁、或者对象监视器)
 *  ！！总结同步中的线程：没有执行完毕不会释放锁，同步外的线程没有锁进不去同步
 *  ！！优缺点：同步保证了只能有一个线程在同步中执行共享数据，保证了安全，但是程序频繁的判断锁、获取锁、释放锁，这样会使程序的效率很低
 *
 * 格式：
 *      synchronized(锁对象) {
 *          可能会出现的线程安全问题的代码（访问了共享数据的代码）
 *      }
 * 注意事项：
 *      1.通过代码块中的锁对象，可以使用任意的对象
 *      2.但是必须保证多个线程使用的锁对象是同一个
 *      3.锁对象的作用是：
 *              把同步代码块锁住，只让一个线程在同步代码块中执行
 *
 * 使用同步锁的过程：
 *      3个线程一起抢夺CPU的执行权，谁先抢到谁先执行run方法进行卖票
 *      （1）t1先抢到了，他先执行run方法，遇到了synchronized代码块，
 *          这时他会检查同步代码块有没有锁对象，
 *          发现有，就会获取锁对象，进入到同步代码块中执行（直到执行完同步中的代码，才会释放锁对象）
 *      （2）t2抢到了CPU的执行权，先执行run方法，遇到了synchronized代码块，
 *           这时他会检查同步代码块有没有锁对象，
 *           发现没有，t2就会进入阻塞状态，t2会一直等待t1线程归还锁对象
 *           直到t1线程执行完同步中的代码，才会把锁对象归还给同步代码块
 *           t2才能获取到锁对象进入同步中执行………………
 */
public class ThreadSafe_Ticket1 {
    //模拟买票案例——> 3个窗口同时卖票(也就是创建3个线程同时进行)
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl02 r = new RunnableImpl02();
        //创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        Thread t0 = new Thread(r);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        //调用start方法开启多线程
        t0.start();
        t1.start();
        t2.start();
    }
}


class RunnableImpl02 implements Runnable{
    //定义一个多线程共享的票源
    private int ticket = 100;//100张票，3个窗口一起卖

    //创建一个锁对象
    Object obj = new Object();

    // 设置线程的任务:卖票
    @Override
    public void run() {
        //使用死循环让卖票操作重复执行
        while (true) {
            //同步代码块
            synchronized (obj) {
                //先判断票是否存在
                if(ticket > 0) {
                    //提高安全问题出现的概率，让程序睡眠
                    try {
                        Thread.sleep(10);//10毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //票存在，卖票ticket--
                    System.out.println(Thread.currentThread().getName() + "--> 正在卖第" + ticket + "张票");
                    ticket--;
                }
            }
        }
    }
}