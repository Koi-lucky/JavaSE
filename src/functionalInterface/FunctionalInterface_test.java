package functionalInterface;
//函数式接口的使用：一般可以作为方法的参数和返回值类型
public class FunctionalInterface_test {

    public static void main(String[] args) {
        //调用show方法，方法的参数是一个接口，

        // 1.所以可以传递接口的实现类对象
        show(new MyFuntionalInterfaceImpl());

        // 2.可以传递接口的匿名内部类
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });
        // 3.可以使用lambda表达式
        show(() -> {
            System.out.println("使用lambda表达式重写接口中的抽象方法");
        });
        // 简化lambda表达式
        show(() -> System.out.println("使用lambda表达式重写接口中的抽象方法"));
    }

    //定义一个方法，调用函数式接口MyFunctionalInterface
    public static void show(MyFunctionalInterface myter) {
        myter.method();
    }
}

//定义函数式接口
@FunctionalInterface//注解，检测接口是否是一个函数式接口（也就是判断是否接口中有且只有一个抽象方法）
interface MyFunctionalInterface {
    //定义一个抽象方法
    public abstract void method();
    //可以有其他的方法，默认，静态，私有
    //但只能有一个抽象方法
}

//定义一个接口的实现类
class MyFuntionalInterfaceImpl implements MyFunctionalInterface {

    @Override
    public void method() {
        System.out.println("使用接口的实现类重写接口中的抽象方法");
    }
}