package iotest.IO_Foundation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * OutputStream 有很多子类，我们从最简单的一个子类开始。
 * java.io.FileOutputStream 类是文件输出流，用于将数据写出到文件。
 *
 * 构造方法
 * public FileOutputStream(File file) ：创建文件输出流以写入由指定的 File对象表示的文件。
 * public FileOutputStream(String name) ： 创建文件输出流以指定的名称写入文件。
 * 当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有这个文件，会创建该文件。如果有这个文
 * 件，会清空这个文件的数据
 */
public class FileOutputStreamTest_Constructor {

    public static void main(String[] args) throws FileNotFoundException {
        //使用File对象创建流对象
        File file = new File("a.txt");
        FileOutputStream fos1 = new FileOutputStream(file);

        //使用文件名创建流对象
        FileOutputStream fos2 = new FileOutputStream("b.txt");

    }
}
