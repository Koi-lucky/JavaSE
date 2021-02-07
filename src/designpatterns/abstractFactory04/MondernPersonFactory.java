package designpatterns.abstractFactory04;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 20:01
 */
public class MondernPersonFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
