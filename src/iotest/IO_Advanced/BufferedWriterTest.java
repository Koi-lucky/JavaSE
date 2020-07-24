package iotest.IO_Advanced;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

    public static void main(String[] args) throws IOException {
        //1.创建字符缓冲输出流对象（构造方法中传递字符输出流）
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        //2.调用字符缓冲输出流中的write方法，将数据写入内部缓冲区
        for (int i = 0; i < 10; i++) {
            bw.write("Java你好");
            //bw.write("\r\n");
            bw.newLine();//换行！【特有的方法】
        }
        //3.刷新缓冲区的数据到文件中去
        bw.flush();
        //4.释放资源
        bw.close();
    }
}
