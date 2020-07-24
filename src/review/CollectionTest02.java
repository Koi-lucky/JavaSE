package review;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest02 {

    public static void main(String[] args) {
        //将数组转为集合
        int[] arr = { 10, 5, 56, 48, 16, 45};
        ArrayList<Integer> list = listTest(arr);
        for (Integer ele : list) {
            System.out.print( ele + " ");
        }
        System.out.println();
        System.out.println("============");
        Collection<Integer> collection = new ArrayList<>();
        collection.add(100);
        collection.add(200);
        collection.add(300);
        //判断集合是否为空
        if(collection.isEmpty()) {
            System.out.println("集合为空！");
        } else {
            System.out.println("集合不为空！");
        }
        //判断集合里面是否含有150这个元素，有则返回true，没有则返回false
        if(collection.contains(150)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        //将集合转为数组
        Object[] obj = collection.toArray();
        for (Object o : obj) {
            System.out.print( o + " ");
        }
    }

    public static ArrayList<Integer> listTest(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int ele : A) {
            list.add(ele);
        }
        return list;
    }
}
