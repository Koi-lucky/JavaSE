package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 【一、迭代器的使用】
 * 一共三个方法：
 * 1.使用集合中的方法 iterator() 获取迭代器的实现类对象，使用 Iterator 接口接收（多态）
 * 2.使用Iterator接口中的方法hasNext() ——> 判断还有没有下一个元素
 * 3.使用Iterator接口中的方法next() ——> 取出集合中的下一个元素
 *
 * 【二、增强for循环的使用】 —— 增强for 底层使用的也是迭代器，使用了for循环的格式，简化了迭代器的书写
 *  增强for循环，仅仅只能用来遍历集合和数组 —— 不能用于其他操作，并且遍历的目标只能是集合/数组
 *  格式：for(集合/数组的数据类型  变量名：集合名/数组名) {
 *      sout(变量名);
 *  }
 */
public class TestIterator {

    public static void main(String[] args) {
        //一、Iterator接口 的使用
        //创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        // 往集合中添加元素
        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        coll.add("张麻子");
        coll.add("翠花");
        coll.add("小黑");
        //1.使用集合中的方法 iterator() 获取迭代器的实现类对象，使用 Iterator 接口接收
        //Iterator<E> 接口也是有泛型的，迭代器的泛型 跟着 集合走，集合是什么类型，迭代器就是什么泛型
        Iterator<String> it = coll.iterator();
        //2.使用Iterator接口中的方法hasNext() ——> 判断还有没有下一个元素(boolean 值，要是有下一个元素就返回true,否则返回false)
        while(it.hasNext()) {
            //3.使用Iterator接口中的方法next() ——> 取出集合中的下一个元素
            System.out.println(it.next());
        }

        System.out.println("====================");

        //二、增强for循环的使用（for each循环）
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");
        //使用增强for 遍历数组/集合
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("=========");
        //使用迭代器遍历集合/数组
        Iterator<String> itt = list.iterator();
        while(itt.hasNext()) {
            System.out.println(itt.next());
        }
    }
}
