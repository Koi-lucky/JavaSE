package leetcode;

public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1 , 4, 7, 11, 15},
                {2 , 5, 8, 12, 19},
                {3 , 6, 9, 16, 22},
                {10 , 13, 14, 17, 24},
                {18 , 21, 23, 26, 30},
        };
        int taret = 5;
        System.out.println(findNumberIn2DArray(matrix, taret));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[i].length;j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
