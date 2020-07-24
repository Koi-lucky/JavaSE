package leetcode;

import java.util.Arrays;

public class ArraysSort {

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(arr)));
    }

    public static int[] sortArrayByParityII(int[] A) {
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        int m = 0;
        int n = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                B[m] = A[i];
                m++;
            } else {
                C[n] = A[i];
                n++;
            }
        }
        for (int k = 0, j = 0; k < A.length && j < A.length; k += 2 , j++) {
            A[k] = B[j];
        }
        for (int k = 1, j = 0; k < A.length && j < A.length; k += 2 , j++) {
            A[k] = C[j];
        }
        return A;
    }
}
