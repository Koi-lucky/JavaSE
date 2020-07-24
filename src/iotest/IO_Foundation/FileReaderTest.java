package iotest.IO_Foundation;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader；文件字符输入流
 * 作用：把硬盘文件中的数据以字符的方式读取到内存中
 *          FileReader extends InputStreamReader extends Reader
 *
 * 【构造方法】
 * FileReader(File file) ： 创建一个新的 FileReader ，给定要读取的File对象。
 * FileReader(String fileName) ： 创建一个新的 FileReader ，给定要读取的文件的名称。
 * 当你创建一个流对象时，必须传入一个文件路径。类似于FileInputStream 。
 *
 * 1.读取字符：
 *          read 方法，每次可以读取一个字符的数据，提升为int类型，读取到文件末尾，返回 -1
 * 2.使用字符数组读取：
 *          read(char[] cbuf) ，每次读取b的长度个字符到数组中，返回读取到的有效字符个数，读取到末尾时，返回 -1
 *
 *
 * 【字符输入流使用步骤】
 *          1.创建FileReader对象，构造方法中绑定要读取的数据源
 *          2.使用FileReader对象中的reader方法读取文件
 *          3.释放资源
 */
public class FileReaderTest {

    public static void main(String[] args) throws IOException {
        //1.创建FileReader对象，构造方法中绑定要读取的数据源
        FileReader fr = new FileReader("fos2.txt");

        //2.使用FileReader对象中的reader方法读取文件
        /*
        //获取到单个字符，并返回
        int len = 0;
        while ((len = fr.read()) != -1) {
            System.out.print((char)len);
        }
        */
        //一次读取多个字符，将多个字符读入数组
        int len = 0;//可获取的有效字符个数
        char[] ch = new char[1024];//存储读取到的多个字符
        while ((len = fr.read(ch)) != -1) {
            System.out.println(new String( ch, 0, len));
        }
        //3.释放资源
        fr.close();
    }
}
