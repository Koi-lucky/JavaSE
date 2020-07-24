package leetcode;

public class Guess {

    public static void main(String[] args) {

        System.out.println(guessNumber( 10, 6));
    }

    public static int guessNumber(int n, int m) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == m)
                return 0;
            else if (mid > m)
                return -1;
            else
                low = mid + 1;
        }
        return 1;
    }
}
