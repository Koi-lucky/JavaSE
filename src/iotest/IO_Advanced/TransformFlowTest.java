package iotest.IO_Advanced;

import java.io.*;

/**
 * 【转换流的练习】—— 将gbk编码的文件，转换为utf-8编码的文本文件
 *
 * 分析：
 *      1.创建InputStreamReader对象，构造方法中传入 字节数入流对象和 编码格式gbk
 *      2.创建OutputStreamWriter对象，构造方法中传递 字节输出流和指定的编码表名称utf-8
 *      3.使用InputStreamReader对象中的 read方法，把字节转为字符(读取文件)
 *      4.使用OutputStreamWriter对象中的方法write，把字符转为字节存储到缓冲区中（把读取的数据写入文件中）
 *      5.释放资源
 */
public class TransformFlowTest {

    public static void main(String[] args) throws IOException {
        //1.创建InputStreamReader对象，构造方法中传入 字节数入流对象和 编码格式gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"), "gbk");
        //2.创建OutputStreamWriter对象，构造方法中传递 字节输出流和指定的编码表名称utf-8
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf8(3).txt"), "utf-8");
        //3.使用InputStreamReader对象中的 read方法，把字节转为字符(读取文件)
        int len = 0;
        while ((len = isr.read()) != -1) {
            //4.使用OutputStreamWriter对象中的方法write，把字符转为字节存储到缓冲区中（把读取的数据写入文件中）
            osw.write((char)len);
        }
        //5.释放资源
        osw.close();
        isr.close();
    }
}
