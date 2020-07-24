package iotest.IO_Foundation;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *  public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
 *
 * 1.读取字节
 *      public abstract int read() ： 从输入流读取数据的下一个字节
 * 2.使用字节数组读取
 *      public int read(byte[] b) ： 从输入流中读取一些字节数，并将它们存储到字节数组 b中
 *
 * 3.String 类的构造方法
 *          String(byte[] bytes)：把字节数组转为字符串
 *          String(byte[] bytes, int offset, int length)：把字节数组的一部分转换为字符串
 *                                  offset：数组的开始索引
 *                                  length：转换的字节个数
 */
public class FileInputStream_read {

    public static void main(String[] args) throws IOException {
        //1.读取字节
        // read 方法，每次可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回 -1

        //使用文件名称创建流对象
        FileInputStream fis1 = new FileInputStream("fos1.txt");//文件中数据为abc
        //读取数据，返回一个字节
        /*
        int read = fis1.read();
        System.out.println((char)read);//a
        read = fis1.read();
        System.out.println((char)read);//b
        read = fis1.read();
        System.out.println((char)read);//c
        //读取到末尾，返回-1
        read = fis1.read();
        System.out.println(read);//-1
        */


        //代码改进，循环读取
        int b;//必须先定义变量存储，再进行读取，否则会出现错误
        while((b = fis1.read()) != -1) {
//            System.out.println(b);//98
            System.out.println((char)b);//将字节强制转换为对应的字符
        }

        //关闭资源
        fis1.close();



        //2.使用字节数组读取
        // read(byte[] b) ，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回 -1

        //使用文件名称创建流对象
        FileInputStream fis2 = new FileInputStream("fos4.txt");//文件中数据为abcdefgrhisj
        //定义变量，作为有效个数
        int len;
        //定义字节数组，作为装字节数据的容器
        byte[] c = new byte[5];//一次读取五个字节
        //循环读取
        while ((len = fis2.read(c)) != -1) {
            //每次读取后，把数组变成字符串打印
//            System.out.println(new String(c));//数据rhi是不存在的数据，是由于最后一次读取时，只读取两个字节 sj ，数组中，上次读取的数据没有被完全替换，所以要通过 len ，获取有效的字节
            System.out.println(new String(c, 0, len));//len 每次读取的有效字节个数
        }
        //关闭资源
        fis2.close();
    }
}
