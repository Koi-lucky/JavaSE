package designpatterns.facade05;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 9:45
 */
public class Main {

    public static void main(String[] args) {
        // 测试观影前的前期准备工作
        Facade facade = new Facade();
        facade.watchingMovie();
    }
}
