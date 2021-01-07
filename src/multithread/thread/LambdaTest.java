package multithread.thread;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/7 17:21
 */
public class LambdaTest {

    public static void main(String[] args) {
        String sstr = "你要吃包子么？？";
        // 接口形式
 /*       chiBaozi(sstr, new ChiBaoZi() {
            @Override
            public String printStr(String s) {
                return s;
            }
        });*/
        // Lambda表达式标准形式
       /* chiBaozi(sstr, (String s) ->{
                return s;
            });*/
        // Lambda表达式推导
        // 1.去掉小括号里的参数类型
      /*  chiBaozi(sstr, (s) ->{
            return s;
        });*/
        // 2.若小括号里只有一个参数，则小括号省略
     /*   chiBaozi(sstr, s ->{
            return s;
        });*/
        // 3.如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。【大括号、return、语句分号必须同时删去】
        chiBaozi(sstr, s -> s);


    }

    private static void chiBaozi(String s, ChiBaoZi chi) {
        String ss = chi.printStr(s);
        System.out.println(ss);
    }
}

interface ChiBaoZi {
    String printStr(String s);
}