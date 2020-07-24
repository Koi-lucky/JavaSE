package extendstest;
//导包
import java.util.Random;
import java.util.Scanner;

public class Random_Demo01 {
    public static void main(String[] args) {
        //Random类作用是产生一个随机数，Random使用时要导包
        //随机数的范围是左闭右开
        //1~100的随机数应写为：r.nextInt(100)+1
        Random r = new Random();
        int num = r.nextInt(100)+1;
        //一个死循环：while(true)
        //不断输入一个数，直到输入的数和产生的随机数相等为止
        while(true) {
            //定义一个Scanner类用于输入一个你所猜的数
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要猜的数字(1‐100)：");
            int guessNum = sc.nextInt();//guessNum为你所猜的数
            //用if条件语句判断是否你输入的数和产生的随机数相等
            if(guessNum < num) {
                System.out.println("您猜的数小了！");
            } else if(guessNum > num) {
                System.out.println("您猜的数大了！");
            } else {
                System.out.println("恭喜您猜对了！");
                break;
            }
        }
    }
}


class Random_Demo02 {
    public static void main(String[] args) {
        //产生一个1~100的随机数
        Random r = new Random();
        int num = r.nextInt(100)+1;
        System.out.println("产生的随机数为："+num);
    }
}