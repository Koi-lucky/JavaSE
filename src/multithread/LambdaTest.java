package multithread;

/**
 * 【1.Lambda 使用前提】
 *              a.使用Lambda要求具有接口，且要求接口中有且仅有一个抽象方法
 *                              （有且仅有一个抽象方法的接口，称为函数式接口）
 *              b.使用Lambda 必须具有上下文推断
 *
 *
 * 【2.Lambda 表达式的【标准】格式：】
 *              由三部分组成：a.一些参数
 *                            b.一个箭头
 *                            c.一段代码
 *                      格式：
 *                           （参数列表）-> {一些重写方法的代码};
 *            格式的解释说明：
 *                            （）：接口中抽象方法的参数列表，没有参数，就空着；有参数就出参数，多个参数使用逗号分隔
 *                             -> ：传递的意思，把参数传递给方法体
 *                             { }：重写接口的抽象方法的方法体
 *
 * 【3.Lambda 表达式的【省略】格式：】
 *              Lambda 表达式：凡是根据上下文推导出来的内容，就可以省略
 *              可以省略的内容：
 *                          a.（参数列表）：括号中参数列表的数据类型，可以省略不写
 *                          b.（参数列表）：如果括号中的参数只有一个，那么 类型 和 （） 都可以省略
 *                          c.｛一些代码｝：如果｛｝中的代码只有一行，无论是否有返回值，都可以省略（｛｝，return，分号）
 *                                 注意：（｛｝，return，分号）这三个，要么都省略，要么都不省略
 */
public class LambdaTest {

    public static void main(String[] args) {
        //1.使用匿名类创建多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "一个新的线程创建了");
            }
        }).start();


        //2. 使用Lambda表达式创建多线程
        new Thread(() ->{ System.out.println(Thread.currentThread().getName() + "一个新的线程创建了"); }).start();

        //3.优化 Lambda表达式——> 省略版Lambda表达式
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "一个新的线程创建了")).start();
    }
}
