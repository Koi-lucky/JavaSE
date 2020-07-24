package leetcode;

public class SortCharArrays {

    public static void main(String[] args) {
        char[] chars = {'R', 'B', 'B', 'b', 'W', 'W', 'B', 'R', 'B', 'w'};
        sort(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    public static void sort(char[] chars) {
        if(chars == null) {
            System.out.println("所输入的参数不合法！");
            return;
        }
        //用于保存52个字符出现的次数，小写字母保存在下标为偶数的位置，大写字母保存在下标为奇数的位置
        //采用这种保存方法，可以保证在这个数组中小写字母出现在大写字母之前
        int[] charCount = new int[52];
        for (int i = 0; i < chars.length; i++) {
            //对小写字母出现的次数进行比较
            if(chars[i] > 'a' && chars[i] < 'z') {
                //计算小写字母出现的次数
                charCount[(chars[i] - 'a') * 2] ++;
            } else if(chars[i] > 'A' && chars[i] < 'Z') {
                //计算大写字母出现的次数
                charCount[(chars[i] - 'A') * 2 + 1] ++;
            }
        }
        //根据各个字符出现的次数按顺序生成排序后的字符数组
        int index = 0;
        for (int i = 0; i < charCount.length; i++) {
            //这个字符在原始数组中存在
            if(charCount[i] != 0) {
                //小写字母
                if(i % 2 == 0) {
                    for (int j = 0; j < charCount[i]; j++) {
                        chars[index ++] = (char)(i / 2 + 'a');
                    }
                }
                //大写字母
                else {
                    for (int j = 0; j < charCount[i]; j++) {
                        chars[index ++] = (char)((i - 1)/ 2 + 'A');
                    }
                }
            }
        }
    }
}
