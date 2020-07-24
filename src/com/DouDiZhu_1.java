package com;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 【斗地主案例1111】—— 无序版本（玩家手里的牌没有进行排序）
 * 1.准备牌
 * 2.洗牌
 * 3.发牌
 * 4.看牌
 */
public class DouDiZhu_1 {

    public static void main(String[] args) {
        //1.准备牌
        //定义一个存储54张牌的集合，泛型使用String
        ArrayList<String> poker = new ArrayList<>();
        // 定义两个数组，一个用于存储花色，一个用于存储牌的序号
        String[] colors = { "♠", "♥", "♣", "♦"};
        String[] number = { "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        //先把大王和小王存储到集合中
        poker.add("大王");
        poker.add("小王");
        //循环嵌套遍历两个数组，组装52张牌
        for (String s : number) {
            for (String c : colors) {
                //再把组装好的牌存入集合中
                poker.add(s + c);
            }
        }

        //2.洗牌
        //使用集合工具类 Collections 中的方法 static void shuffle(List<?> list) 使用默认随机源对指定列表进行置换
        Collections.shuffle(poker);

        //3.发牌定义4个集合，存储玩家的牌 和 底牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        // 每轮发牌 【先放】三张底牌（索引值>=51）
        // 再用求余运算给三个玩家发牌
        for (int i = 0; i < poker.size(); i++) {
            // 先放底牌
            // 再轮流发牌
            if(i >= 51) {
                dipai.add(poker.get(i));
            } else if(i % 3 == 0) {
                player1.add(poker.get(i));
            }else if(i % 3 == 1) {
                player2.add(poker.get(i));
            }else if(i % 3 == 2) {
                player3.add(poker.get(i));
            }
        }


        // 4.看牌 —— 也就是遍历三个玩家的数组和底牌数组
        System.out.println("刘德华：" + player1);
        System.out.println("周星驰：" + player2);
        System.out.println("周润发：" + player3);
        System.out.println("底牌：" + dipai);
    }
}
