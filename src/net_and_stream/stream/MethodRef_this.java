package net_and_stream.stream;

public class MethodRef_this {

    public static void main(String[] args) {
        new Husband().soHappy();
    }
}

//定义一个函数式接口
@FunctionalInterface
interface RichAble {
    //定义一个想买什么就买什么的方法
    void buy();
}

class Husband {
    //定义一个买房子的方法
    public void buyhouse() {
        System.out.println("北京二环内买一套房");
    }

    //定义一个结婚的方法，参数传递Richable接口
    public void marry(RichAble r) {
        r.buy();
    }

    //定义一个高兴的方法
    public void soHappy() {
        //调用结婚的方法，方法的参数是一个函数式接口
       /*
       marry(() -> {
            //使用this.成员方法，调用本类买房子的方法
            this.buyhouse();
        });
        */

        //优化—— this已存在，成员方法buyhouse也已存在
        marry(this :: buyhouse);
    }
}