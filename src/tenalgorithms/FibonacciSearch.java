package tenalgorithms;

import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = { 9, 25, 34, 89, 1000, 1645};
        int key = 34;
        System.out.println(fibSearch(arr, key));
    }

    //用非递归的方法获取一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] +f[i - 2];
        }
        return f;
    }

    //编写斐波纳挈查找法

    /**
     *
     * @param a 数组
     * @param key 待查找的关键值
     * @return 若找到则返回对应下标，没找到，则返回-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波纳挈分割数值的下标
        int mid = 0;//存放mid的值
        int[] f = fib();//获取斐波那契数列
        //获取到斐波那契而数列的下标
        while(high > f[k] - 1) {
            k ++;
        }
        //f[k]的值可能会大于数组a的长度，所以需要新定义一个数组，指向temp
        //不足的部分系统自动用0填充
        //temp={ 9, 25, 34, 89, 1000, 1645, 0, 0}
        //实际上我们需要用原数组的最后一个数填充0的地方
        //temp={ 9, 25, 34, 89, 1000, 1645, 0, 0}  ==> temp={ 9, 25, 34, 89, 1000, 1645, 1645, 1645}
        int[] temp = Arrays.copyOf(a,f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        //找我们的关键数
        while(low <= high) {
            mid = low + f[k - 1] - 1;
            //全部的元素=前面的元素+后面的元素
            //f[k]=f[k-1]+f[k-2]
            //前面有f[k-1]个元素，继续拆分为f[k-1]=f[k-2]+f[k-3],即在f[k-1]的前面继续查找，k--
            //后面有f[k-2]个元素，继续拆分为f[k-1]=f[k-3]+f[k-4],即在f[k-2]的前面继续查找，k=k-2
            if(key < temp[mid]) {
                high = mid - 1;
                k--;
                //即下次循环时mid=f[k-1-1]-1
            } else if(key > temp[mid]) {
                low = mid + 1;
                k -= 2;
                //即下次循环时mid=f[k-1-2]-1
            } else {
                //找到了，但是要确定是哪个下标
                if(mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
