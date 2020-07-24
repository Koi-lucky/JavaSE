package extendstest;

//定义一个父类：员工
public class Employee {

    public void method() {
        System.out.println("方法执行了！");
    }
}

//定义一个员工的子类：助教
class Assistant extends Employee {

}


//定义一个员工的子类：讲师
class Teacher extends Employee {

}


class Fu {
    int numFu = 10;
    int num = 100;

    public void methodFu() {
        //使用的是本类当中的，不会向下找子类
        System.out.println(num);
    }
}



class Zi extends Fu {
    int numZi = 20;
    int num = 200;

    public void methodZi() {
        //因为本类当中有num,所以会优先使用本类中的num
        System.out.println(num);
    }
}


class Fu01 {

    int num = 100;
}



class Zi01 extends Fu01 {
    int num = 200;

    public void method() {
        int num = 30;
        System.out.println(num);//30,局部变量
        System.out.println(this.num);//200,本类的成员变量
        System.out.println(super.num);//100，父类的成员变量
    }
}


class Fu02 {

    public void methodFu02() {
        System.out.println("父类方法执行！");
    }

    public void method() {
        System.out.println("父类重名方法执行！");
    }
}



class Zi02 extends Fu02 {

    public void methodZi02() {
        System.out.println("子类方法执行！");
    }

    public void method() {
        System.out.println("子类重名方法执行！");
    }
}



class Fu03 {

    public String method() {
        return null;
    }
}


class Zi03 extends Fu03{

    @Override//注释，代表着覆盖重写
    public String method() {
        return method();
    }
}


//之前的老款手机
class Phone01 {

    public void call() {
        System.out.println("打电话！");
    }

    public void send() {
        System.out.println("发短信！");
    }

    public void show() {
        System.out.println("来电显示！");
    }
}


//定义一个新手机，讲旧手机作为父类
class NewPhone01 extends Phone01{

    @Override
    public void show() {
    //    System.out.println("显示号码!");//这行代码不需要写，直接从父类中继承就可
        super.show();//直接把父类的show方法拿过来重复利用
        System.out.println("显示姓名!");
        System.out.println("显示头像!");
    }
}


class Fu04 {

    public Fu04() {
        System.out.println("父类方法执行！");
    }

    public Fu04(int num) {
        System.out.println("父类构造方法执行！");
    }

}

class Zi04 extends Fu04 {

    public Zi04() {
//        super();//在调用父类无参构造方法
       super(20);//在调用父类重载的构造方法
        System.out.println("子类方法执行！");
    }

    public void method() {
     //   super();//错误写法！只有子类构造方法，才能调用父类构造方法

    }
}




/*
super关键字的用法有三种：

1.在子类的成员方法当中，访问父类的成员变量
2.在子类的成员方法当中，访问父类的成员方法
3.在子类的构造方法当中，访问父类的构造方法

 */
class Fu05 {

    int num = 10;

    public void method() {
        System.out.println("父类方法！");
    }
}

class Zi05 extends Fu05 {

    int num = 20;

    public Zi05() {
        super();
    }

    public void methodZi() {
        System.out.println(super.num);//父类中的num
    }

    public void method() {
        super.method();//访问父类中的method
        System.out.println("子类方法！");
    }

}




/*
super关键字用来访问父类内容，而this关键字用来访问本类内容。用法也有三种：

1.在本类的成员方法中，访问本类的成员变量
2.在本类的成员方法中，访问本类的另一个成员方法
3.在本类的构造方法中，访问办呢累的另一个构造方法
【在第三种用法当中也要注意】：
A.this(...)调用也必须是构造方法中的第一个语句，唯一的一个！不能多次调用！
B.super和this两种构造调用，不能同时使用，只能用其中的一个

 */
class Fu06 {

    int num = 30;
}

class Zi06 extends Fu06 {

    int num = 20;

    public Zi06() {
     //   super();//这一行不再赠送
        this(123);//本类当中的无参构造，调用本类的有参构造
     //   this(10,30);//错误写法！

    }

      public Zi06(int n) {
        this(10,32);

    }
      public Zi06(int n,int m) {
     //   this();//错误写法！不能循环回来调用！

    }

    public void showNum() {
        int num = 0;
        System.out.println(num);//局部变量
        System.out.println(this.num);//本类中的成员变量
        System.out.println(super.num);//父类中的成员变量
    }

    public void methodA() {

        System.out.println("AAA");
    }

    public void methodB() {
        this.methodA();
        System.out.println("BBB");

    }
}



class Fu07 {

    int num = 10;

    public void method() {
        System.out.println("父类方法！");
    }
}

class Zi07 extends Fu07 {

    int num = 20;

    @Override
    public void method() {
        super.method();//调用了父类方法
        System.out.println("子类方法！");
    }

    public void show() {
        int num = 30;
        System.out.println(num);//30（局部变量）
        System.out.println(this.num);//20（本类中的成员变量）
        System.out.println(super.num);//10（父类中的成员变量）
    }
}

