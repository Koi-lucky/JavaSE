package iotest.IO_Foundation;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 【注意事项】字符流，只能操作文本文件，不能操作图片，视频等非文本文件。当我们单纯读或者写文本文件时 使用字符流 其他情况使用字节流
 *
 * FileWriter 类是写出字符到文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。
 * 【构造方法】
 * FileWriter(File file) ： 创建一个新的 FileWriter，给定要读取的File对象。
 * FileWriter(String fileName) ： 创建一个新的 FileWriter，给定要读取的文件的名称。
 * 当你创建一个流对象时，必须传入一个文件路径，类似于FileOutputStream
 *
 *
 * 1.写入字符
 *      void write(int c) 写入单个字符。
 * 2.写入字符数组
 *      void write(char[] cbuf) 写入字符数组。
 *      abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
 * 3.写入字符串
 *      void write(String str) 写入字符串。
 *      void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
 * 4.关闭和刷新
 *      flush ：刷新缓冲区，流对象可以继续使用。
 *      close ：先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了
 * 5.续写和换行
 *      操作类似于FileOutputStream
 */
public class FileWriterTest {

    public static void main(String[] args) throws IOException {
        //1.写入字符
        //使用文件名称创建流对象
        FileWriter fw1 = new FileWriter("fw1.txt");
        //写入单个字符（把数据写入内存缓冲区，字符转字节的过程）
        fw1.write(97);
        //把内存缓冲区中的数据，刷新到文件中
        fw1.flush();//刷新完之后还是要释放资源
        //刷新之后流可以继续使用
        fw1.write(98);
        //释放资源（会先把内存缓冲区中的数据刷新到文件中）
        fw1.close();
        //关闭之后，流已经关闭了，已经从内存中消失了，流就不能再使用了
//        fw1.write(99);//会出错，报异常


        // 2.写多个字符——字符数组
        FileWriter fw2 = new FileWriter("fw2.txt");
        char[] ch = {'a', 'b', 'c', 'd', 'e', 'f'};
        fw2.write(ch);//abcdef
        // 3.写字符数组的一部分
        fw2.write( ch, 1, 3);//abcdefbcd
        // 4.写字符串
        fw2.write("面向对象程序设计");//abcdefbcd面向对象程序设计
        // 5.写字符串的一部分
        fw2.write( "Java你好啊，世界你好", 4, 3);//abcdefbcd面向对象程序设计你好啊

        fw2.close();



        //6.续写和换行
        FileWriter fw = new FileWriter("fw.txt");
        for (int i = 0; i < 10; i++) {
//            fw.write("HelloWorld" + i);//续写（追加写）
            fw.write("HelloWorld" + i + "\r\n");//换行
        }
        fw.close();
    }
}
