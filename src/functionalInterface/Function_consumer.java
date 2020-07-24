package functionalInterface;

import java.util.function.Consumer;

/**
 * Consumer接口 正好与 Supplier 接口相反，Consumer接口 是“消费（使用）”一个数据，其数据类型由泛型决定
 */
public class Function_consumer {
    //定义一个方法，方法的参数传递一个 字符串姓名 ，方法的参数传递Consumer接口，可以使用Consumer接口消费字符串姓名
    public static void method(String name, Consumer<String> con) {
        con.accept(name);
    }

    public static void main(String[] args) {
        //调用method方法，方法的参数Consumer是一个函数式接口，所以可以lambda表达式
        method( "杨幂", (String name) -> {
            //消费方式：直接输出字符串
            System.out.println(name);

            //消费方式：把字符串反转再输出
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });

        System.out.println("================");

        //andThen方法
        method( "HelloJAVA", (t) -> {
            //消费方式：把字符串转为大写再输出
            System.out.println(t.toUpperCase());
        },(t) -> {
            //消费方式：把字符串全转为小写再输出
            System.out.println(t.toLowerCase());
        });
    }


    /**
     * Consumer接口 中 andThen 方法
     */
    //定义一个方法，方法的参数传递 一个字符串 和 两个Consumer接口
    public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
        /*
        con1.accept(s);
        con2.accept(s);
        */
        //使用andThen方法更加便利
        con1.andThen(con2).accept(s);//con1连接con2，先执行con1消费数据，再执行con2消费数据
    }
}
