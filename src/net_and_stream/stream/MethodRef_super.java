package net_and_stream.stream;

public class MethodRef_super {

    public static void main(String[] args) {
        new Man().show();
    }
}

//定义一个函数式接口
@FunctionalInterface
interface Greetable {
    //定义一个见面的方法
    public abstract void greet();
}

//定义一个父类
class Human {
    //定义一个sayHello的方法
    public void sayHello() {
        System.out.println("Hello,我是Human");
    }
}
// 定义一个子类
class Man extends Human{
    //子类重写父类的sayHello方法
    @Override
    public void sayHello() {
        System.out.println("Hello,我是Man");
    }

    //定义一个方法参数传递Greetable接口
    public void method(Greetable g) {
        g.greet();
    }

    public void show() {
        //调用method方法，方法的参数Greetable是一个函数式接口
       /*
        method(() -> {
            //创建父类对象
            Human h = new Human();
            // 调用父类对象中的sayHello方法
            h.sayHello();
        });
        */
        //因为有子父类关系，所以存在一个关键字super，代表父类，可以直接使用super调用父类的方法
        /*
        method(() -> {
            super.sayHello();
        });
        */
        //优化—— super已存在，父类成员方法sayHello已存在
        method(super :: sayHello);
    }
}
