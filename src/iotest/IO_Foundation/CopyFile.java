package iotest.IO_Foundation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 【文件复制练习】—— 一读一写
 * 明确：
 *      数据源：fos1.txt
 *      数据复制的目的地：F:\BaiduNetdiskDownload\ideaProject\text\111\fos1.txt
 *
 * 文件复制的步骤：
 *      1.创建一个字节输入流对象，构造方法中绑定要读取的数据源
 *      2.创建一个字节输出流，构造方法中绑定要写入的目的地
 *      3.使用字节输入流对象中的方法read读取文件
 *      4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
 *      5.释放流资源
 */
public class CopyFile {

    public static void main(String[] args) throws IOException {
        //1.创建一个字节输入流对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("fos1.txt");
        //2.创建一个字节输出流，构造方法中绑定要写入的目的地
        FileOutputStream fos = new FileOutputStream("F:\\BaiduNetdiskDownload\\ideaProject\\text\\111\\fos1.txt");
        //3.使用字节输入流对象中的方法read读取文件
       /*
       //一次读取一个字节，写入一个字节的方法
        int len = 0;
        while((len = fis.read()) != -1) {
            fos.write(len);//效率太低了！！
        }
        */
        //使用数组缓冲读取多个字节，写入多个字节
        int len = 0;
        byte[] b = new byte[1024];//使用数组缓冲读取多个字节，写入多个字节
        while((len = fis.read(b)) != -1) {
            //4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
            fos.write(b, 0, len);
        }
        //5.释放流资源（先关写的，后关读的；如果写完了，肯定就读完了）
        fos.close();
        fis.close();
    }
}
