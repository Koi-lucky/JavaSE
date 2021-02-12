package designpatterns.mediator06;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 10:05
 */
public class Main {

    public static void main(String[] args) {
        // 测试对一系列事件的中间件的处理
        Alarm alarm = new Alarm();
        Calendar calendar = new Calendar();
        CoffeePot coffeePot = new CoffeePot();
        Spout spout = new Spout();
        Middleware concreteMediator = new ConcreteMediator(alarm, calendar, coffeePot, spout);
        concreteMediator.doEvent("alarm");
    }
}
