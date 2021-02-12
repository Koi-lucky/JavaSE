package designpatterns.strategy02;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 8:59
 */
public class Duck {

    private DuckBehavior dube ;

    // 表演鸭子叫
    public void showBehavoir() {
        if (dube != null) {
            dube.behavior();
        }
    }
    // 设置鸭子叫声
    public void setBehavior(DuckBehavior duckBehavior) {
        this.dube = duckBehavior;
    }
}
