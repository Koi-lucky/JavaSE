package designpatterns.abstractFactory04;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 19:51
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();

}
