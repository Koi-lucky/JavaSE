package designpatterns.strategy02;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 9:06
 */
public class Main {

    public static void main(String[] args) {
        // 测试鸭子叫的不同行为
        Duck duck = new Duck();
        duck.setBehavior(new Squeak());
        duck.showBehavoir();
        duck.setBehavior(new Quack());
        duck.showBehavoir();

    }
}
