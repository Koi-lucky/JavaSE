package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ！！给定一个字符串，求每个字符出现的次数！！
 * 【分析】
 * 1.用户输入一个字符串
 * 2.创建一个Map集合，Key表示字符串中的字符，value表示该字符在字符串中出现的次数
 * 3.遍历字符串，获取到每一个字符
 * 4.使用获取到的字符，去Map集合中判断该Key是否存在，
 *      已存在：通过Key去获取value，——> value++ ——> put( key, value)再把新的value存储到集合中
 *      不存在：put( key, 1)
 * 5.遍历Map集合，输出集合
 */
public class HashMapTest {

    public static void main(String[] args) {
        //使用Scanner获取到用户输入的数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();
        //创建一个Map集合，Key表示字符串中的字符，value表示该字符在字符串中出现的次数
        Map<Character,Integer> map = new HashMap<>();
        //遍历字符串，获取到每一个字符
        for (char c : str.toCharArray()) {
              //使用获取到的字符，去Map集合中判断该Key是否存在
            if(map.containsKey(c)) {
                //已存在：通过Key去获取value
                Integer val = map.get(c);
                val++;
                map.put( c, val);
            } else {
                //不存在
                map.put( c, 1);
            }
        }
        //遍历Map集合，输出集合
        for (Character key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
