package multithread;
/**
 * 【匿名内部类实现多线程的创建】
 * 格式：
 *      new 父类/接口() {
 *          重复父类/接口中的方法
 *      }
 * 匿名内部类的作用：
 *      把字类继承父类，重写父类的方法，创建子类对象合成一步完成
 *      把实现类实现类接口，重写接口中的方法，创建实现类对象合成一步完成
 * 匿名内部类的最终产物是：子类/实现类对象，而这个类没有名字
 */
public class InnerClassThread {

    public static void main(String[] args) {
        //方法1
        //线程的父类是Thread
        // new Thread3().start();
        new Thread() {
            //重写run方法，设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + " --> 黑马");
                }
            }
        }.start();


        //方法2 线程的接口 Runnable
        // Runnable rImpl = new RunnableImpl();//多态
        Runnable r = new Runnable() {
            //重写run方法，设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + " --> Java");
                }
            }
        };
        new Thread(r).start();



        //方法3
        // 简化线程的接口方法
        new Thread(new Runnable() {
            //重写run方法，设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + " --> 学习");
                }
            }
        }).start();
    }
}
