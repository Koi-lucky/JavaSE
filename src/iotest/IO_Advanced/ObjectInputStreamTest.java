package iotest.IO_Advanced;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 【对象的反序列化流】—— ObjectInputStream ——把文件中保存的对象，以流的方式读取使用
 *
 * 使用步骤;
 *      1.创建一个ObjectInputStream对象，构造方法中传递字节输出流
 *      2.使用ObjectInputStream对象中的readObject方法，读取保存对象的文件
 *      3.释放资源
 *      4.使用一下读取出来的对象(打印)
 *
 * 【反序列化的前提】
 *      1.类必须实现Serializable
 *      2.必须存在类对应的class文件
 */
public class ObjectInputStreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.创建一个ObjectInputStream对象，构造方法中传递字节输出流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
        //2.使用ObjectInputStream对象中的readObject方法，读取保存对象的文件
        Object o = ois.readObject();//返回的是Object类型的对象
        //3.释放资源
        ois.close();
        //4.使用一下读取出来的对象(打印)
        System.out.println(o);
        //或者输出的时候使用强转
        Person p = (Person)o;
        System.out.println(p.getName() + p.getAge());
    }
}
