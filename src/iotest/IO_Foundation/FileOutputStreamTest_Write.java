package iotest.IO_Foundation;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
 *  public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
 *   小贴士：
 *       close方法，当完成流的操作时，必须调用此方法，释放系统资源
 *
 *
 * 1.写出字节数据
 *          public abstract void write(int b) ：将指定的字节输出流。
 *          public void write(byte[] b) ：将 b.length字节从指定的字节数组写入此输出流。
 *          public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
 *
 * 2.数据的追加续写
 *          每次程序运行，创建输出流对象，都会清空目标文件中的数据。如何保留目标文件中数据，还能继续添加新数据呢？
 *          public FileOutputStream(File file, boolean append) ： 创建文件输出流以写入由指定的 File对象表示的文件。
 *          public FileOutputStream(String name, boolean append) ： 创建文件输出流以指定的名称写入文件。
 *          这两个构造方法，参数中都需要传入一个boolean类型的值， true 表示追加数据， false 表示清空原有数据
 *
 * 3.写出换行
 *     回车符 \r 和换行符 \n ：
 *                      回车符：回到一行的开头（return）。
 *                      换行符：下一行（newline）。
 *    系统中的换行：
 *                      Windows系统里，每行结尾是 回车+换行 ，即 \r\n ；
 *                      Unix系统里，每行结尾只有 换行 ，即 \n ；
 *                      Mac系统里，每行结尾是 回车 ，即 \r 。从 Mac OS X开始与Linux统一
 */
public class FileOutputStreamTest_Write {

    public static void main(String[] args) throws IOException {
        // 1.写出字节数据

        // （1）写出字节
        //使用文件名创建流对象
        FileOutputStream fos1 = new FileOutputStream("fos1.txt");
        //写入数据
        fos1.write(97);
        fos1.write(98);
        fos1.write(99);//abc
        //关闭资源
        fos1.close();

        // （2）写出字节数组
        //使用文件名创建流对象
        FileOutputStream fos2 = new FileOutputStream("fos2.txt");
        //将字符串转换为字节数组
        byte[] b = "你好Java".getBytes();
        //写入字节数组数据
        fos2.write(b);//你好Java
        //关闭资源
        fos2.close();

        // （3）写出指定长度的字节数组
        //使用文件名创建流对象
        FileOutputStream fos3 = new FileOutputStream("fos3.txt");
        //将字符串转换为字节数组
        byte[] c = "abcdefg".getBytes();
        //写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd
        fos3.write( c, 2, 2);//cd
        //关闭资源
        fos3.close();


        // 2.数据的追加续写
        //使用文件名创建流对象
        FileOutputStream fos4 = new FileOutputStream("fos3.txt", true);
        //将字符串转换为字节数组
        byte[] d = "你好".getBytes();
        //追加写入数据
        fos4.write(d);//cd你好
        //关闭资源
        fos4.close();


        // 3.写出换行
        //使用文件名创建流对象
        FileOutputStream fos5 = new FileOutputStream("fos5.txt");
        //定义字节数组
        byte[] words = { 97, 98, 99, 100, 101, 102};
        //遍历数组
        for (int i = 0; i < words.length; i++) {
            //写出一个字节
            fos5.write(words[i]);
            //写出一个换行，换行符转成字节数组写出
            fos5.write("\r\n".getBytes());
        }
        //关闭资源
        fos5.close();
    }
}
