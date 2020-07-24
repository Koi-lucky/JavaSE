package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Calculation {

    public static void main(String[] args) {
        // 提醒用户输入一个字符串（一串以逗号分隔的数字）
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一串以逗号分隔的数字：");
        String s = input.next();
        OperateNumbers on = new OperateNumbers(s);
        // 1.读取这串数字
        int[] arr = on.readNum(s);//操作数组
        int[] array = arr.clone();//原数组
        System.out.println("读取这组数：");
        System.out.println(Arrays.toString(arr));
        // 2.将这组数逆序输出
        System.out.println("逆序输出这组数为：");
        on.reverseNum(arr);
        // 3.给这组数进行排序,再输出
        System.out.println("升序排列为：");
        System.out.println(Arrays.toString(on.sortNum1(arr)));
        System.out.println("降序排列为：");
        System.out.println(Arrays.toString(on.sortNum2(arr)));
        // 4.计算这组数的平均数
        System.out.println("这组数的平均数为：" + on.avgNum(array));
        // 5.寻找最接近平均值的数，并显示他的位置
        on.diaplayPos( array, on.avgNum(array));
    }
}


class OperateNumbers {
    String s;

    // 无参构造
    public OperateNumbers() {
    }

    // 带参构造
    public OperateNumbers(String s) {
        this.s = s;
    }

    // 读取一组数的方法
    public int[] readNum(String s) {
        //将字符串按逗号进行分割,保存在数组中
        String[]  ss = s.split(",");
        //定义一个int数组，用于保存转换过来的数字
        int[] arr = new int[ss.length];
        //遍历字符串，进行转换
        for (int i = 0; i < ss.length; i++) {
            //调用Integer包装类中的parseInt方法进行转换
            arr[i] = Integer.parseInt(ss[i]);
        }
        return arr;
    }

    // 逆序输出的方法
    public void reverseNum(int[] A) {
        //将数组倒序输出
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == 0) {//如果是最后一个数，直接输出（输出后再换行）
                System.out.println(A[i]);
            } else {//其余的数输出数字和逗号分隔符
                System.out.print(A[i] + ",");
            }
        }
    }

    // 升序排序
    public int[] sortNum1(int[] A) {
        // 用冒泡排序法进行排序
        int temp = 0;//定义一个临时变量，用于进行两数的交换操作
        int flag = -1;//设置一个标志量，用于检测是否进行了排序操作
        for (int i = 0; i < A.length - 1; i++) {//外层循环表示所要进行的趟数，有n个数的话，要进行n-1趟排序
            for (int j = 0; j < A.length - 1 - i; j++) {//内存循环则进行的是排序过程，每进行一趟排序，她的下一趟排序的次数都会减少一次
                if(A[j] > A[j + 1]) {//若两数逆序，则进行交换操作
                    flag = 1;//若进行交换，就将标志量置1
                    temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
            //一趟排序之后，如果flag为1，则进行了排序操作，否则，表示没有排序
            //若没有排序的话，代表数组已经是有序数组，不需要进行后续的排序了
            if(flag != 1) {
                break;
            } else {
                flag = -1;//每进行一趟排序后，都将标志量置-1
            }
        }
        return A;
    }

    // 降序排序
    public int[] sortNum2(int[] A) {
        // 用冒泡排序法进行排序
        int temp = 0;//定义一个临时变量，用于进行两数的交换操作
        int flag = -1;//设置一个标志量，用于检测是否进行了排序操作
        for (int i = 0; i < A.length - 1; i++) {//外层循环表示所要进行的趟数，有n个数的话，要进行n-1趟排序
            for (int j = 0; j < A.length - 1 - i; j++) {//内存循环则进行的是排序过程，每进行一趟排序，她的下一趟排序的次数都会减少一次
                if(A[j] < A[j + 1]) {//若两数逆序，则进行交换操作
                    flag = 1;//若进行交换，就将标志量置1
                    temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
            //一趟排序之后，如果flag为1，则进行了排序操作，否则，表示没有排序
            //若没有排序的话，代表数组已经是有序数组，不需要进行后续的排序了
            if(flag != 1) {
                break;
            } else {
                flag = -1;//每进行一趟排序后，都将标志量置-1
            }
        }
        return A;
    }

    // 计算平均值的方法
    public double avgNum(int[] A) {
        int sum = 0;//定义一个存储和的辅助变量
        for (int i = 0; i < A.length; i++) {
            sum += A[i];//求该组数的和
        }
        //返回平均值
        return (double) sum / A.length;
    }

    // 寻找最近接平均值的数，并显示其位置的方法
    public void diaplayPos(int[] A, double avg) {
        double num = Math.abs(A[0] - Math.round(avg));//定义一个变量，存储每个数与平均值的差值，初始化为第一个数与平均值的差值
        int value = 0;//定义一个变量，用于存储最接近平均值的数
        int index = 0;//用于存储value的下标
        //遍历数组，计算每个数与平均值的差值并比较
        for (int i = 0; i < A.length; i++) {
            if(Math.abs(A[i] - Math.round(avg)) < num) {
                //如果有更小的差值，更新对应的数值、下标及num值
                value = A[i];
                index = i;
                num = Math.abs(A[i] - Math.round(avg));
            }
        }
        System.out.println("最接近平均值的数为：" + value + " , 它在原数组中的下标位置为：" + index);
    }
}