package iotest.IO_Foundation;

import java.io.FileWriter;
import java.io.IOException;

/**
 * IO流过程中的异常处理格式：
 *      （把变量拿出来定义，并赋初值）
 *      try {
 *          //可能会出现异常的代码
 *      } catch(异常类变量 变量名) {
 *          //异常处理逻辑
 *      } finally {
 *          //一定会执行的代码
 *          //资源的释放（还要处理其产生的异常）
 *      }
 */
public class TryCatch {

    public static void main(String[] args) {
        //扩大变量fw3的作用域，让finally也可以使用fw3
        //变量在定义的时候，可以没有值，但是在使用的时候，必须要有值
        FileWriter fw3 = null;
        try {//可能会出现异常的代码
            fw3 = new FileWriter("fw3.txt");
            for (int i = 0; i < 10; i++) {
                fw3.write("HelloWorld" + i + "\r\n");//换行
            }
            fw3.close();
        } catch (IOException e) {//异常处理的逻辑
            System.out.println(e);
        } finally {//一定会执行的代码，释放资源的方法
            //如果创建对象失败了，fw3的默认值就是null，null不能调用方法，会抛出空指针异常，
            //所以需要加一个判断，判断他不为null
            if(fw3 != null) {
                try {
                    //fw3.close()方法的声明会抛出异常，所以我们要进行try catch处理
                    fw3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
