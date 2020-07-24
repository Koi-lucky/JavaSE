package com;

/**
 * 1.自定义一个 带泛型 的类，并进行测试
 * 2.自定义一个 带泛型 的方法，并进行测试
 * 3.自定义一个 带泛型 的接口，并进行测试（有两种类型，都得实现）
 *     （1）定义接口的实现类，实现接口，指定接口的泛型
 *     （2）接口使用什么类型，实现类就是用什么类型，类跟着接口走
 */
public class TestGenericClass {

    public static void main(String[] args) {
        //1.测试一下带泛型的类

        // 不写泛型，默认为Object类型
        GenericClass gc1 = new GenericClass();
        gc1.setName("张三");
        System.out.println(gc1.getName());
        // 创建一个对象，使用Integer泛型
        GenericClass<Integer> gc2 = new GenericClass();
        gc2.setName(156);
        System.out.println(gc2.getName());
        // 创建一个对象，使用String泛型
        GenericClass<String> gc3 = new GenericClass();
        gc3.setName("李四");
        System.out.println(gc3.getName());

        System.out.println("===========");

        //2.测试一下带泛型的方法
        //非静态方法需要创建对象来使用
        GenericMethod gm = new GenericMethod();
        gm.methed1(10);
        gm.methed1("abc");
        gm.methed1(true);
        // 静态方法直接调用 类名.方法名，不需要创建对象
        GenericMethod.methed2(10);
        GenericMethod.methed2("abc");
        GenericMethod.methed2(true);

        System.out.println("=============");
        //3.测试一下带泛型的接口
        //方法一
        GenericInterfaceImpl1 gi1 = new GenericInterfaceImpl1();
        gi1.method("带泛型接口 方法一 的测试");
        // 方法二
        GenericInterfaceImpl2<Integer> gi2 = new GenericInterfaceImpl2<>();
        gi2.method(10000);

        GenericInterfaceImpl2<Double> gi4 = new GenericInterfaceImpl2<>();
        gi4.method(99.65);

        GenericInterfaceImpl2<String> gi3 = new GenericInterfaceImpl2<>();
        gi3.method("带泛型接口 方法二 的测试~~");

    }
}

//1.自己定义的带泛型的类
class GenericClass<E> {//E可以接受任意类型的数，需要什么类型就用什么
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}

//2.自定义的带泛型的方法
class GenericMethod {
    //定义一个带泛型的方法
    public <M> void methed1(M m) {//随便什么类型的数据，M随便写的
        System.out.println(m);
    }
    //定义一个静态的带泛型的方法
    public static  <S> void methed2(S s) {//随便什么类型的数据，M随便写的
        System.out.println(s);
    }
}

//3.自定义的带泛型的接口(实现类有两种类型)
interface GenericInterface<I> {
    public abstract void method(I i);//随便写的I
}
//实现类方式一
//（1）定义接口的实现类，实现接口，指定接口的泛型
class GenericInterfaceImpl1 implements GenericInterface<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
//实现类方式二
//（2）接口使用什么类型，实现类就是用什么类型，类跟着接口走
class GenericInterfaceImpl2<I> implements GenericInterface<I>{
    @Override
    public void method(I i) {
        System.out.println(i);
    }
}