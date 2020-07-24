package multithread;

/**
 * 获取线程的名称：
 *          1.使用Thread类中的方法getName()
 *                  String getName() 返回该线程的名称
 *          2.可以先获得当前正在执行的线程，使用线程中的方法getName()获得线程的名称
 *                  static Thread currentThread() 返回对当前正在执行的线程对象的引用
 *    主线程的名称：main
 *    新线程的名称：Thread-0、Thread-1、Thread-2 ……
 */
public class GetThreadName {

    public static void main(String[] args) {
        //创建一个Thread类的子类对象
        Thread2 t = new Thread2();
//        t.setName("张飞");//修改线程名
        t.start();

        new Thread2().start();

        //currentThread()为静态方法，直接调用即可（表示当前线程）
        // 必须先获得当前线程，才能获得当前线程的名称
        System.out.println("主线程的名称为：" + Thread.currentThread().getName());


        System.out.println("===============");

        //测试一下Thread常用方法：sleep()
        //public static void sleep(long millis)：使当前正在进行的线程以指定的【毫秒数】暂停（暂时停止执行）。
        // 毫秒数结束后，线程继续执行
        //模拟一下秒表 ——> 计时等待状态
        for (int i = 0; i <= 60; i++) {
            System.out.println(i);
            //使用Thread类的sleep()方法 让程序沉睡 1秒
            try {
                Thread.sleep(1000);//1秒=1000毫秒
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}

//定义一个Thread类的子类
class Thread2 extends Thread{
    //重写Thread类中的run()方法，设置线程任务
    @Override
    public void run() {
        //获取线程名称方法1
//        System.out.println("当前线程的名称为："+ getName());
        //获取线程名称方法2
//        System.out.println("当前线程为：" + Thread.currentThread());//获取的是当前的线程
        System.out.println("当前线程的名称为：" + Thread.currentThread().getName());//currentThread()为静态方法，直接调用即可
    }
}