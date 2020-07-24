package tenalgorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        //给定一个乱序的数组，将其用归并排序法进行排序
        int[] arr = { 8, 2, 5, 3, 1, 4, 7, 6};
        //归并排序需要一个额外的数组空间
        int[] temp = new int[arr.length];
        mergeSort( arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }


    //分 + 合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            //中间的一个索引
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort( arr, left, mid, temp);
            //向右递归进行分解
            mergeSort( arr,mid + 1, right, temp);
            //将所有的解进行合并
            merge( arr, left, mid, right, temp);
        }
    }


    //合并的方法

    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转操作的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引

        //1.先把左右两边的有序的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完为止
        while(i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到temp数组
            //t 和 i都向后移一位
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t ++;
                i ++;
            } else {
                //反之则将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t ++;
                j ++;
            }
        }

        //2.把有剩余数据的一边剩下的数，挨个依次填充到temp
        while(i <= mid) {
            //若左边有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t ++;
            i ++;
        }

        while(j <= right) {
            //若右边有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t ++;
            j ++;
        }

        //3.将temp数组的元素拷贝到arr数组中
        //【注意】并不是每次都拷贝所有的数
        t = 0;
        int tempLeft = left;//定义一个临时变量，用于储存左边索引的下标
        //第一次合并tempLeft = 0，right = 1;第二次tempLeft = 2 ,right = 3 ;第三次tempLeft = 0, right = 3;
        //合并完左边的数组后，合并右边的数组
        //最后一次tempLeft = 0 ， right= 7
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t ++;
            tempLeft ++;
        }
    }
}
