package designpatterns.mediator06;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 10:07
 */
public class Spout extends Colleague {
    @Override
    void doEvent() {
        System.out.println("Spout");
    }
    // 壶嘴壶的专属事件
    void doSpout() {
        System.out.println("壶嘴壶嘴壶嘴");
    }
}
