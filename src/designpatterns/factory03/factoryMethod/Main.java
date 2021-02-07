package designpatterns.factory03.factoryMethod;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 19:06
 */
public class Main {

    public static void main(String[] args) {
        // 用不同的产品对应的工厂进行生产
//        Car car =  new CarFactory().create();// 直接使用Car类
        MovableVehicles car = (MovableVehicles) new CarFactory().create();// 使用接口
        car.go();
        Bread bread = new BreadFactory().create();
        bread.getName();
        Gon gon = new GonFactory().create();
        gon.shoot();
    }
}
