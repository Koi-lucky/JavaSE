package functionalInterface;

import java.util.function.Supplier;

/**
 * Supplier<T>接口 被称之为 “生产型接口”，指定接口的泛型是什么类型，那么接口中的get方法就会产生什么类型的数据
 */
public class Function_Supplier {
    //定一个方法，方法的参数传递Supplier<T>接口，泛型执行String，get方法就会返回一个String
    public static String getString(Supplier<String> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        //调用getString方法，方法的参数Supplier是一个函数式接口，
        /*
        // 1.所以可以传递lambda表达式
        String s = getString( () -> {
            //产生一个字符串并返回
            return "胡歌";
        });
        System.out.println(s);
        */

        //优化lambda表达式
        String s = getString( () -> "胡歌");
        System.out.println(s);

        System.out.println("==============");


        //求int型数组中的最大值
        int[] arr = { 10, 1, 56, 98, 624, 26, 794, 16};
        //使用getMax方法，方法的参数Supplier是一个函数式接口，所以可以传递lambda表达式
        int num = getMax(() -> {
            //获取数组的最大值并返回
            int max = arr[0];
            for (int i : arr) {
                if(i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println( "数组中元素的最大值为：" + num);
    }


    /**
     * 【案例】求int型数组中的最大元素
     */
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }
}
