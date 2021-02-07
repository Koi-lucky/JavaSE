package designpatterns.factory03.simpleFactory;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 19:21
 */
public class Truck implements MovableVehicles{
    @Override
    public void go() {
        System.out.println("卡车跑了、、、、、");
    }
}
