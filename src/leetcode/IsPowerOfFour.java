package leetcode;

public class IsPowerOfFour {

    public static void main(String[] args) {
        //测试4的幂
        System.out.println(isPowerOfFour(156));
    }

    public static boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("^10*$");
    }
}
