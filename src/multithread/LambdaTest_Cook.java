package multithread;

/**
 * Lambda表达式——> 【无参无返回值】的练习
 */
public class LambdaTest_Cook {

    public static void main(String[] args) {
        //原来匿名内部类的写法
        //1.调用invokeCook方法，参数是Cook接口，传递Cook接口的匿名内部类对象
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭了吃饭了~~");
            }
        });

        //2.使用Lambda表达式，简化匿名内部类的书写
        invokeCook(() -> {
            System.out.println("吃饭了吃饭了~~");
        });

        //3.优化 Lambda表达式——> 省略版Lambda表达式
        invokeCook(() -> System.out.println("吃饭了吃饭了~~"));
    }

    //定义一个方法，参数传递Cook接口，方法内部调用Cook接口中的方法
    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}

interface Cook {
    public abstract void makeFood();
}