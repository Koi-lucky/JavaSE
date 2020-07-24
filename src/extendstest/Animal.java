package extendstest;

/*
抽象方法：就是加上abstract关键字，然后去掉大括号，直接分号结束。
抽象类：抽象方法所在类，必须是抽象类才行。【抽象类写法：在class之前写上abstract即可】


 【如何使用抽象类和抽象方法】：
 1.不能直接创建new一个抽象类对象。
 2.必须使用一个子类来继承抽象父类。
 3.子类必须覆盖重写抽象父类当中所有的抽象方法。
 【如何覆盖重写（也就是如何实现）】：子类去掉抽象方法的abstract关键字,然后补上方法体大括号。
 4.创建子类对象进行使用
 */
public abstract class Animal {

    //这是一个抽象方法，代表吃东西，但是具体吃什么东西（大括号内的内容）不确定
    public abstract void eat();

    //这是普通的成员方法
//    public void normalMethod() {
//
//    }
}



abstract class Fu08 {

    public Fu08() {
        System.out.println("抽象父类构造方法执行！");
    }

    public abstract void eat();
}


class Zi08 extends Fu08 {

    public Zi08() {
        //super();
        System.out.println("子类构造方法执行！");
    }

    @Override
    public void eat() {
        System.out.println("吃饭饭！");
    }
}


/*
一个抽象类不一定含有抽想方法。但是抽象方法一定在抽象类当中。
只要保证抽象方法所在的类是抽象类，即可。

这样没有抽象方法的抽象类，也不能直接创建对象，在一定的特殊场景下有用途。
 */
abstract class MyAbstract {
}


