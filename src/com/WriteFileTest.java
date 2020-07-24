package com;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class WriteFileTest {

    public static void main(String[] args) throws Exception {
        //如果文件不存在就创建文件
        File file = new File("Exercise12_15.txt");
        if(!file.exists()) {
            //文件不存在
            //写数据操作
            PrintWriter output = new PrintWriter(file);
            for(int i = 1; i <= 100; i ++) {
                output.print((int)(Math.random() * 1000) + " ");//随机生成100个数，并加入到文件中
            }
            output.close();//关闭文件
        }
        //读数据操作
        Scanner sc = new Scanner(file);
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);//对其进行排序
        int count = 0;
        for (int i = 0; i < 100; i++) {
            count++;
            System.out.print(arr[i] + " ");
            if(count % 10 == 0) {
                System.out.println();
            }
        }
    }
}
