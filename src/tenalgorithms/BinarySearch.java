package tenalgorithms;

/*
二分查找的非递归解法
 */
public class BinarySearch {

    public static void main(String[] args) {
        //给定一个数组和要查找的数

    }

    /**
     *
     * @param list 待查int[] list = {2,12,15,45,53,86,98,156,450};
     *         int key = 45;
     *         int index = binarySearch(list, key);
     *         System.out.println("该数的在数组中的位置为：" + index);找的数组
     * @param key 将要查找的数
     * @return 若找着了，则对应的下标；没找着，则返回-1
     */
    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;

        while(high >= low) {//说明要在该数组范围内查找数
            int mid = (high + low) / 2;
            if(key < list[mid]) {//往mid的左边查找
                high = mid - 1;
            } else if(key == list[mid]) {
                return mid;
            } else {//往mid的右边查找
                low = mid + 1;
            }
        }
        return -1;
    }
}


/*
二分查找的递归解法
 */
class BinarySearch2 {

    public static void main(String[] args) {

        int[] list = {2,12,15,45,53,86,98,156,450};
        int key = 45;
        int index = binarySearch(list, 0, list.length - 1, key);
        System.out.println("该数的在数组中的位置为：" + index);
    }


    /**
     *
     * @param list 待查找的数组
     * @param low 左边的索引值
     * @param high 右边的索引值
     * @param key 要查找的值
     * @return 若找着了，则对应的下标；没找着，则返回-1
     */
    public static int binarySearch(int[] list, int low, int high, int key) {

        if(high < low) {
            //在high < low的时候，说明递归了整个数组，但是没找着
            return -1;
        }
        int mid = (high + low) / 2;

        if(key < list[mid]) {//往mid的左边递归
            return binarySearch(list, low, mid - 1, key);
        } else if(key > list[mid]) {//往mid的右边递归
            return binarySearch(list, mid + 1, high, key);
        } else {
            return mid;
        }
    }
}