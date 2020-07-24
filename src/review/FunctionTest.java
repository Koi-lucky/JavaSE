package review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        //1.使用lambda表达式分别将以下功能封装到Function对象中
        //a)求Integer类型ArrayList中所有元素的平均数
        Function<ArrayList<Integer>, Integer> f1 = (list) -> {
            Integer sum = 0;
            for (Integer ele : list) {
                sum += ele;
            }
            return sum / list.size();
        };
        //b)将Map<String,Integer>中value存到ArrayList<Integer>中
        Function<Map<String, Integer>, ArrayList<Integer>> f2 = (map) -> {
            Collection<Integer> values = map.values();
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(values);
            return list;
        };
        //2.以学生姓名为key成绩为value创建集合并存储数据，使用刚刚创建的Function对象求学生的平均成绩
        Map<String, Integer> map = new HashMap<>();
        map.put("秦晓存", 59);
        map.put("古天洛", 59);
        map.put("渣渣辉", 59);
        map.put("蓝小月", 59);
        map.put("皮几万", 59);

        //利用Function求平均成绩
        Integer avg = f2.andThen(f1).apply(map);
        System.out.println("学生平均成绩为：" + avg);
    }
}
