package functionalInterface;

public class Lambda_parameter {
    //定义一个方法startThread，方法的参数使用函数式接口Runnable
    public static void startThread(Runnable run) {
        //开启多线程
        new Thread(run).start();
    }

    public static void main(String[] args) {
        //调用startThread方法，方法的参数是一个接口，
        // 1.所以就可以传递这个接口的匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "--> 线程启动了");
            }
        });
        // 2.lambda表达式
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + "--> 线程启动了");
        });
        // lambda表达式优化
        startThread(() -> System.out.println(Thread.currentThread().getName() + "--> 线程启动了"));
    }
}
