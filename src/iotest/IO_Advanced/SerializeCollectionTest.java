package iotest.IO_Advanced;

import java.io.*;
import java.util.ArrayList;

/**
 * 【序列化集合的练习】
 *      要求：
 *          1.将存有多个自定义对象的集合序列化操作，保存到list.txt文件中
 *          2.反序列化list.txt，并遍历集合，打印对象信息
 *      分析：
 *          1.把若干学生对象保存到集合中
 *          2.把集合序列化
 *          3.反序列化读取时，只需读取一次，转换为集合类型
 *          4.遍历集合，打印所有的学生信息
 */
public class SerializeCollectionTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.定义一个存储若干个对象的集合
        ArrayList<Person> list = new ArrayList<>();
        //2.把若干学生对象保存到集合中
        list.add( new Person("张三", 159));
        list.add( new Person("李四", 178));
        list.add( new Person("王五", 172));
        list.add( new Person("王麻子", 180));
        list.add( new Person("张翠花", 164));
        //3.创建一个集合序列化的对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list.txt"));
        //4.使用集合序列化流中的writeObject方法，对集合进行序列化
        oos.writeObject(list);
        //5.创建一个反序列化对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("list.txt"));
        //6.使用，反序列化中的readObject方法，读取文件中保存的集合
        Object o = ois.readObject();
        //7.将Object强转为ArrayList<Person>类型
        ArrayList<Person> list2 = (ArrayList<Person>)o;
        //8.遍历ArrayList<Person>集合
        for (Person p : list2) {
            System.out.println(p);
        }
        //9.释放资源
        ois.close();
        oos.close();
    }
}
