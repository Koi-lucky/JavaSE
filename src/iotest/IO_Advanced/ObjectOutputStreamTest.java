package iotest.IO_Advanced;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 【对象的序列化流】—— ObjectOutputStream ——就是把对象，以流的方式写入文件中，永久的保存
 *
 * 使用步骤：
 *      1.创建ObjectOutputStream对象，构造方法中传递字节输出流
 *      2.使用ObjectOutputStream中的writeObject，把对象写入到文件中
 *      3.释放资源
 *
 * 【注意事项！！！】
 *      序列化和反序列化都必须继承Serializable接口，
 *      （因为Serializable接口就相当于一个标志，这个标志提醒编译器这是一个序列化流）
 *
 * 【static关键字 和 transient关键字】
 *          static ：静态关键字
 *                  静态优先于非静态加载到内存中（静态优先于对象加载到内存中）
 *                  被static修饰的变量是不能被序列化的！！！序列化的都是对象
 *          transient ：瞬态关键字
 *                  被transient修饰的成员变量是不能被序列化的！！！
 */
public class ObjectOutputStreamTest {

    public static void main(String[] args) throws IOException {
        //1.创建ObjectOutputStream对象，构造方法中传递字节输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
        //2.使用ObjectOutputStream中的writeObject，把对象写入到文件中
        oos.writeObject(new Person("小李", 18));
        //3.释放资源
        oos.close();
    }
}

class Person implements Serializable {//Serializable接口里面没有任何方法
    //手动的、显示添加一个序列号
    //目的是：在修改类的时候，会导致person.class和person.txt的序列号不一致，产生异常，所以手动的添加一个序列号，不管你类怎么改动，都可以进行序列化
//    private static final long serialVersoinUID = 10L;//自己设置序列号（让他恒久不变）
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}