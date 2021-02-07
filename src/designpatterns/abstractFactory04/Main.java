package designpatterns.abstractFactory04;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 19:08
 */
public class Main {

    public static void main(String[] args) {
/*        // 1.用普通方法创建一个现代人 —— 直接new
        // 一个现代人 —— 吃面包，拿着AK47，开着汽车
        Car c = new Car();
        c.go();
        AK47 a = new AK47();
        a.shoot();
        Bread b = new Bread();
        b.getName();*/

        // 2.创建现代人抽象工厂  —— 创建抽象工厂，将这些属性组合在一起
        Vehicle v1 = new MondernPersonFactory().createVehicle();
        v1.go();
        Weapon v2 = new MondernPersonFactory().createWeapon();
        v2.shoot();
        Food v3 = new MondernPersonFactory().createFood();
        v3.getName();
        System.out.println("==================================");
        // 创建魔法师抽象工厂 —— 吃魔法饼干，拿着魔法棒，骑着扫帚
        Vehicle vehicle = new MagicPersonFactory().createVehicle();
        vehicle.go();
        Weapon weapon = new MagicPersonFactory().createWeapon();
        weapon.shoot();
        Food food = new MagicPersonFactory().createFood();
        food.getName();
    }
}
