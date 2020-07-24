package net_and_stream.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * 【获取流的三种方式】
 *      1.根据Collection获取
 *      2.根据Map获取
 *      3.根据数组获取
 */
public class GetStream {

    public static void main(String[] args) {
        //2.根据Map获取

        //把集合转换为Stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String,String> map = new HashMap<>();
        // 获取键，存储到一个Set集合
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();

        //1.根据Collection获取
        // 获取值，存储到一个Collection集合
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        // 获取键值对（键与值的映射关系 entry）
        Set<Map.Entry<String,String>> entries = map.entrySet();
        Stream<Map.Entry<String,String>> stream5 = entries.stream();


        //3.根据数组获取
        // 把数组转换为Stream流
        Stream<Integer> stream6 = Stream.of( 1, 2, 3, 4, 5);
        // 可变参数可以传递数组
        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> stream7 = Stream.of(arr);
        String[] arr2 = { "a", "bbb", "cc"};
        Stream<String> stream8 = Stream.of(arr2);
    }
}
