package extendstest;

/**
 * 面向对象的三大特征：封装、继承、多态
 *
 * 封装性在Java当中的体现:
 * 1.方法就是一种封装
 * 2.关键字private也是一种封装
 *
 * 封装就是将一些细节信息隐藏起来，对于外界不可见
 */
//第一种封装：方法
public class SomeMethod {
    public static void main(String[] args) {
        int[] array = {5,15,25,20,100,600};

        int max = getMax(array);
        System.out.println("最大值"+max);
    }
    //给我一个数组，我换给你一个最大值
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}



//第二种封装：关键字private
class MethodPerson {
    public static void main(String[] args) {
        Person person = new Person();
        person.show();

        person.name = "赵丽颖";
//        person.age = 18;//直接访问private内容，错误写法！
        person.setAge(-20);//数据不合理，输出“输入的数据不合理！”
        System.out.println("================");
        person.setAge(20);
        System.out.println(person.getAge());//也可加输出getter语句进行输出
    }
}



class MethodStudent {
    public static void main(String[] args) {
        Student stu = new Student();
        //设置我自己的名字
        stu.name = "王健林";
        stu.sayHello("王思聪");

        System.out.println("===========");
        System.out.println(stu);//验证this.传过来的值是否就是地址值
        //经验证两地址值相等,所以this.起到了区分的作用
    }
}