package iotest.IO_Foundation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 *  java.util.Properties 继承于 Hashtable ，来表示一个持久的属性集。
 *  它使用键值结构存储数据，每个键及其对应值都是一个字符串。
 *  该类也被许多Java类使用，比如获取系统属性时， System.getProperties 方法就是返回一个 Properties 对象。
 *
 *  1.Properties集合存储、遍历取出数据
 *  2.Properties集合的store方法——> 把集合中的临时数据持久化的写入到硬盘中存储
 *  3.Properties集合的load方法 —— 把硬盘中保存的文件（键值对），读取到集合中使用
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        //1.Properties集合存储、遍历取出数据

        //创建Properties集合对象
        //因为Properties是一双列集合，key和value都是String，所以不用写泛型
        Properties prop1 = new Properties();
        //使用setProperty方法，往集合中添加元素
        prop1.setProperty("赵丽颖", "168");
        prop1.setProperty("杨幂", "165");
        prop1.setProperty("关晓彤", "170");
        prop1.setProperty("范冰冰", "172");
        //使用stringPropertyNames方法把Properties集合中的键取出，存储到一个set集合中
        Set<String> set = prop1.stringPropertyNames();
        //遍历set集合，取出Properties集合的每一个键
        for (String s : set) {
            //使用getProperty方法通过key获取value
            System.out.println( s + " -> " + prop1.getProperty(s));
        }

        System.out.println("=====================");

        //2.Properties集合的store方法——> 把集合中的临时数据持久化的写入到硬盘中存储
        //使用步骤：
        //1.创建集合对象 ——> 2.创建字节输出流/字符输出流对象 ——> 3.使用Properties中的store方法 ——> 4.释放资源

        Properties prop2 = new Properties();
        prop2.setProperty("赵丽颖", "168");
        prop2.setProperty("杨幂", "165");
        prop2.setProperty("关晓彤", "170");
        prop2.setProperty("范冰冰", "172");
        //字节流不支持中文！字符流支持中文
        FileWriter fw = new FileWriter("fw2.txt");//这里使用字符流
        prop2.store( fw, "save data");
        fw.close();


        //3.Properties集合的load方法 —— 把硬盘中保存的文件（键值对），读取到集合中使用
        //使用步骤：
        //1.创建集合对象 ——> 2.使用集合中的方法load ——> 3.遍历集合
        /**
         * 注意事项：
         *          1.存储键值对的文件中，键与值默认的连接符号，可以使用=，空格，或其它符号
         *          2.存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再被读取
         *          3.存储键值对的文件中，键与值默认都是字符串，不用再加引号
         */
        Properties prop3 = new Properties();
        prop3.load(new FileReader("fw2.txt"));//这里使用字符流
        Set<String> set1 = prop1.stringPropertyNames();
        for (String s : set1) {
            //使用getProperty方法通过key获取value
            System.out.println( s + " -> " + prop3.getProperty(s));
        }

    }
}
