package designpatterns.singleton01;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/1 14:42
 */
public class Demo05 {
    // 懒汉式单例的优化三——双重检查机制

    // 创建对象，但不直接进行初始化
    private static volatile Demo05 INSTANCE;

    // 构造器私有化
    private Demo05() {}

    // 在getIntance()方法中进行初始化
    public static Demo05 getInstance() {
        // 双重检查机制
        if (INSTANCE == null) {
            synchronized (Demo05.class) {
                if (INSTANCE == null) {
                    // 延时设计——为了更好的体现出线程是否安全
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Demo05();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        // 饿汉式初始写法的测试
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> System.out.println(Demo05.getInstance().hashCode())).start();
        }
    }
}
