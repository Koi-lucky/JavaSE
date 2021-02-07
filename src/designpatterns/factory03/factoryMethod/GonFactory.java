package designpatterns.factory03.factoryMethod;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 19:37
 */
public class GonFactory {

    Gon create() {
        // 可以编写创建对象前的相关权限操作
        System.out.println("创建枪啊");
        return new Gon();
        // 可以编写后续操作
    }
}
