package leetcode;

public class IsPowerOfThree {

    public static void main(String[] args) {
        //测试一下3的幂
        System.out.println(isPowerOfThree(45));
    }

    //我们所要做的就是将数字转换为以3为底的基数 ，并检查它是否为前导1，后跟所有 0。
    //两个内置的Java函数将帮助我们前进。
    //String baseChange = Integer.toString(number, base);
    //
    //上面的代码将 number 转换以 base 为底的基数，并以字符串形式返回结果。例如，integer.toString（5，2）=“101” 和 integer.toString（5，3）=“12”。
    //boolean matches = myString.matches("123");
    //
    //上面的代码检查字符串中是否存在特定的正则表达式。例如，如果字符串 mystring 中存在子字符串 “123”，上面的内容将返回 true。
    //boolean powerOfThree = baseChange.matches("^10*$")
    //
    //我们将使用上面的正则表达式来检查字符串是否以1 ^1 开头，后跟 0 或 多个 0 0* 并且不包含任何其他值 $。
    public static boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
