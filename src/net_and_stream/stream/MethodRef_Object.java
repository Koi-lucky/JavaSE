package net_and_stream.stream;

/**
 * 通过【对象名】引用【成员方法】
 * 前提：对象名已经存在，成员方法已经存在
 */
public class MethodRef_Object {

    public static void main(String[] args) {
        //调用printString方法，方法的参数是一个函数式接口
        printString((String s) -> {
            //创建MethodRerObject对象
            MethodRerObject obj = new MethodRerObject();
            // 调用MethodRerObject中的成员方法printUpperCaseString
            obj.printUpperCaseString(s);
        });

        //优化 —— 对象：MethodRerObject和 成员方法：printUpperCaseString 全都已经存在，直接引用
        MethodRerObject obj = new MethodRerObject();
        printString(obj :: printUpperCaseString);
    }

    //定义一个方法，方法的参数传递Pritable接口
    public static void printString(Pritable p) {
        p.print("Hello");
    }
}

//定义一个成员方法
class MethodRerObject {
    //传递字符串，把字符串按大写输出
    public void printUpperCaseString(String str) {
        System.out.println(str.toUpperCase());
    }
}

//定义一个函数式接口
@FunctionalInterface
interface Pritable {
    //定义字符串的抽象方法
    public abstract void print(String s);
}