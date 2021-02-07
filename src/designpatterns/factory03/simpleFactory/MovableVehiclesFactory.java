package designpatterns.factory03.simpleFactory;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 19:29
 */
public class MovableVehiclesFactory {

    MovableVehicles createCar() {
        return new Car();
    }
    MovableVehicles createBroom() {
        return new Broom();
    }
    MovableVehicles createTruck() {
        return new Truck();
    }
}
