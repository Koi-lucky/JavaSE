package net_and_stream.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 【常用方法】——》 Stream流只能使用一次！
 *      1.逐一处理 ——foreach —— 遍历流中的数据 ——> 【终结方法】：遍历之后就不能再调用流的其他方法
 *      2.过滤 ——filter —— 对流中数据进行过滤
 *      3.映射 —— Map —— 将当前类型的流 转换为 另一种类型的流
 *      4.统计个数 —— count —— 统计流中元素的个数 ——> 【终结方法】：返回值是一个long类型的整数，使用计数之后，就不能再调用其他方法
 *      5.取用前几个 —— limit —— 用于截取流中的元素（只取用前n个元素），对当前流截取，返回一个新的流
 *      6.跳过前几个 —— skip —— 用于跳过元素，（跳过前n个元素，截取使用之后的元素），
 *      7.组合 —— concat —— 用于把流组合到一起
 */
public class Stream_someMethod {

    public static void main(String[] args) {

        Stream<String> stream1 = Stream.of( "张三", "李四", "王五", "赵六");

        //2.过滤 ——filter
        stream1.filter(name -> name.startsWith("张"));//只要姓张的人
        //1.逐一处理 ——foreach
//        stream1.forEach(name -> System.out.println(name));//遍历输出


        //3.映射 —— Map
        Stream<String> stream2 = Stream.of( "1", "2", "3", "4");
        Stream<Integer> stream3 = stream2.map( s -> Integer.parseInt(s));//使用map方法，把String类型的数据 转换为 Integer类型的数据
//        stream3.forEach(num -> System.out.println(num));

        //4.统计个数 —— count
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Stream<Integer> stream4 = list.stream();
        long count = stream4.count();
        System.out.println(count);


        //5.取用前几个 —— limit
        String[] arr = { "美羊羊", "喜羊羊", "懒洋洋", "灰羊羊"};
        Stream<String> stream5 = Stream.of(arr);
        Stream<String> stream6 = stream5.limit(3);//只要前三个元素
//        stream6.forEach(name -> System.out.println(name));

        // 6.跳过前几个 —— skip
        Stream<String> stream7 = stream5.skip(3);//跳过前3个元素，只要最后一个元素
 //       stream7.forEach(name -> System.out.println(name));

        // 7.组合 —— concat
        Stream<String> stream8 = Stream.concat(stream1, stream5);
        stream8.forEach(name -> System.out.println(name));
    }
}
