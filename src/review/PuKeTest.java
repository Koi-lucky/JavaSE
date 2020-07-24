package review;

import java.util.ArrayList;
import java.util.Random;

public class PuKeTest {

    public static void main(String[] args) {
        //生成扑克牌
        //花色数组
        String[] hs = { "红桃", "梅花", "黑桃", "方片"};
        // 点数数组
        String[] ds = { "A", "4", "2", "3", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        //创建一个集合用于存储拍的集合
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("大王");
        list1.add("小王");
        for (String h : hs) {
            for (String d : ds) {
                    list1.add( h + d);
            }
        }
        //从所有的牌中移除n张牌
        ArrayList<String> list2 = randomDelete( list1, 4);
        for (String s : list2) {
            System.out.print(s + " ");
        }
    }

    //随机移除n张牌，保存到新的集合
    public static ArrayList<String> randomDelete(ArrayList<String> list, int n) {
        //判断n是否超出了界限
        if(n > 54 || n < 1) {
            return null;
        }
        //定义一个集合存储要删除的牌
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = new Random().nextInt(list.size());
            String s = list.remove(index);
            list2.add(s);
        }
        return list2;
    }
}
