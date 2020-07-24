package tenalgorithms;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
    //给定一个数组
        int[] list = {2, 56, 12, 23, 5};
        seclectSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void seclectSort(int[] list) {
        //从小到大排列
        for (int i = 0; i < list.length - 1; i++) {
            //假设每次循环时，第一个数是最小值
            int minIndex = i;
            int min = list[i];
            //从下标为i + 1往后开始遍历，找最小值
            for (int j = i + 1; j < list.length; j++) {
                //用假定的最小值依次和后面的值进行比较
                //比它还小则交换，记录下该值及该值的下标
                if(min > list[j]) {
                    min = list[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                //将最小值放在前面，也就是进行交换
                list[minIndex] = list[i];
                list[i] = min;
            }
        }
    }
}
