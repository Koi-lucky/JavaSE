package iotest.IO_Advanced;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 【读文件——>字节转字符】—— 用 InputStreamReader，可以指定编码格式，默认是utf-8
 *
 * 使用步骤：
 *          1.创建InputStreamReader对象，构造方法中传入 字节数入流对象和 编码格式
 *          2.使用InputStreamReader对象中的 read方法，把字节转为字符
 *          3.释放资源
 *
 */
public class InputStreamReaderTest {

    public static void main(String[] args) throws IOException {
        //读取文件时：
        //文件是什么编码，就用什么编码读（否则会发生乱码）

        //转成gbk格式
        InputStreamReader isr1 = new InputStreamReader(new FileInputStream("utf-8(1).txt"), "utf-8");
        int len1 = 0;
        while ((len1 = isr1.read()) != -1) {
            System.out.println((char) len1);
        }
        isr1.close();
        //默认格式
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream("utf-8(2).txt"));
        int len2 = 0;
        while ((len2 = isr2.read()) != -1) {
            System.out.println((char) len2);
        }
        isr2.close();
        //gbk格式
        InputStreamReader isr3 = new InputStreamReader(new FileInputStream("gbk.txt"), "gbk");
        int len3 = 0;
        while ((len3 = isr3.read()) != -1) {
            System.out.println((char) len3);
        }
        isr3.close();
    }
}
