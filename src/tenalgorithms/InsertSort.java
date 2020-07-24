package tenalgorithms;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        //给定一个数组，将其进行选择排序，默认升序
        int[] arr = {15, 25, 3, 10, 9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {

        int insertVal = 0;//定义一个临时变量用于存放带插入的数
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            //定义带插入的数
            insertVal = arr[i];
            insertIndex = i - 1;//即arr[i]前面那个数的下标

            //现在要给insertVal找插入的位置
            //insertIndex >= 0是保证在插入过程中，数组的下标不会越界
            //insertVal < arr[insertIndex]则表示待插入的数，还没找到插入位置
            //找到插入位置后，要先将arr[insertIndex]后移，空出位置，才能进行下一步的插入
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }

            //退出while循环表示已经找到了要插入的位置：insertIndex + 1
            //判断是否可以进行插入赋值
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }

    }
}
