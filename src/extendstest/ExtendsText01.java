package extendstest;

/*
在继承关系中，“子类就是一个父类”。也就是说，子类可以被当做父类看待。
例如：父类是员工，子类是讲师，那么“讲师就是一个员工”。关系：is-a.

定义父类的格式;(一个普通的类定义)
public class 父类名称 ｛
  //...
｝

定义子类的格式：
public class 子类名称 extends 父类名称 ｛
   //...
｝
 */
public class ExtendsText01 {

    public static void main(String[] args) {

        //创建了一个子类对象
        Teacher teacher = new Teacher();
        //Teacher类当中虽然什么都没写，但是会继承来自父类的method方法
        teacher.method();

        //创建另一个子类：助教，的对象
        Assistant assistant = new Assistant();
        //Assistant类中也是什么都没写
        assistant.method();
    }
}


/*
在父子类的继承关系中，如果成员变量重名，则创建子类对象的时候，有两种访问方式：

（1）直接通过子类对象访问成员变量：
    等号左边是谁，就优先使用谁，没有则向上找
（2）间接通过成员方法访问成员变量：
    该方法属于谁，就优先使用谁，没有则向上找
 */
class ExtendsText02 {
    public static void main(String[] args) {
        //创建父类对象
        Fu fu = new Fu();
        System.out.println(fu.numFu);//只能使用父类的东西，没有任何子类的内容
        System.out.println("==============");


        Zi zi = new Zi();

        System.out.println(zi.numFu);//10
        System.out.println(zi.numZi);//20
        System.out.println("===============");


        //等号左边是谁，就优先用谁
        System.out.println(zi.num);//优先子类，200
//        System.out.println("abc");//子类、父类到处都没有abc，会编译报错！
        System.out.println("===============");

        //这个方法是子类的，会优先使用子类的，没有再往上找
        zi.methodZi();//200
        //这个方法是在父类当中定义的，属于父类，被子类调用
        zi.methodFu();//100


    }
}


/*
局部变量：           直接写成员变量名
本类的成员变量：     this.成员变量名
父类的成员变量;      super.成员变量名
 */
class ExtendsText03 {
    public static void main(String[] args) {
        Zi01 zi = new Zi01();

        zi.method();
    }
}


/*
在父子类的继承当中，创建子类对象，访问成员方法的规则;
    创建的对象是谁，就优先使用谁，如果没有则向上找。

    【注意事项】
    无论是成员方法还是成员变量，如果没有都是向上找父类，绝不会向下找子类的。

    重写（）
    概念：在继承关系当中，方法的名称一样，参数列表也一样。

    重写（）：方法的名称一样，参数列表【也一样】。也叫覆盖、覆写。
    重载（）：方法的名称一样，参数列表【不一样】。

    方法的覆盖重写的特点：创建的是子类对象，则优先使用子类方法。即new了谁就优先使用谁
 */
class ExtendsText04 {
    public static void main(String[] args) {
        Zi02 zi = new Zi02();

        zi.methodFu02();
        zi.methodZi02();

        //创建的是new了子类对象，所以优先使用子类方法
        zi.method();
    }
}




/*
【方法覆盖重写的注意事项】：

1.必须保证父子类之间方法的名称相同，参数列表也相同。
@Override:写在方法前面，用来检测是不是有效的正确覆盖重写。
【这个注释就算不写，只要满足要求也是正确的方法覆盖重写。但是推荐写注释方便查看是否出错！！！】

2.子类方法的返回值必须【小于等于】父类方法的返回值范围。
小扩展提示：java.lang.Object类是所有类的公共最高父类（祖宗类），java.lang.String就是的Object子类。

3.子类方法的权限必须【大于等于】父类方法的权限修饰符。（在应用中，大多数情况都为相等的修饰符）
小扩展提示：public > protected > (default) > private
备注：(default)不是关键字default，而是什么都不写，留空！！
 */




/*
对于已经有的类，尽量不要去修改，直接继承，再添加新的内容
 */
class ExtendsText05 {

    public static void main(String[] args) {
        Phone01 phone = new Phone01();
        phone.call();
        phone.send();
        phone.show();
        System.out.println("===============");

        NewPhone01 newphone = new NewPhone01();
        newphone.call();
        newphone.send();
        newphone.show();
    }
}



/*
继承关系中，父子类构造方法的访问特点：

1.子类构造方法当中有一个默认的隐含的"super()"调用，所以一定是先调用的父类构造，后执行的子类构造。
2.子类构造可以通过super关键字来调用父类重载构造。
3.super的父类构造调用，必须是子类构造方法的第一个语句。不能是一个子类构造调用多次super构造。
总结：
子类必须调用父类构造方法，不写则赠送super();写了则用写的指定的super调用,super只能有一个，还必须是第一个。

 */
class ExtendsText06 {

    public static void main(String[] args) {

        Zi04 zi = new Zi04();

    }
}


/*
super和this关键字的使用
 */
class ExtendsText07 {

    public static void main(String[] args) {
        Zi07 zi = new Zi07();
        zi.show();
        zi.method();//先执行父类方法，再调用子类方法
    }
}

/*
【java语言继承的三个特点】：

1.java语言是单继承的。一个类当中的直接父类只能有唯一的一个。
2.java语言可以多级继承。（我有一个父亲，我父亲还有一个父亲，也就是爷爷）。
3.一个子类的直接父类是唯一的，但是一个父类可以拥有很多个子类（很多个兄弟姐妹）。

 */