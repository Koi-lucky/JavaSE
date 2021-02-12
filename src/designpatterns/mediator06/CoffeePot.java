package designpatterns.mediator06;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 10:07
 */
public class CoffeePot extends Colleague {
    @Override
    void doEvent() {
        System.out.println("CoffeePot");
    }
    // 咖啡壶的专属事件
    void doCoffeePot() {
        System.out.println("咖啡壶咖啡壶咖啡壶");
    }
}
