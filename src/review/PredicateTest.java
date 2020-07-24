package review;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Integer[] arr = { -12345, 9999, 520, 0, -38, -7758520, 941213};
        // 1.使用lambda表达式创建Predicate对象p1,p1能判断整数是否是自然数(大于等于0)
        Predicate<Integer> p1 = (s) -> s >= 0;
        // 2.使用lambda表达式创建Predicate对象p2,p2能判断整数的绝对值是否大于100
        Predicate<Integer> p2 = (s) -> Math.abs(s) > 100;
        // 3.使用lambda表达式创建Predicate对象p3,p3能判断整数是否是偶数
        Predicate<Integer> p3 = (s) -> s % 2 == 0;
        //4.遍历arr，仅利用已创建的Predicate对象(不使用任何逻辑运算符)，完成以下需求
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (Integer ele : arr) {
            // 统计自然数的个数
            if(p1.test(ele)) {
                count1++;
            }
            // 统计负整数的个数
            if(p1.negate().test(ele)) {
                count2++;
            }
            // 统计绝对值大于100的偶数个数
            if(p2.and(p3).test(ele)) {
                count3++;
            }
            // 统计是负整数或偶数的数的个数
            if(p1.negate().or(p3).test(ele)) {
                count4++;
            }
        }
        //分别打印结果
        System.out.println("统计自然数的个数:" + count1);
        System.out.println("统计负整数的个数:" + count2);
        System.out.println("统计绝对值大于100的偶数个数:" + count3);
        System.out.println("统计是负整数或偶数的数的个数:" + count4);
    }
}
