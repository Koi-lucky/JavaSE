package extendstest;

/**
 * 问题描述：定义Person的年龄时，无法阻止不合理的数设置进来。（比如年龄为负值也可传递过来）
 * 解决方案：用private关键字将需要保护的成员变量进行修饰
 *
 * 一旦使用了private进行修饰,那么本类当中仍然可以随意访问
 *!!!但是一旦超出了本类范围之外就不能再直接访问了
 *
 * 间接访问private成员变量，就是定义一对Getter/Setter方法
 * Getter/Setter方法命名规则：
 *      1.必须叫setXxx或者是getXxx
 *      2.对于Getter来说，不能有参数值，但有返回值，返回值类型和成员变量对应
 *        对于Setter来说，有参数值，不能有返回值，参数类型必须要和成员变量对应
 *
 *
 *  【重点】    特例：对于基本类型当中的boolean值，Getter方法一定要写成isXxx形式，而setXxx规则不变
 *                      在类中则有：
 *                      private boolean isMale;//是不是男生
 *
 *                      public void setMale(boolean b) {
 *  *                          male=b;
 *  *                      }
 *                      public boolean isMale() {
 *                          return male;
 *                      }
 *                     在方法中则有：
 *                     ph.setMale(false);
 *
 *                     System.out.println(ph.isMale());
 *
 *
 */
public class Person {

    String name;//姓名//也可以private，字符串类型，setName/getName
    private int age;//年龄//直接在int age前加private

    public void show() {
        System.out.println("我叫："+name+"年龄："+age);
    }

    //这个成员方法，专门用于向age设置数据
    //Setter方法（set什么-首字母大写）：有参数值，没返回值，参数类型必须和要set的东西保持一致
    public void setAge(int num) {//往里放age,有参数没有返回值
        if(num < 100 && num >=0 ) {//如果是合理情况，if语句是数据对合理性的一个判断
            age = num;
        } else {
            System.out.println("输入的数据不合理！");
        }
    }

    //这个成员方法，专门私语获取age的数据
    //Getter方法（get什么-首字母大写）：没有参数值，但有返回值，返回值类型和成员变量一致
    public int getAge() {//往外拿age,没参数有返回值
        return age;
    }
}




class Person01 {
    static {
        System.out.println("静态代码块执行！");
    }

    public Person01() {
        System.out.println("构造方法执行！");
    }
}