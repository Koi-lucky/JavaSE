package extendstest;

import java.util.ArrayList;
import java.util.Random;

/**
 * ArrayList的使用步骤：一要创建一个对象；二要导包。
 *
 */
public class ArrayListText01 {
    public static void main(String[] args) {
        //创建一个学生数组
        ArrayList<String> list = new ArrayList<>();

        //创建学生对象
        String s1 = "曹操";
        String s2 = "刘备";
        String s3 = "孙权";

        //打印学生ArrayList集合
        System.out.println(list);

        //把学生对象作为元素添加到集合
        list.add(s1);
        list.add(s2);
        list.add(s3);

        //打印学生ArrayList集合
        System.out.println(list);

    }
}




/**
 * ArrayList类常用的方法和遍历
 *
 *
 * 对于元素的操作,基本体现在——增、删、查。常用的方法有：
public boolean add(E e) ：将指定的元素添加到此集合的尾部。
public E remove(int index) ：移除此集合中指定位置上的元素。返回被删除的元素。
public E get(int index) ：返回此集合中指定位置上的元素。返回获取的元素。
public int size() ：返回此集合中的元素数。遍历集合时，可以控制索引范围，防止越界。
 */
class ArrayListText02 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> list = new ArrayList<String>();

        //添加元素
        list.add("hello");
        list.add("world");
        list.add("java");

        //public E get(int index):返回指定索引处的元素
        System.out.println("get:"+list.get(0));
        System.out.println("get:"+list.get(1));
        System.out.println("get:"+list.get(2));

        //public int size():返回集合中的元素个数
        System.out.println("size:"+list.size());

        //public E remove(int index):删除指定索引处的元素，返回被删除的元素
        System.out.println("remove:"+list.remove(0));

        //遍历输出
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}


/**
 *ArrayList类如何存储基本数据类型
 *
 * ArrayList对象不能存储基本类型，只能存储引用类型的数据。类似 <int> 不能写，但是存储基本数据类型对应的
 * 包装类型是可以的。所以，想要存储基本类型数据， <> 中的数据类型，必须转换后才能编写
 *
 * 【重点】只有 Integer 和 Character 需要特殊记忆，其他基本类型只是首字母大写即可！
 */
class ArrayListText0301 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
    }
}
class ArrayListText0302 {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<Character>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        System.out.println(list);
    }
}


/**
 * 数值添加到集合
 *
 * 生成6个1~33之间的随机数，添加到集合，并遍历
 */
class ArrayListText04 {
    public static void main(String[] args) {
        //创建Random对象
        Random random = new Random();
        //创建ArrayList对象
        ArrayList<Integer> list = new ArrayList<Integer>();
        //生成6个1~33之间的随机整数
        //并添加这6个随机数到集合
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(33)+1;
            list.add(r);
        }
        //遍历集合输出
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}




/**
 * 打印集合方法
 *
 * 定义以指定格式打印集合的方法（用ArrayList类型作为参数）,使用{}扩起集合，使用@分隔每个元素。格式参照{元素@元素@元素@元素}
 */
class ArrayListText05 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> list = new ArrayList<String>();

        //往集合里添加元素
        list.add("张三丰");
        list.add("霍建华");
        list.add("撒贝宁");
        list.add("李时珍");
        list.add("张三");
        list.add("李四");
        list.add("王麻子");

        //调用方法
        printArrayList(list);

    }
    public static void printArrayList(ArrayList<String> list) {
        //拼接左括号
        System.out.print("{");
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            //获取元素
            String s = list.get(i);
            //拼接@符号
            if (i != list.size() - 1) {
                System.out.print(s+"@");
            } else {
                //拼接右括号
                System.out.print(s+"}");
            }
        }
    }
}


/**
 * 获取集合方法
 *定义获取所有偶数元素集合的方法（ArrayList类型作为返回值）
 * 题目：用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合中。要求用自定义方法来实现筛选
 *
 * 分析：
 * 1.需要建了一个大集合，用来存储随机数字：<integer>
 * 2.随机数字获取就用Random类，nextInt
 * 3.循环20次，把随机数字放入大集合中：for循环，add方法
 * 4.定义一个方法，用来筛选。
 * 筛选：根据大集合，筛选符合要求的元素，得到小集合。
 * 三要素：
 * 返回值类型：ArrayList小集合（里面的元素个数不确定）
 *方法名称：getSmallList
 *参数列表：ArrayList大集合（里面装有20个随机数字）
 * 5.判断(if)是偶数：num % 2==0
 * 6.如果是偶数，就放到小集合里，否则便不管
 */
class ArrayListText06 {
    public static void main(String[] args) {
        //创建一个大集合，用来存放获取的随机数
        ArrayList<Integer> bigList = new ArrayList<>();
        //Random类用于产生随机数
        Random r = new Random();

        //用for循环将产生的随机数放入到大集合中去
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(100)+1;//随机数的范围0~100
            bigList.add(num);//将随机数挨个放进去
        }

        //定义的一个小集合，用于存放返回值
        ArrayList<Integer> smallList = getSmallList(bigList);

        System.out.println("偶数总共有多少个："+smallList.size());//方便我们知道有多少个偶数
        //用一个for循环遍历输出所得到的偶数
        for (int i = 0; i < smallList.size(); i++) {
            System.out.println(smallList.get(i));
        }
    }

    //定义的一个getSmallList方法，用于从20个随机数中筛选相对应的偶数
    //该方法的参数列表为参数列表：ArrayList大集合（里面装有20个随机数字）
    //该方法的返回值类型为ArrayList小集合（里面的元素个数不确定）
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList) {
        //定义一个小集合，用于存放从随机数里筛选出的偶数
        ArrayList<Integer> smallList = new ArrayList<>();
        //利用for循环对所存取的随机数进行挨个筛选
        for (int i = 0; i < bigList.size(); i++) {
            int num = bigList.get(i);//把随机数取出来
            if(num % 2 == 0) {
                //判断是否是偶数，是的话赋给小集合，不是就不管它
                smallList.add(num);
            }
        }
        return smallList;//最后返回小集合
    }
}


/**
 * 对象添加到集合
 *
 * 1.创建一个Phone手机类，其中包括四部分：private,this.,Getter,Setter
 * 2.创建一个集合，用来存储手机对象，泛型<Phone>
 * 3.根据类，创建4个手机对象
 * 4.讲4个手机对象添加到集合中;add
 * 5.遍历集合：fro,size,get
 */
class ArrayListText07 {
    public static void main(String[] args) {
        ArrayList<Phone> list = new ArrayList<>();

        Phone ph01 = new Phone("华为",2000.0);
        Phone ph02 = new Phone("三星",3000.0);
        Phone ph03 = new Phone("苹果",5500.0);
        Phone ph04 = new Phone("小米",1900.0);

        list.add(ph01);
        list.add(ph02);
        list.add(ph03);
        list.add(ph04);

        for (int i = 0; i < list.size(); i++) {
            Phone ph = list.get(i);
            System.out.println(ph.getBrand()+"-------"+ph.getPrice());
        }

    }
}