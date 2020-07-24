package iotest.IO_Advanced;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流,也叫高效流，是对4个基本的 FileXxx 流的增强，所以也是4个流，按照数据类型分类：
 * 字节缓冲流： BufferedInputStream ， BufferedOutputStream
 * 字符缓冲流： BufferedReader ， BufferedWriter
 *
 * 缓冲流的【基本原理】，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO
 * 次数，从而提高读写的效率
 */
public class BufferedOutputStreamTest {

    public static void main(String[] args) throws IOException {
        //1.创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("fos1,txt");
        //2.创建字节缓冲输出流对象，构造方法中传递字节输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(fos);//此处使用默认缓冲区大小，也可以自定义缓冲区大小 BufferedOutputStream(fos， 1024)
        //3.使用字节缓冲输出流中的方法，将数据写入内部缓冲区
        bos.write("我把数据写入内部缓冲区".getBytes());
        //4.将缓存区的数据刷新到文件中
//        bos.flush();//可以省略不写
        //5.释放资源（先刷新,再释放资源）
        bos.close();
    }
}
