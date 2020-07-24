package tenalgorithms;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr ={ 8, 5, 12, 9, 1, 7, 3};
        shellSort1(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("==========================");
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


    //第一种排序方法：交换排序
    public static void shellSort1(int[] arr) {
        int temp = 0;//定义一个临时变量，用于两数交换的操作
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            //第一层循环用于控制步长
            for (int i = gap; i < arr.length; i++) {
                //第二层循环用于遍历各组中所有的元素（共有gap组，每组两个元素）
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //第二种排序方法：移位法（类似于插入排序的思想，先一个一个找位置，将大于它的数往后移）
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            //定义一个增量gap表示步长，并逐步的缩小范围
            for (int i = gap; i < arr.length; i++) {
                //从第gap个元素开始，逐个对其所在的组进行直接插入排序
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]) {
                    while(j - gap >=0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while循环后，就表示已经给temp找到了合适的位置
                    arr[j] = temp;
                }
            }
        }
    }
}
