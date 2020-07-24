package tenalgorithms;

//暴力匹配算法
public class ViolenceMatch {

    public static void main(String[] args) {
        String str1 = "你好好 世界好 世界你好 你好啊世世世界！";
        String str2 = "你好啊";
    }

    //暴力匹配
    public static int violenceMatch(String str1, String str2) {
        //将两个字符串转换为数组
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        //设置两个索引值，一个指向str1,一个指向str2
        int i = 0;
        int j = 0;
        //开始匹配
        while(i < s1.length && j < s2.length) {
            //保证匹配的时候，数组不越界
            if(s1[i] == s2[j]) {
                //匹配成功，两索引向后移
                i ++;
                j ++;
            } else {
                //匹配不成功，开始整体回溯，即i = i - （j - 1），j=0
                i = i - j + 1;
                j = 0;
            }
        }
        //判断是否匹配成功
        if(j == s2.length) {
            return i - j;
        } else {
            return -1;
        }
    }


}
