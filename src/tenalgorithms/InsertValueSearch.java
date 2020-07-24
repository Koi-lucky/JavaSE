package tenalgorithms;

public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr1 = { 1, 12, 23, 26, 40, 78, 91, 102, 219, 374};
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(insertValueSearch( arr1, 0, arr1.length - 1, 102));
        System.out.println(insertValueSearch( arr2, 0, arr2.length - 1, 8));
    }

    /**
     *
     * @param arr 待查找的数组
     * @param left 左边的索引值
     * @param right 右边的索引值
     * @param value 要查找的数
     * @return 如果找到，就返回该数的下标值；如果没找到，就返回-1
     */
    public static int insertValueSearch( int[] arr, int left, int right, int value) {

        //如果要查找的数>数组最大值，或者<小于数组的最小值，则是为找不到
        if(left > right || value > arr[arr.length - 1] || value < arr[0]) {
            return -1;
        }

        //定义mid的值，自适应
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if(value > arr[mid]) {
            //向mid右边递归
            return insertValueSearch( arr, mid + 1, right, value);
        } else if(value < arr[mid]) {
            //向mid左边递归
            return insertValueSearch( arr, left, mid, value);
        } else {
            return mid;
        }
    }
}
