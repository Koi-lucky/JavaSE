package designpatterns.mediator06;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 10:07
 */
public class Alarm extends Colleague {
    @Override
    void doEvent() {
        System.out.println("Alarm");
    }
    // 闹钟的专属事件
    void doAlarm() {
        System.out.println("滴滴滴滴滴滴滴");
    }
}
