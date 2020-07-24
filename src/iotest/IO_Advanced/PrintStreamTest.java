package iotest.IO_Advanced;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 【打印流的练习】—— 改变打印流向 —— 不产生IO异常，产生的是文件找不到异常
 *
 * 【注意事项】
 *      1.如果使用继承自父类的write方法写数据，那么查看数据的时候会查询编码表（97-> a）
 *      2.如果是用自己的特有方法print/println/printf写数据，写的数据原样输出（97->97）
 */
public class PrintStreamTest {

    public static void main(String[] args) throws FileNotFoundException {
        //创建打印流对象
        PrintStream ps = new PrintStream("print.txt");
        //使用继承自父类的write方法写数据，那么查看数据的时候会查询编码表（97-> a）
        ps.write(97);
        //用自己的特有方法print/println/printf写数据，写的数据原样输出（97->97）
        ps.println(97);
        //释放资源
        ps.close();
    }
}
