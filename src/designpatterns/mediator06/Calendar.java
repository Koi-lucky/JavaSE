package designpatterns.mediator06;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 10:07
 */
public class Calendar extends Colleague {
    @Override
    void doEvent() {
        System.out.println("Calendar");
    }
    // 日历的专属事件
    void doCalendar() {
        System.out.println("日历日历日历");
    }
}
