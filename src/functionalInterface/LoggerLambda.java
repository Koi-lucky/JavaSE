package functionalInterface;

/**
 * 【对日志消息进行拼接后，在满足条件的情况下进行打印输出】—— lambda表达式进行优化
 */
public class LoggerLambda {

    public static void main(String[] args) {
        //定义3个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        //调用showLog方法，参数MessageBuilder是一个函数式接口，所以可以传递lambda表达式
        shoeLog( 1, () -> {//只有当日志等级为1时，才调用接口中的方法。否则不调用
            //返回一个拼接好的字符串
            return msg1 + msg2 + msg3 ;
        });
    }

    //定义一个显示日志的方法，方法的参数传递 日志的等级、MessageBuilder接口
    public static void shoeLog(int level, MessageBuilder mb) {
        //对日志的等级进行判断，如果是1级，则调用MessageBuilder接口中的方法
        if(level == 1) {
            System.out.println(mb.builderMessage());
        }
    }
}


//定义一个MessageBuilder接口
@FunctionalInterface
interface MessageBuilder {
    //定义一个拼接消息的抽象方法，返回被拼接的消息
    public abstract String builderMessage();
}