package tenalgorithms;

public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = { 5, 18, 10, 6, 1, 15, 7, 33};
        int value = 10;
        System.out.println(seqSearch(arr, value));
    }


    public static int seqSearch(int[] arr, int value) {
        //直接遍历整个数组，找到相应的值，返回该数的下标即可
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return -1;//找不到就返回-1
    }

}
