package leetcode;

public class SubarraysDivByK {

    public static void main(String[] args) {
        //测试
        int[] a = { 4, 5, 0, -2, -3, 1};
        System.out.println(subarraysDivByK( a, 5));
    }

    public static int subarraysDivByK(int[] A, int K) {
        if(A.length == 1) {
            if(A[0] % K == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int sum = 0;//用于求子数组的和
        int count = 0;//计数器
        for (int i = 0; i < A.length; i++) {
            sum = A[i];
            if(sum % K == 0) {
                count++;
            }
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                if(sum % K == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
