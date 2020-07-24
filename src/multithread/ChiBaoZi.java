package multithread;

/**
 * 测试一下吃包子的进程！
 * 有包子 ——> （店铺WAITING）吃货吃包子 ——> 没包子 ——> (吃货WAITING)店铺做包子
 */
public class ChiBaoZi {

    public static void main(String[] args) {
        //测试类：包含main方法，程序的执行入口，启动程序，
        // 创建包子对象；
        // 创建包子铺线程，开启，生产包子；
        // 创建吃货线程，开启，吃包子；
        BaoZi bz = new BaoZi();
        new BaoZiPu(bz).start();
        new ChiHuo(bz).start();
    }
}

//包子类（资源类）
class BaoZi {
    String pi;//包子皮
    String xian;//包子馅
    Boolean flag = false;//包子的状态，有包子还是没有包子
}

//包子铺类
/*
    包子铺类是一个线程类，可以继承Thread类，
    设置线程任务：生产包子
    生产前先判断有没有包子
    true;
        包子铺调用wait方法进入等待状态
    false:
        包子铺生产包子
        增加一些趣味性：交替生产两种包子
                        有两种状态：（i % 2 == 0）
        包子铺生产好了包子
        修改包子的状态为 true有
        唤醒吃货线程，让吃货线程吃包子
 */
class BaoZiPu extends Thread{
    //1.需要在成员位置创建一个包子变量
    private BaoZi bz;
    //2.使用带参的构造方法，为这个包子变量赋值
    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }
    //设置线程任务：做包子
    @Override
    public void run() {
        //定义一个变量
        int count = 0;
        //使用死循环，让包子铺一直做包子
        while (true) {
            //必须使用同步技术，保证两个线程只能有一个在执行
            synchronized (bz) {
                //对包子的状态进行判断
                if(bz.flag == true) {
                    //包子铺调用wait方法进行等待
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒后，包子铺开始做包子，
                // 增加一些趣味性：交替生产两种包子
                System.out.println("包子铺开始做包子~~~");
                if(count % 2 == 0) {
                    //生产 冰皮五仁陷儿 饺子
                    bz.pi = "冰皮";
                    bz.xian = "伍仁馅";
                } else {
                    //生产 薄皮牛肉大葱馅儿 饺子
                    bz.pi = "薄皮";
                    bz.xian = "牛肉大葱馅";
                }
                count++;
                System.out.println("包子铺正在生产" + bz.pi + bz.xian + "的包子");
                //生产包子需要 3秒
                try {
                    bz.wait(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //包子铺做好了包子，
                // 修改包子的状态
                bz.flag = true;
                //唤醒吃货线程，让吃货线程吃包子
                bz.notify();
                System.out.println( bz.pi + bz.xian + "的包子做好了，吃货来吃吧！");
            }
        }
    }
}

// 吃货类
/*
    吃货类是一个线程类，可以继承Thread类，
    设置线程的任务：吃包子
    吃包子前先判断有没有包子
    false:
        吃货调用wait方法进行等待
    true:
        吃货吃包子
        吃货吃完包子
        修改包子的状态为 false没有
        吃货唤醒包子铺线程，生产包子
 */
class ChiHuo extends Thread{
    //1.需要在成员位置创建一个包子变量
    private BaoZi bz;
    //2.使用带参的构造方法，为这个包子变量赋值
    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }
    //设置线程任务：吃包子
    @Override
    public void run() {
        //使用死循环，让吃货一直吃包子
        while(true) {
            //必须使用同步技术，保证两个线程只能有一个在执行
            synchronized (bz) {
                //对包子的状态进行判断
                if(bz.flag == false) {
                    //吃货调用wait方法进行等待
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒之后，开始吃包子
                System.out.println("吃货正在吃" + bz.pi + bz.xian + "包子");
                //吃货吃完包子
                // 修改包子的状态
                bz.flag = false;
                //吃货唤醒包子铺线程
                bz.notify();
                System.out.println("吃货已经吃完了" + bz.pi + bz.xian + "的包子，包子铺快做包子");
                System.out.println("----------------------------");
            }
        }
    }
}