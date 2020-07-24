package tenalgorithms;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        //输出一下该字符串（子串）的部分匹配值表
        System.out.println(Arrays.toString(kmpNext(str2)));
        //输出str2第一次出现的位置
        System.out.println(kmpSearch(str1 , str2, kmpNext(str2)));
    }


    //获取到一个字符串（子串）的部分匹配值表
    public static int[] kmpNext(String string) {
        //创建一个next数组，用于保存部分匹配值
        int[] next = new int[string.length()];
        next[0] = 0;//如果字符串的长度为1，部分匹配值就为0
        for (int i = 1 , j = 0; i < string.length(); i++) {
            //KMP算法的核心点
            //当string.charAt(i)!=string.charAt(j)时，需要从next[j-1]重新获取j
            //知道我们发现二者相等时，才退出
            while(j > 0 && string.charAt(i) != string.charAt(j)) {
                j = next[j - 1];
            }
            //当string.charAt(i)==string.charAt(j)时，部分匹配值自增1
            if(string.charAt(i) == string.charAt(j)) {
                j ++;
            }
            next[i] = j;
        }
        return next;
    }

    //KMP的搜索算法
    public static int kmpSearch(String str1 ,String str2, int[] next) {
        //遍历
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //KMP算法的核心点
            //当str1.charAt(i)!=str2.charAt(j)时，需要从next[j-1]重新获取j
            //知道我们发现二者相等时，才退出
            while(j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if(str1.charAt(i) == str2.charAt(j)) {
                j ++;
            }
            if(j == str2.length()) {
                //找到了
                return i - j + 1;
            }
        }
        return -1;
    }

}
