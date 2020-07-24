package text;

/**
 * 定义一个类，用来模拟“手机”事物
 * 属性：品牌，价格，颜色
 * 行为：打电话，发短信
 *
 * 对应到类中：
 * 成员变量（属性）：
 *      String brand;//品牌
 *      double price;//价格
 *      String color;//颜色
 *  成员方法（行为）：
 *       public void call( String who) {} //打电话
 *       public void sendMessage( ) {} //群发消息
 */
public class Phone {

    //成员变量
    String brand;//品牌
    double price;//价格
    String color;//颜色

    //成员方法
    public void call(String who) {
        System.out.println("给"+who+"打电话");
    }
    public void sendMessage() {
        System.out.println("群发短信");
    }
}


/**
 * 局部变量和成员变量的区别
 *
 * 1.定义的位置不一样【重点】
 * 局部变量：在方法的内部
 * 成员变量：在方法的外部，直接写在类当中
 *
 * 2.作用范围不一样【重点】
 * 局部变量：只有在方法中才可以使用，出了方法就不能再用
 * 成员变量：整个类全都可以通用
 *
 * 3.默认值不一样【重点】
 * 局部变量：没有默认值，如果要想使用，必须手动进行赋值
 * 成员变量：如果没有赋值，会有默认值，规则和数组一样
 *
 * 4.内存的位置不一样（了解）
 * 局部变量：位于栈内存2
 * 成员变量：位于堆内存
 *
 * 5.生命周期不一样（了解）
 * 局部变量：随着方法进栈而诞生，随着方法出栈而消失
 * 成员变量：随着对象创建而诞生，随着对象被垃圾回收而消失
 */

class VariableDifference {
    String name;//成员变量

    public  void  methodA() {
        int num = 20;//局部变量
        System.out.println(num);
        System.out.println(name);
    }
    public void methodB() {
 //       System.out.println(num);//错误写法！
        System.out.println(name);
    }
    public void methodC() {
        int age;//局部变量，不赋值不能用
 //       System.out.println(age);//错误写法！没赋值不能用
    }
    public void methodD(int param) {
        //方法参数就是局部变量
        //参数在方法调用的时候，必然会被赋值的！
        System.out.println(param);

    }
}