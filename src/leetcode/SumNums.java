package leetcode;

public class SumNums {

    public static void main(String[] args) {
        //测试前n个数的和，要求不能使用乘除、if/else、while、for、等的运算符及操作符
        System.out.println(sumNums(9));
    }

    public static int sumNums(int n) {
        //首先判断输入的数是不是大于0的数
        //再进行递归的加和运算
        //二者用逻辑运算符&&连接起来
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
