package designpatterns.strategy02;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 8:55
 */
public class Quack implements DuckBehavior {
    @Override
    public void behavior() {
        System.out.println("嘎嘎嘎嘎嘎!!!");
    }
}
