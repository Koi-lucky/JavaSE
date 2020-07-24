package iotest.IO_Advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

    public static void main(String[] args) throws IOException {
        //1.创建字符缓冲输入流对象（构造方法中传入字符输入流对象）
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        //2.使用字符缓冲输入流中的特有方法 read/readLine 读取文本
        //此处使用 特有方法 —— readLine()读一行数据
       /*
        String line = br.readLine();
        System.out.println(line);//读一行数据
        */
        //加循环，让读全部数据
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        //3.释放资源
        br.close();
    }
}
