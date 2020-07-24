package iotest.IO_Foundation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * FileInputStream(File file) ： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。
 * FileInputStream(String name) ： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。
 * 当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出 FileNotFoundException
 */
public class FileInputStream_Constructor {

    public static void main(String[] args) throws FileNotFoundException {
        //使用File对象创建流对象
        File file = new File("a.txt");
        FileInputStream fis1 = new FileInputStream(file);

        //使用文件名称创建流对象
        FileInputStream fis2 = new FileInputStream("b.txt");
    }
}
