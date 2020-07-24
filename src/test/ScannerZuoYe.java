package text;

import java.util.Scanner;

public class ScannerZuoYe {
    public static void main(String[] args) {
        System.out.println("hi 大家好，我是计科1801班的李新凯");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(Math.pow(a,2));
    }
}


class Nabala {
    //倒三角的输出
    //利用Scanner类输入一个数表示行数
    //同一个包下不需要导包
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n; i > 0; i--) {
            for (int j = n-i; j > 0 ; j--) {
                System.out.print(" ");
                //输出空格，但不换行
            }
            for (int k = 2*i-1; k > 0 ; k--) {
                //每行的#的数量为2*i-1
                System.out.print("#");
                //输出#，但不换行
            }
            System.out.println();
            //每输出一行再进行一次换行
            //Syetem.out.print("\n");也可用此表示换行
        }
    }
}


class ComputeArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入一个圆的半径：");
        final double PI = 3.1415;
        //final为声明常量的关键字
        //大写常量中的所有字母，两个单词间用下划线连接，例如，常量PI和常量 MAX_VALUE 0
        double radius = input.nextDouble();
        double area = radius * radius * PI;
        System.out.println("圆的面积为："+ area );
    }
}



class ComputeAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入三个数：");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();
        double sum = (num1 + num2 + num3) / 3;

        System.out.println("这三个数的平均值为;" + sum);

    }
}



class DisplayTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入总共的秒数：");
        int time = input.nextInt();
        int minute = time / 60;
        int second = time % 60;
        System.out.println("转为"+ minute +"分"+ second +"秒");

        System.out.println("==================");

        System.out.print("输入总共的毫秒数：");
        //键盘输入毫秒数
        Long Milliseconds = input.nextLong();
        //总的秒数=毫秒数/1000
        Long totalSeconds = Milliseconds / 1000;
        //正确的秒数=总共的秒数 mod 60
        Long currentSeconds = totalSeconds % 60;
        //总共的分钟数=总共的秒数/60
        Long totalMinutes = totalSeconds / 60;
        //正确的分钟数= 总共的分钟数 mod 6045692
        Long currentMinutes = totalMinutes % 60;
        //总共的小时数= 总共的分钟数/60
        Long totalHours = totalMinutes / 60;
        //正确的小时数= 总共的小时数 mod 24
        Long currentHours = totalHours % 24;

        System.out.println("总共的时间为：" + currentHours+ ":" + currentMinutes+  ":"+currentSeconds);

    }
}


class SumMethod {
    public static void main(String[] args) {
        double a = 6.5;
        a += a + 1;
        System.out.println(a);

        a = 6;
        a /= 2;
        System.out.println(a);

        double x = 1.0;
        double y = 5.0;
        double z = x -- + (++ y);
        System.out.println(x +","+ y +","+ z);
    }
}





