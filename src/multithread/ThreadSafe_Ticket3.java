package multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 卖票案例会出现线程安全问题：卖出了不存在的票和重复的票
 *
 *   【解决线程安全问题方法33333】——> 使用Lock锁
 *         Lock接口中的方法：
 *                  void  lock()  获取锁
 *                  void  unlock()  释放锁
 *         ReentrantLock implements Lock接口
 *
 *    使用步骤：
 *          1.在成员位置创建一个ReentrantLock对象
 *          2.在可能会出现安全问题的代码前调用Lock接口中的方法lock() 获取锁
 *          3.在可能会出现安全问题的代码后调用Lock接口中的方法unlock() 释放锁
 *          4.最后可以加finally优化一下（提高程序效率）
 */
public class ThreadSafe_Ticket3 {
    //模拟买票案例——> 3个窗口同时卖票(也就是创建3个线程同时进行)
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl04 r = new RunnableImpl04();
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


class RunnableImpl04 implements Runnable{
    //定义一个多线程共享的票源
    private int ticket = 100;//100张票，3个窗口一起卖

    //1.在成员位置创建一个ReentrantLock对象
    Lock l = new ReentrantLock();

    // 设置线程的任务:卖票
    @Override
    public void run() {
        //使用死循环让卖票操作重复执行
        while (true) {
            //2.在可能会出现安全问题的代码前调用Lock接口中的方法lock() 获取锁
            l.lock();
            //先判断票是否存在
            if(ticket > 0) {
                //提高安全问题出现的概率，让程序睡眠
                try {
                    Thread.sleep(10);//10毫秒
                    //票存在，卖票ticket--
                    System.out.println(Thread.currentThread().getName() + "--> 正在卖第" + ticket + "张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //3.在可能会出现安全问题的代码后调用Lock接口中的方法unlock() 释放锁
                    l.unlock();//无论程序是否异常，都会释放锁对象
                }
            }
        }
    }
}