package designpatterns.singleton01;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/1 14:42
 */
public class Demo01 {

    // 饿汉式单例

    // 创建静态对象
    private static final Demo01 INSTANCE = new Demo01();

    // 构造器私有化
    private Demo01(){}


    // 构造getIntance()方法 —— 返回静态对象
    public static Demo01 getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {
        // 饿汉式单例的测试
        Demo01 d1 = Demo01.getInstance();
        Demo01 d2 = Demo01.getInstance();
        System.out.println(d1.hashCode());
        System.out.println(d2.hashCode());
    }

}
