package designpatterns.singleton01;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/1 14:42
 */
public class Demo06 {
    // 静态内部类的方法

    // 构造器私有化
    private Demo06() {}

    // 静态内部类
    private static class Demo06Holder{
        // 静态内部类里面进行 创建对象，并初始化
        private static final Demo06 INSTANCE = new Demo06();
    }


    public static Demo06 getInstance() {
        // 返回静态内部类中的实例化对象
        return Demo06Holder.INSTANCE;
    }

    public static void main(String[] args) {
        // 饿汉式初始写法的测试
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> System.out.println(Demo06.getInstance().hashCode())).start();
        }
    }
}
