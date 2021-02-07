package designpatterns.abstractFactory04;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 20:01
 */
public class MagicPersonFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MagicCookies();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
