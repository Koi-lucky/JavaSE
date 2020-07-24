package leetcode;

import java.util.HashSet;

public class UniqueOccurrences {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 1, 1, 3};
        //int[] arr = { 1, 2};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        int[] a = new int[2000];
        for(int i = 0;i < arr.length;i++ ) {
            a[arr[i] + 1000]++;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < a.length;i++ ) {
            if(a[i] != 0) {
                if (!set.add(a[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
