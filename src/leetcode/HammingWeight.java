package leetcode;

public class HammingWeight {

    public static void main(String[] args) {
        //测试一下该数的二进制表示数中有几个1
        System.out.println(hammingWeight(31));
    }

    public static int hammingWeight(int n) {
        //巧用 n & (n - 1)
        //(n−1) 解析： 二进制数字 n 最右边的 1 变成 00，此 1右边的 0 都变成 1 。
        //n \& (n - 1)解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
        //
        //初始化数量统计变量 res 。
        //循环消去最右边的 1 ：当 n = 0 时跳出。每次消去一个1
        //res += 1 ： 统计变量加 1 ；
        //n &= n - 1 ： 消去数字 n 最右边的 1 。
        int res = 0;//统计1个数
        while(n != 0) {
            res ++;
            n = n & (n - 1);//每次消去一个1
        }
        return res;
    }
}
