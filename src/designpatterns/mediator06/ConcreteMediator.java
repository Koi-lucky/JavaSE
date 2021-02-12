package designpatterns.mediator06;


/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 10:15
 */
public class ConcreteMediator extends Middleware {
    // 创建相应的事件对象
    private Alarm alarm;
    private Calendar calendar;
    private CoffeePot coffeePot;
    private Spout spout;

    public ConcreteMediator(Alarm alarm, Calendar calendar, CoffeePot coffeePot, Spout spout) {
        this.alarm = alarm;
        this.calendar = calendar;
        this.coffeePot = coffeePot;
        this.spout = spout;
    }

    @Override
    void doEvent(String eventType) {
        switch (eventType) {
            case "alarm" :
                doAlarmEvent();
                break;
            case "calendar" :
                doCalenderEvent();
                break;
            case "coffeePot" :
                doCoffeePotEvent();
                break;
            default:
                doSpoutEvent();
        }
    }

    // 闹钟事件
    void doAlarmEvent() {
        alarm.doAlarm();
        calendar.doCalendar();
        coffeePot.doCoffeePot();
        spout.doSpout();
    }
    // 日历事件
    void doCalenderEvent() {
        // ....
    }
    // 咖啡豆事件
    void doCoffeePotEvent() {
        // ....
    }
    // 壶嘴事件
    void doSpoutEvent() {
        // ....
    }
}
