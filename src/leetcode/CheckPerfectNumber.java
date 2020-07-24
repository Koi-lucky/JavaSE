package leetcode;

public class CheckPerfectNumber {

    public static void main(String[] args) {

        int num = 28;
        System.out.println(checkPerfectNumber(num));
    }

    public static boolean checkPerfectNumber(int num) {
        if(num == 0 || num == 1) {
            return false;
        }
        int sum = 1;
        for(int i = 2; i <= Math.sqrt(num) ; i++) {
            if(num % i == 0) {
                sum = sum + i + num / i;
            }
        }
        return (sum == num) ? true : false;
    }
}
