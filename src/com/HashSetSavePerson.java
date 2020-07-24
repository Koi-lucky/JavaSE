package com;

import java.util.HashSet;
import java.util.Objects;

/**
 * 【HashSet】存储自定义类型的元素（String、……Integer、Person、……） —— 哈希集合中的元素唯一，不能重复
 * 【注意事项】 —— 自定义 HashSet 的存储元素 ，
 *          ！！！必须重写 【 hashCode 和 equals 】方法，
 *          ！！！如果不重写这两个方法，这个哈希表就会出现重复的值，不能达到创建哈希集合的意图
 */
public class HashSetSavePerson {

    public static void main(String[] args) {
        //创建哈希集合，存储Persons对象
        HashSet<Persons> set = new HashSet<>();
        //创建Persons对象,并加入到哈希集合中
        Persons p1 = new Persons("张小花", 18);
        Persons p2 = new Persons("张小花", 25);
        Persons p3 = new Persons("张晓晓", 20);
        Persons p4 = new Persons("张小花", 18);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.println(set);
    }
}


//自定义方法
class Persons {//我们认定：只有当两个人的 姓名+年龄 同时相同时，才判定这两个人是同一个人
    private String name;
    private int age;

    public Persons() {
    }

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Persons{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return age == persons.age &&
                Objects.equals(name, persons.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}