package net_and_stream.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Stream流 —— 遍历集合，对集合的数据进行过滤（Stream流关注的是做什么，而不是怎么做）
 */
public class Stream_test {

    public static void main(String[] args) {
        //创建一个集合，存储姓名
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //对集合中的元素进行过滤
        // 1.姓张的人，存储到一个集合
        // 2.对第一步再进行过滤，只要姓名长度为3的人，存储到一个新的集合
        // 3.遍历集合
        list.stream().filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .forEach(name -> System.out.println(name));
    }
}
