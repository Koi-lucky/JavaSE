package iotest.IO_Advanced;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 【写文件——>字符转字节】—— 用 OutputStreamWriter，可以指定编码格式，默认是utf-8
 *
 * 使用步骤：
 *      1.创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称
 *      2.使用OutputStreamWriter对象中的方法write，把字符转为字节存储到缓冲区中（编码）
 *      3.使用OutputStreamWriter中的方法flush，把内存缓冲区中的字节刷新到文件中（使用字节流写字节的过程）
 *      4.释放资源
 */
public class OutputStreamWriterTest {

    public static void main(String[] args) throws IOException {
        //【字符转字节】
        //指定utf-8格式
        OutputStreamWriter osw1 = new OutputStreamWriter(new FileOutputStream("utf-8(1).txt"), "utf-8");
        osw1.write("你好");
        osw1.flush();
        osw1.close();
        //默认utf-8格式
        OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream("utf-8(2).txt"));
        osw2.write("你好");
        osw2.flush();
        osw2.close();
        //指定gbk格式
        OutputStreamWriter osw3 = new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk");
        osw3.write("你好");
        osw3.flush();
        osw3.close();
    }
}
