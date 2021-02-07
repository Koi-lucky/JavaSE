package designpatterns.factory03.factoryMethod;

import designpatterns.factory03.simpleFactory.MovableVehicles;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 19:18
 */
public class Car implements MovableVehicles{
    @Override
    public void go() {
        System.out.println("汽车开动嘟嘟嘟嘟嘟~~~~");
    }
}
