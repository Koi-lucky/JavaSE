package tenalgorithms;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = { 4, 6, 8, 5, 9};
        heapSort(arr);
    }

    //写一个堆排序的方法
    public static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("进行堆排序！！！");

        //将无序序列构建成一个堆，根据升序降序需求来选择大顶堆还是小顶堆
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            adjustHeap( arr, i, arr.length);
        }

        //将堆顶元素与末尾元素交换，将最大元素“沉”到数组的最末端
        //重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for (int j = arr.length - 1; j > 0 ; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap( arr, 0, j);//每次需要调整的数组的大小在减小
        }
        System.out.println("排序后的数组为：" + Arrays.toString(arr));
    }


    //将一个数组（二叉树），调整成一个大顶堆（局部的调整）===> 以结点i为根的子树的调整

    /**
     * 功能：完成将以i对应的非叶子节点的树调整成大顶堆
     * 举例：int[] arr = { 4, 6, 8, 5, 9}===> i=1 ===> adjustHeap ===> 得到{ 4, 9, 8, 5, 6}
     *         如果再次调用adjustHeap，adjustHeap传入的是 i=0 ===> 原来的{ 4, 9, 8, 5, 6}会变为{ 9, 9, 8, 5, 4}
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length是在逐渐的减少
     */
    public static void adjustHeap( int[] arr, int i, int length) {

        int temp = arr[i];//先取出当前元素的值，保存在临时变量里
        //k=2*i+1是i节点的左子结点
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if(j + 1 < length && arr[j] < arr[j + 1]) {
                //说明左子结点的值小于右子节点的值
                j ++;//j指向右子节点
            }
            if(arr[j] > temp) {
                //如果子节点大于父节点
                arr[i] = arr[j];//把较大的值赋给当前结点
                i = j;//！！！i指向k，继续循环比较
            } else {
                break;
            }
        }
        //当循环结束后，我们已经将以i为父节点的树的最大值，放在了该子树的最顶端（局部的调整）
        arr[i] = temp;//将temp值放到调整后的位置
    }

}
