package leetcode;

import java.util.Arrays;

public class TriangleCircumference {

    public static void main(String[] args) {

        int[] arr = { 3, 6, 2, 3};
        System.out.println(largestPerimeter2(arr));
    }


    public static int largestPerimeter1(int[] A) {

        int perimeter = 0;
        int maxPerimeter = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if(i != j) {
                    for (int k = 0; k < A.length; k++) {
                        if(k != i && k != j) {
                            if(A[i] < A[j] + A[k] && A[j] < A[i] + A[k] && A[k] < A[j] + A[i] && A[i] > Math.abs(A[j] - A[k]) && A[j] > Math.abs(A[i] - A[k]) && A[k] > Math.abs(A[j] - A[i])) {
                                perimeter = A[i] + A[j] + A[k];
                                if(perimeter > maxPerimeter) {
                                    maxPerimeter = perimeter;
                                }
                            }
                        }
                    }
                }
            }
        }
        return maxPerimeter;
    }


    public static int largestPerimeter2(int[] A) {
        Arrays.sort(A);
        if (A == null || A.length < 3) {
            return 0;
        }
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
