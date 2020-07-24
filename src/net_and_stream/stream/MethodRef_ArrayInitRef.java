package net_and_stream.stream;

public class MethodRef_ArrayInitRef {
    //定义一个方法，返回数组的长度
    public static int[] createArray(int length, ArrayBuilder arr) {
        return arr.builderArray(length);
    }

    public static void main(String[] args) {
        //调用createArray方法，传递数组的长度和lambda表达式
       /*
       int[] arr = createArray( 10, (int len) -> {
            //根据数组的长度，创建数组并返回
            return new int[len];
        });
        System.out.println(arr.length);
        */

        //优化—— 数组长度已知，数组类型已知
        int[] arr = createArray( 10, int[] :: new);
    }
}

//定义一个创建数组的函数式接口
@FunctionalInterface
interface ArrayBuilder {
    //定义一个创建int类型数组的方法，参数传递数组的长度，返回创建的数组
    int[] builderArray(int length);
}