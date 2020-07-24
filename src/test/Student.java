package text;
/**类的定义：

定义一个类，用来模拟“学生”事物。其中就有两个组成部分：

属性（是什么）：
    姓名
    年龄
行为（能做什么）：
    吃饭
    睡觉
    学习

对应到Java的类当中：

成员变量（属性）：
    String name;//姓名
    int age;//年龄
成员方法（行为）：
    public void eat {};//吃饭

定义一个类的时候的注意事项：
1.成员变量的定义在类中方法外
2.成员方法去掉static关键字
 */

public class Student {
    //成员变量
     String name;//姓名
    private int age;//年龄

    //成员方法
    public void eat() {
        System.out.println("吃饭饭！");
    }
    public void sleep() {
        System.out.println("睡觉觉！");
    }
    public void study() {
        System.out.println("学习！");
    }
    public void setAge (int num) {
        if (num < 100 && num > 0) {
            age = num;
        } else {
            System.out.println("输入的数值无效！");
        }
    }
    public int getAge () {
        return age;
    }
    public void setAge () {
        this.age = age;
    }

}
