package review;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//测试一下Map中的方法
public class MapTest {

    public static void main(String[] args) {
        //创建一个Map集合
        Map<String,String> map = new HashMap<>();
        //向集合中添加元素
        map.put( "李晨", "范冰冰");
        map.put( "刘恺威", "杨幂");
        map.put( "罗晋", "唐嫣");
        map.put( "鹿晗", "关晓彤");
        map.put( "黄晓明", "杨颖");
        //测试一下Map中的方法
        mapTest01( map);

        //5.获取一下map中的value
        Collection<String> collection = map.values();
        //6.使用增强for获取一下所有的value
        for (String s : collection) {
            System.out.println(s);
        }
        //7.使用迭代器获取一下所有的value
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    //测试一下Map中的方法
    public static void mapTest01(Map<String,String> map) {
        // 1.使用put修改元素
        String v1 = map.put( "罗晋", "谢霆锋");
        // 2.使用get获取元素
        String str = map.get("大黑牛");//不存在这个字符串，所以为空
        // 3.使用remove删除元素
        String v2 = map.remove("大黑牛");
        System.out.println(v2);
        // 4.打印集合中的元素
        System.out.println(map);
    }
}
