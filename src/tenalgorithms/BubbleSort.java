package tenalgorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        //给定一个数组，将其从小到大进行排序
        int[] arr = {12, 23, 5, 11, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;//定义一个临时变量，用于进行两数的交换操作
        int flag = -1;//设置一个标志量，用于检测是否进行了一轮排序
        for (int i = 0; i < arr.length - 1; i++) {
            //外层循环表示所要进行的趟数，有n个数的话，要进行n-1趟排序
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //内存循环则进行的是排序过程，每进行一趟排序，他的下一趟排序的次数都会少一次
                //若是逆序，就进行两数的交换
                if(arr[j] > arr[j + 1]) {
                    flag = 1;//若进行交换，就给标志量置1
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //一趟排序进行完后，标志量的值如果为1，表示实际上是进行了一趟排序
            //如果不为1，表示没进行排序
            //这样的话就不用进行后面的排序了，数组已经是有序数组
            if(flag != 1) {
                return;
            } else {
                flag = -1;//每进行一趟排序之后，将标志量重置
            }
        }
    }
}
