package leetcode;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class ArithmeticExpression {

    public static void main(String[] args) throws Exception{
        File file = new File("out.txt");
        //如果文件存在，读取文件中的表达式
        if(file.exists()) {
            Scanner input = new Scanner(file);
            //读文件中的数据
            while (input.hasNext()) {
                System.out.println( input.nextLine() );
            }
            input.close();//关闭文件
        }
        //如果文件不存在，创建文件。并写入数据
        PrintWriter pw = new PrintWriter(file);//创建文件
        //往文件里写数据
        int n = 0;
        while (n < 100) {
            int num1 = new Random().nextInt(200) ;
            int num2 = new Random().nextInt(200) ;
            int exp = new Random().nextInt(4) + 1;//在四个运算符中随机选取一个
            BinaryArithmeticExpression bae = new BinaryArithmeticExpression( num1, num2, exp);//创建二元算术表达式对象
            pw.println( num1 + " " +  (char)bae.getOperator() + " " + num2 + " = " + bae.getResult());//将表达式和运算结果写入该文件
            n ++;
        }
        pw.close();//关闭文件
    }
}

class BinaryArithmeticExpression {
    //定义私有数据成员
    private double x;//左操作数
    private double y;//右操作数
    private double operator;//运算符

    //无参构造
    public BinaryArithmeticExpression() {
    }

    //带参构造
    public BinaryArithmeticExpression(double x, double y, double operator) throws Exception {
        this.x = x;
        this.y = y;
        if(operator == 1 || operator == 2 ||operator == 3 ||operator == 4) {
            this.operator = operator;
        } else {//运算符不合格的话，直接抛出异常
            throw new Exception("输入异常！");
        }
    }

    //三个成员的访问器方法
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getOperator() {
        if(this.operator == 1) {
            return '+';
        } else if(this.operator == 2) {
            return '-';
        } else if(this.operator == 3) {
            return '*';
        }
        return '/';
    }

    //计算表达式的值
    public double getResult() throws Exception {
        double s = this.operator;
        double num1 = this.x;
        double num2 = this.y;
        switch ((int)s) {//根据不同的运算符，进行不同的操作
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                //除法运算时，除数不能为0，否则会抛出异常
                if(num2 == 0) {
                    throw new Exception("输入异常，除数不能为0！！");
                } else {
                    return num1 / num2;
                }
        }
        return -1;
    }
}