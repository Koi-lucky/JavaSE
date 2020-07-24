package leetcode;

import java.util.LinkedList;

public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "abaccdeff";
        String ss = "cc";
        System.out.println(firstUniqChar2(ss));
    }

    //两种解法
    public static char firstUniqChar2(String s) {
        char[] ch = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < ch.length; i++) {
            if(!list.contains(ch[i])) {//列表中没有相同的数的话，就加入
                list.add(ch[i]);
            } else {
                //如果列表中哟相同的数，那就把列表中相同的数删除
                list.remove((Object)ch[i]);
            }
        }
        //循环结束后，列表中剩余的字符就是字符串中只出现一次的字符
        //要得到第一个只出现一次的字符，输出列表第一个字符就好
        if(!list.isEmpty()) {
            return list.get(0);
        }
        return ' ';
    }


    public static char firstUniqChar1(String s) {
        int[] count = new int[256];//一共就256个ASCII字符
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            count[ch[i]]++;//统计每个字符出现的次数
        }
        for (int i = 0; i < ch.length; i++) {
            if(count[ch[i]] == 1) {
                return ch[i];
            }
        }
        return ' ';
    }
}
