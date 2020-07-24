package leetcode;

public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        if(num < 10) {
            return num;
        }
        num = num/10+num%10;
        return addDigits(num);
    }
}
