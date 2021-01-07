package multithread.thread;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/7 16:03
 */
public class ThreadTest_BuyTickets implements Runnable {

    // 模拟买票

    private int tickets = 10;

    @Override
    public void run() {
       while (true) {
           if (tickets <= 0) {
               break;
           }
           // 模拟延时
           try {
               Thread.sleep(100);// 延时0.1s
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName() + "--> 拿到了第" + tickets-- + "张票");
       }

    }

    public static void main(String[] args) {
        ThreadTest_BuyTickets tb = new ThreadTest_BuyTickets();
        new Thread(tb, "小明").start();
        new Thread(tb, "老师").start();
        new Thread(tb, "黄牛").start();
    }

}
