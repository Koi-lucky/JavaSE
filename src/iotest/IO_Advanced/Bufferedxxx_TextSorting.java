package iotest.IO_Advanced;

import java.io.*;
import java.util.HashMap;

/**
 * 【缓冲流的练习】对文本的内容进行排序（按照文本序号排序） prop文本
 *
 * 分析：
 *      1.创建一个HashMap集合对象，key:存储每行文本的序号；value:存储每行的文本
 *      2.创建字符缓冲输入流对象，构造方法中绑定字符输入流
 *      3.创建字符缓冲输出流对象，构造方法中绑定字符输出流
 *      4.使用字符缓冲输入流中的方法readLine，逐行读取文本
 *      5.对读取到的文本进行切割，获取行中的序号和文本内容
 *      6.把切割好的序号和文本内容存储到HashMap集合中（key序号是有序的，集合会自动进行排序）
 *      7.遍历HashMap集合，获取每一个键值对
 *      8.把每一个键值对，拼接为一个文本行
 *      9.把拼接好的文本，使用字符输出流中的方法write，写入到文件中
 *      10.释放资源
 */
public class Bufferedxxx_TextSorting {

    public static void main(String[] args) throws IOException {
        //1.创建一个HashMap集合对象，key:存储每行文本的序号；value:存储每行的文本
        HashMap<String, String> map = new HashMap<>();
        //2.创建字符缓冲输入流对象，构造方法中绑定字符输入流
        BufferedReader br = new BufferedReader(new FileReader("prop.txt"));
        //3.创建字符缓冲输出流对象，构造方法中绑定字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("prop1.txt"));
        //4.使用字符缓冲输入流中的方法readLine，逐行读取文本
        String line;
        while ((line = br.readLine()) != null) {
            //5.对读取到的文本进行切割，获取行中的序号和文本内容
            String[] ss = line.split("\\.");
            //6.把切割好的序号和文本内容存储到HashMap集合中（key序号是有序的，集合会自动进行排序
            map.put(ss[0], ss[1]);
        }
        //7.遍历HashMap集合，获取每一个键值对
        for(String key : map.keySet()) {
            //8.把每一个键值对，拼接为一个文本行
            //9.把拼接好的文本，使用字符输出流中的方法write，写入到文件中
            bw.write(key + "." + map.get(key));
            bw.newLine();
        }
        //10.释放资源
        bw.close();
        br.close();
    }
}
