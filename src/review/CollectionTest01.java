package review;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest01 {

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a : " + listTest(list,"a"));
        System.out.println("b : " + listTest(list,"b"));
        System.out.println("c : " + listTest(list,"c"));
        System.out.println("xxx : " + listTest(list,"xxx"));

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(10);
        list1.add(11);
        list1.add(10);
        list1.add(12);
        System.out.println("返回集合中b元素首次出现的索引：" + listTest(list1,10));
    }

    //统计字符串s在集合中出现的次数
    public static int listTest(Collection<String> list, String s) {
        int count = 0;//计数器
        //遍历集合，寻找目标字符串
        for (int i = 0; i < list.size(); i++) {
            if(list.contains(s)) {
                //没找到一个相同的字符串，计数器加一，再删除这个字符串
                count++;
                list.remove(s);
            }
        }
        return count;
    }

    //返回集合中元素首次出现的索引
    public static int listTest(ArrayList<Integer> list, Integer s) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
