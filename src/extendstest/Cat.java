package extendstest;

public class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("猫吃鱼！");
    }
}






//最高抽象父类
abstract class Animal01 {

    public abstract void eat();
    public abstract void sleep();
}

//子类也是一个抽象类
abstract class Dog extends Animal01{

    @Override
    public void eat() {
        System.out.println("狗吃骨头！");
    }
//    public abstract void sleep();
}


class DogGolden extends Dog{

    @Override
    public void sleep() {
        System.out.println("呼呼呼.....");
    }
}


class Dog2Ha extends Dog{

    @Override
    public void sleep() {
        System.out.println("嘿嘿嘿.....");
    }
}