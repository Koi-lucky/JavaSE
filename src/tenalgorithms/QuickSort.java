package tenalgorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { -9, 78, 0, 23, -567, 70};
        quickSort( arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        int mid = arr[(left + right) / 2];
        int temp = 0;

        //当遇到比mid小的值的话，放在mid左边；当遇到比mid大的值得话，放在mid右边
        while(l < r) {
            //如果在mid的左边找到>=mid的数，就会退出循环
            while(arr[l] < mid) {
                l ++;
            }
            //如果在mid的右边找到<=mid的数，就会退出循环
            while(arr[r] > mid) {
                r --;
            }
            //如果left>=right则说明mid左右两边的值，已经排好了（即mid左边的数都小于mid，mid右边的数都大于mid）
            if(l >= r) {
                break;
            }
            //交换两个数的操作
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现arr[left]==mid,这时候要将right前移
            if(arr[l] == mid) {
                r --;
            }
            //如果交换完后，发现arr[right]==mid,这时候要将left后移
            if(arr[r] == mid) {
                l ++;
            }
        }
        //如果left==right，必须left++，right--，否则的话会出现栈的溢出
        if(l == r) {
            l ++;
            r --;
        }
        //往左边递归
        if(left < r) {
            quickSort(arr ,left ,r);
        }
        //往右边递归
        if(right > l) {
            quickSort(arr ,l ,right);
        }
    }
}
