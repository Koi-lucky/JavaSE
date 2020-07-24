package iotest.IO_Advanced;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {

    public static void main(String[] args) throws IOException {
        //创建字节数入流对象
        FileInputStream fis = new FileInputStream("fos1.txt");
        //创建字节缓冲输入流对象，并在其构造方法中传入字节数入流对象
        BufferedInputStream bis = new BufferedInputStream(fis);
        /*
        //读取一个字节
        int len = 0;
        while ((len = bis.read()) != -1) {
            System.out.println(len);
        }
        */
        //读取一定数量的字节
        byte[] bytes = new byte[1024];//存储每次读取的数据
        int len = 0;//记录每次读取的有效字节的个数
        while ((len = bis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //释放资源
        bis.close();
    }
}
