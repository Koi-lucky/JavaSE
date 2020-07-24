package extendstest;
/*
当方法的局部变量和类的成员变量重名、分不清的时候，根据就近原则，优先使用成员变量
如果，需要访问本类当中的成员变量，需要使用格式：
this.成员变量名

【重点】通过谁调用的方法，谁就是this

 */
public class Student {
    String name;//我自己的名字

    //参数name是对方的名字
    //成员变量name是自己的名字
    public void sayHello(String name) {
        System.out.println(name + ",你好。我是：" + this.name);

        System.out.println("==========");
        System.out.println(this);//验证this的输出结果是否和方法中一样,结果为地址值
    }
}


/**
 *
 * 构造方法是专门用于创建对象的方法，当我们通过关键字new来创建对象时，其实就是在调用构造方法.
 *格式：
 * public 类名称（参数类型 参数名称） ｛
 *      方法体
 * ｝
 *
 *【重点】注意事项：
 * 1.构造方法的名称必须和所在的类名称完全一样，就连大小写也要一样
 * 2.构造方法不要写返回值类型，连void都不要写
 * 3.构造方法return返回一个具体的返回值
 * 4.如果没有编写任何的构造方法，那么编译器将会默认赠送一个构造方法，没有参数、方法什么事情都不会做
 * public Student01(） ｛ ｝
 * 5.一旦编写至少一个构造方法，那么编译器将不再赠送
 * 6.构造方法也是可以重载的。
 *  重载：方法名称相同，参数列表不同。
 */
class Student01 {
    //成员变量
    private String name;
    private int age;

    //无参构造方法
    public Student01() {
        System.out.println("无参构造方法执行了！");
    }

    //全参构造方法
    public Student01(String name,int age) {
        System.out.println("全参构造方法执行了！");
        this.name = name;
        this.age = age;
    }


    //Getter  Setter
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}




/*
一个标准的类通常要拥有以下四个组成部分：

1.所有的成员变量都要使用private关键字修饰
2.为每一个成员变量编写一对Getter/Setter方法
3.编写一个无参数的构造方法
4.编写一个全参数的构造方法

这样标准的类也叫做Java Bean
 */

class Student02 {
    private String name;//姓名
    private int age;//年龄


    //Alt+Insert ——> Constructor ——> none
    public Student02() {

    }

    //Alt+Insert ——> Constrnctor ——> 按住shift就可以全选 ——> ok
    public Student02(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Alt+Insert ——> Setter and Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



class Student03 {

    private int id;//学号
    private String name;//姓名
    private int age;//年龄
    static String room;//所在教室

    private static int idCounter = 0;//学号计数器，每当new了一个新对象的时候，计数器++


    //Alt+Insert ——> Constructor ——> none
    public Student03() {
        idCounter++;
    }

    //Alt+Insert ——> Constrnctor ——> 按住shift就可以全选 ——> ok
    public Student03(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Alt+Insert ——> Setter and Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}





class MyClass {


    int num;//成员变量
    static int numStatic;//静态变量

    //成员方法
    public void method(){
        System.out.println("这是一个普通的成员方法！");
        //成员方法可以访问成员变量
        System.out.println(num);
        //成员方法可以访问静态变量
        System.out.println(numStatic);
    }

    //静态方法
    public static void mehodStatic() {
        System.out.println("这是一个静态方法！");
        //静态方法可以访问静态变量
        System.out.println(numStatic);
        //静态不能直接访问非静态【重点】
     //   System.out.println(num);//错误写法！

        //静态方法中不能使用this关键字
     //   System.out.println(this);//错误写法！
    }
}