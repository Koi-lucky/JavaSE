package multithread;

/**
 * 卖票案例会出现线程安全问题：卖出了不存在的票和重复的票
 *
 *    【解决线程安全问题方法22222】——> 使用同步方法
 *
 *    使用步骤：
 *          1.把访问了共享数据的代码抽取出来，放到一个方法中
 *          2.在方法上添加synchronized修饰符
 *
 *    格式：和定义方法的格式一致
 *      修饰符  synchronized  返回值类型  方法名（参数列表） ｛
 *          可能会出现的线程安全问题的代码（访问了共享数据的代码）
 *      ｝
 */
public class ThreadSafe_Ticket2 {
    //模拟买票案例——> 3个窗口同时卖票(也就是创建3个线程同时进行)
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl03 r = new RunnableImpl03();
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


class RunnableImpl03 implements Runnable{
    //定义一个多线程共享的票源
    private int ticket = 100;//100张票，3个窗口一起卖

    // 设置线程的任务:卖票
    @Override
    public void run() {
        //使用死循环让卖票操作重复执行
        while (true) {
            payTicket();
        }
    }

    /**
     * 定义一个同步方法
     * 同步方法也会把方法内部的代码锁住，只让一个线程执行
     * 同步方法的锁对象是谁？
     * 就是实现类对象 new RunnableImpl03() ，也就是this
     */
    public synchronized void payTicket() {
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