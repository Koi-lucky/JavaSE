package com;

import java.util.*;

/**
 * 【斗地主案例2222】—— 有序版本（玩家手里的牌进了行排序）
 * 1.准备牌
 * 2.洗牌
 * 3.发牌
 * 4.看牌
 */
public class DouDiZhu_2 {

    public static void main(String[] args) {
        //1.准备牌
        // 创建一个Map集合，存储牌的索引和组装好的牌
        Map<Integer, String> poker = new HashMap<>();
        //创建一个List集合，存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合，存储花色和牌的序号
        List<String> colors = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        colors.add("♠");
        colors.add("♥");
        colors.add("♣");
        colors.add("♦");
        numbers.add("2");
        numbers.add("A");
        numbers.add("K");
        numbers.add("Q");
        numbers.add("J");
        numbers.add("10");
        numbers.add("9");
        numbers.add("8");
        numbers.add("7");
        numbers.add("6");
        numbers.add("5");
        numbers.add("4");
        numbers.add("3");
        //把大王和小王加入到集合
        // 定义一个索引值
        int index = 0;
        poker.put( index, "大王");
        pokerIndex.add(index);
        index++;
        poker.put( index, "小王");
        pokerIndex.add(index);
        index++;
        //循环嵌套遍历两个数组，组装52张牌
        for (String s : numbers) {
            for (String c : colors) {
                //再把组装好的牌存入集合中
                poker.put( index,s + c);
                pokerIndex.add(index);
                index++;
            }
        }

        //2.洗牌
        Collections.shuffle(pokerIndex);

        //3.发牌定义4个集合，存储玩家的牌的索引 和 底牌的索引
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();
        // 每轮发牌 【先放】三张底牌（索引值>=51）
        // 再用求余运算给三个玩家发牌
        for (int i = 0; i < pokerIndex.size(); i++) {
            // 先放底牌
            // 再轮流发牌
            if(i >= 51) {
                dipai.add(pokerIndex.get(i));
            } else if(i % 3 == 0) {
                player1.add(pokerIndex.get(i));
            }else if(i % 3 == 1) {
                player2.add(pokerIndex.get(i));
            }else if(i % 3 == 2) {
                player3.add(pokerIndex.get(i));
            }
        }

        //4.排序 —— 默认（索引值是）从大到小排序
        Collections.sort(player1);
        Collections.sort(player1);
        Collections.sort(player1);
        Collections.sort(dipai);

        //5.看牌
        lookPoker( "刘德华", poker, player1);
        lookPoker( "周润发", poker, player2);
        lookPoker( "周星驰", poker, player3);
        lookPoker( "底牌", poker, dipai);
    }

    /**
     * 定义一个看牌的方法，提高代码的复用率
     * 参数：
     *      String  name :玩家名称
     *      HashMap< Integer, String>  poker :存储牌的poker集合
     *      ArrayList<Integer> List :存储玩家和底牌的 List集合
     * 查表法：
     *      遍历玩家或者底牌的集合，获取牌的索引
     *      使用牌的索引，去Map集合中，找到对应的牌
     */

    private static void lookPoker(String name, Map<Integer, String> poker, ArrayList<Integer> list) {
        //输出玩家名，不换行
        System.out.println(name + ":");
        //遍历玩家或者底牌集合，获取牌的索引
        for (Integer key : list) {
            System.out.print(poker.get(key) + " ");
        }
        System.out.println();
    }
}
