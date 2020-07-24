package com;

/**
 * 【可变参数】的使用
 * 1.使用前提
 *       当方法的 参数列表数据类型 已经确定，但是 参数的个数 不确定，就可以使用可变参数
 * 2.使用格式：定义方法的时候使用
 *      修饰符    返回值类型    方法名（数据类型...变量名）｛｝
 * 3.原理
 *      可变参数的底层就是一个数组，根据传递参数的不同，会创建不同长度的数组，来存储这些值
 *      传递的参数个数，可以是0个（不传递），1,2，...多个
 * 4.注意事项
 *      （1）一个方法的参数列表，只能有一个可变参数
 *      （2）如果方法有多个参数，那么可变参数就必须写在参数列表的末尾
 */
public class VarArgsTest {

    public static void main(String[] args) {
        //测试多个数求和的方法
        System.out.println(add(10,20));
        System.out.println(add(10,20,30,40,50,60,70,80,90,100));

        //测试方法有多个参数，那么可变参数就必须写在参数列表的末尾
        method("小明", 25.2, 15, 10,20,30,40);

        //测试参数列表的终极写法
        EndMethod("张三", 100, 56.564, 'A');
    }

    /**
     * 例题：定义计算（0-n）整数和的方法
     * 已知：计算整数的和，但具体不知道计算几个整数的和，就可以使用参数列表
     */
    private static int add(int...arr) {
        //定义一个初始化变量，用于记录求和后的数值
        int sum = 0;
        //遍历数组，获取数组的每一个元素
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    //（1）一个方法的参数列表，只能有一个可变参数
    // 以下这种写法是错误的
//    public static void method(int...a,String...b) {}


    //（2）如果方法有多个参数，那么可变参数就必须写在参数列表的末尾
    public static void method(String b, double c, int d, int...a) {}


    //参数列表的终极写法
    public static void EndMethod(Object...obj) {}//传什么数据类型都可以
}
