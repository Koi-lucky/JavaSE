package designpatterns.factory03.simpleFactory;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 19:06
 */
public class Main {

    public static void main(String[] args) {
        /*
        // 1.最原始的创建对象—— 直接new
        Car c = new Car();
        c.go();
        Truck g = new Truck();
        g.go();
        Broom b = new Broom();
        b.go();*/

        /*
        // 2.创建一个交通工具接口，便于管理 —— 多态
        MovableVehicles m = new Car();// new Broom() 或者 new Truck
        m.go();*/


        // 3.创建一个简单工厂——工厂里面有所有产品的create方法
        MovableVehicles m = new MovableVehiclesFactory().createCar();// new MovableVehiclesFactory().createBroom() 或者 new MovableVehiclesFactory().createTruck()
        m.go();
    }
}
