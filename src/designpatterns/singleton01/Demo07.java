package designpatterns.singleton01;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/1 14:42
 */
public enum  Demo07 {
    // 枚举单例的方法

    // 只有一个值
    INSTANCE;

    public static void main(String[] args) {
        // 饿汉式初始写法的测试
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> System.out.println(Demo07.INSTANCE.hashCode())).start();
        }
    }
}
