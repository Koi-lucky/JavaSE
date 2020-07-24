package text;

import java.util.Scanner;

public class ZuoYe001 {
    public static void main(String[] args) {
        //第一年的人数就是在当前人口数的基础上+新增人口数
        //第二年的人口数则是在第一年的基础上+新增人口数
        //第三年、第四年、第五年以此类推
        double sum01 = getSum()+321032486;
        double sum02 = getSum()+sum01;
        double sum03 = getSum()+sum02;
        double sum04 = getSum()+sum03;
        double sum05 = getSum()+sum04;
        System.out.println(sum01);//第一年的人数
        System.out.println(sum02);//第二年的人数
        System.out.println(sum03);//第三年的人数
        System.out.println(sum04);//第四年的人数
        System.out.println(sum05);//第五年的人数
    }
    public static double getSum() {
        //getSum()里面为每年的新增人口数
        //每年新增人数=365*（每天的出生人数-每天的死亡人数+每天的移民数）
        double sum = 0.0;
        sum = 365*(86400/7.0-86400/13.0+86400/45.0);
        return sum;
    }
}



class ZuoYe002 {
    public static void main(String[] args) {
        char C = 'A';
        int i = (int) C;
        System.out.println(i);
        System.out.println("================");

        float f = 1000.34f;
        int n = (int) f;
        System.out.println(n);
        System.out.println("================");

        double d = 1000.34;
        int m = (int) d;
        System.out.println(m);
        System.out.println("================");

        int k = 97;
        char P = (char) k;
        System.out.println(P);
        System.out.println("================");

    }
}



class Test {
    public static void main(String[] args) {
        char x = 'a';
        char y=  'c';
        System.out.println(++x);
        System.out.println(y++);
        System.out.println(x-y);
    }
}



class PrintLowerCaseRandom {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            int c='a'+(int)(Math.random()*26);   //'a'会自动转换为int以执行加法
            System.out.print((char)c);//为了打印字符，必须将c强制转为char
            break;//随即输出一个小写字母后跳出循环
        }
    }
}




class ZuoYe03 {
    public static void main(String[] args) {
       System.out.printf("amount is %f %e\n",32.32,32.32);
        System.out.println("=======================");
        System.out.printf("amount is %5.2f%% %5.4e\n",32.327,32.32);
        System.out.println("=======================");
       System.out.printf("%6b\n",(1 > 2));
       System.out.println("=======================");
       System.out.printf("%6s\n","Java");
       System.out.println("=======================");
        System.out.printf("%-6b%s\n",(1 > 2), "Java");
        System.out.println("=======================");
        System.out.printf("%6b%-8s\n", (1 > 2), "Java");
        System.out.println("=======================");

    }
}



class ZuoYe04 {

    public static void main(String[] args) {
        //使用Scanner类来从键盘输入一个整数
        Scanner input = new Scanner(System.in );
        System.out.println("输入一个整数n：");
        int n = input.nextInt();

        //调用sumDigits方法,计算整数的返回值
        System.out.println("该整数n的各位数字之和为:" + sumDigits(n));
    }

    public static int sumDigits(long n) {

        int sum=0;
        while(n > 0) {
            sum += n%10;//用n % 10分离出他的最低位，并进行加和运算
            n /= 10;//每次求完和之后，更新n的值
            if(n == 0) {
                //如果n为0的话，跳出while循环
                break;
            }
        }
        return sum;
    }
}




class ZuoYe05 {

    public static void main(String[] args) {
        //输出两个表的表头
        System.out.println("Kilograms" + "  Pounds" + " |  " + "Pounds" + "  Kilograms");
        //打印表内的数据，调用PrintArray()函数
        PrintArray();
    }


    public static void PrintArray() {
        //定义两个二维数组（一个int,一个double），逐列打印两个表，一共四列
        int[][] array01 = new int[100][2];
        double[][] array02 = new double[100][2];

        //定义两个局部变量i,k
        int i = 0;
        int k = 0;
        //打印出整个表
        while(true) {

            array01[i][0] = 2 * i + 1;//第一列int型的array01[i][0]
            array01[i][1] = 20 + i * 5; //第三列int型array01[i][1]
            array02[k][0] = 2.2 +  4.4 * k ;//第二列double型的array02[k][0]，第二列的每个数后面需要加分隔符
            array02[k][1] = 9.09 + 2.27 * k ;//第四列double型array02[k][1]

            //格式化输出四个数，
            //第一、三列左对齐，第二、四列右对齐
            //第一、三列十进制类型输出，第二、四列以浮点数类型输出
            //中间的分隔符单独打印出来
            System.out.printf("%-3d        %5.1f" ,array01[i][0] ,array02[k][0] );
            System.out.print("  |  ");
            System.out.printf("%-3d        %5.2f\n" ,array01[i][1] , array02[k][1]);
            i ++;
            k ++;
            if(i == 100 && k == 100) {
                //判断局部变量i,k是否等于100，等于100的话，跳出while循环，打印结束
                break;
            }
        }
    }
}



class ZuoYe06 {

    public static void main(String[] args) {

        //给方法传值，打印100~200以内满足要求的数
        PrintNumber(100,200);
    }

    public static void PrintNumber(int m,int n) {
        //定义一个局部变量count做计数器
        int count = 0;
        //按要求打印100~200以内的数
        for (int i = m; i <= n; i++) {
            //能被5整除
            if(i % 5 == 0) {
                System.out.print(i + " ");
                count ++;
                if(count % 10 == 0) {
                    System.out.printf("\n"); //每打印10个数之后，换行一次
                }
            } else if(i % 6 == 0) { //能被6整除
                System.out.print(i + " ");
                count ++;
                if(count % 10 == 0) {
                    System.out.printf("\n"); //每打印10个数之后，换行一次
                }
            }
        }
    }
}