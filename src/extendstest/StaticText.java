package extendstest;
/*

如果一个成员变量使用了static关键字，那么这个变量不再属于对象自己，而是属于所在的类，多个对象共享同一份数据。
 */
public class StaticText {
    public static void main(String[] args) {
        Student03 one = new Student03("郭靖",20);
        one.room = "101教室";
        System.out.println("姓名：" + one.getName() + "，年龄：" + one.getAge() + "，教室：" + one.room + "，学号为：" + one.getId());

        Student03 two = new Student03("黄蓉",16);
        System.out.println("姓名：" + two.getName() + "，年龄：" + two.getAge() + "，教室：" + two.room + "，学号为：" + two.getId());
    }
}



/*
一旦使用static修饰成员方法，那么这就成为了静态方法。静态方法不属于对象，而是属于类的。

如果没有static关键字，那么必须首先创建对象，然后通过对象才能使用它。
如果有了static关键字，那么不需要创建对象，直接就能通过类名称来使用它。

无论是成员变量，还是成员方法。如果有了static,都推荐使用类名称进行调用。
静态变量：类名称.静态变量
静态方法：类名称.静态方法()

【注意事项】：
1.静态不能直接访问非静态。
原因：因为在内存当中是【先】有的静态内容，【后】有的非静态内容。
“先人不知道后人，但是后人知道先人”
2.静态方法当中不能用this
原因：this代表当前的对象，通过谁调用的方法，谁就是当前对象。
 */

class StaticMethod {
    public static void main(String[] args) {
        //首先创建对象
        MyClass obj = new MyClass();
        //然后才能使用没有static关键字的内容

        //对于静态方法来说，可以通过对象名进行调用，也可以直接通过类名称来调用
        obj.method();//正确，不推荐写法。这种写法在编译之后也会被javac翻译成为“类名称.静态方法名”
        MyClass.mehodStatic();//正确，推荐写法

        //对于本类当中的静态方法，可以省略类名称
        myMethod();
        StaticMethod.myMethod();//完全等效
    }

    public static void myMethod() {
        System.out.println("自己的方法！");
    }

}


/*

根据类名称访问静态成员变量的时候，全程和对象就没关系，只有和类有关系
 */
class StaticText02 {
    public static void main(String[] args) {
        //
        Student03.room = "101教室";

        Student03 one = new Student03("郭靖",20);
        System.out.println("one的姓名：" + one.getName());
        System.out.println("one的年龄：" + one.getAge());
        System.out.println("one的教室：" + Student03.room);
        System.out.println("========================");

        Student03 two = new Student03("黄蓉",16);
        System.out.println("two的姓名：" + two.getName());
        System.out.println("two的年龄：" + two.getAge());
        System.out.println("two的教室：" + Student03.room);

    }
}



/*

静态代码块的格式是：

public class 类名称 {
    static {
    //静态代码块的内容
    }
}

特点：当第一次用到本类时，静态代码块执行唯一的一次。
静态内容总是优先于非静态，所以静态代码块比构造方法先执行。

静态代码块的典型用途：
用来一次性的对静态成员变量进行赋值。
 */
class StaticText03 {
    public static void main(String[] args) {
        Person01 one = new Person01();
        Person01 two = new Person01();


    }
}