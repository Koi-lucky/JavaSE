package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 1.测试一下 【泛型通配符】 的使用
 * 【泛型的通配符】 ？ ——> 代表任意的数据类型
 *      使用方式：不能创建对象使用，只能作为方法的参数使用
 *
 * 2.测试一下通配符的高级使用 —— 【受限泛型】（设置泛型的时候，可以指定泛型的上限和下限）
 *      泛型的【上限】限定： ？ extends  E  代表使用的泛型只能是 E 类型的 子类或本身
 *      泛型的【下限】限定： ？ super  E  代表使用的泛型只能是 E 类型的 父类或本身
 */
public class TestGeneric {

    public static void main(String[] args) {
        //1.测试通配符使用
        //创建两个不同类型的列表，并使用同一个遍历的方法进行遍历
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("张三");
        list2.add("王五");
        list2.add("李四");
        list2.add("王麻子");

        printArray(list1);
        System.out.println();
        System.out.println("==========");
        printArray(list2);
        System.out.println();

        System.out.println("=======================");

        //2.测试通配符的高级使用
        Collection<Integer> list3 = new ArrayList<>();
        Collection<String> list4 = new ArrayList<>();
        Collection<Number> list5 = new ArrayList<>();
        Collection<Object> list6 = new ArrayList<>();

        getElement1(list3);
//        getElement1(list4);//报错
        getElement1(list5);
//        getElement1(list6);//报错

//        getElement2(list3);//报错
//        getElement2(list4);//报错
        getElement2(list5);
        getElement2(list6);
        //类与类之间的继承关系
        //Integer extends Number extends Object
        // String extends Object
    }

    private static void printArray(ArrayList<?> list) {
        //使用 迭代器 遍历集合
        Iterator<?> it = list.iterator();
        while(it.hasNext()) {
            //it.next() 方法，取出的元素是Object类型，可以接收任意类型的数据
            System.out.print(it.next() + " ");
        }
    }

    //泛型的上限限定：此时的泛型？必须是Number类型或者Number类型的子类
    public static void getElement1(Collection<? extends Number> coll) {};
    //泛型的下限限定：此时的泛型？必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll) {};
}
