package interfacetest;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *  有BUG！！！缺一个页面相关的初始化操作！！！
 */
public class RedPacketTest {

    public static void main(String[] args) {
        //测试发红包
        RedPacket rp = new RedPacket("大红包");
        //设置群主的名称
        rp.setOwername("王思聪");
        //设置红包类型为——普通红包
//        rp.setOpeanMode(new Common());//普通红包
        //设置红包类型为——拼手气红包
        rp.setOpeanMode(new Lucky());//拼手气红包
    }
}

//一个抽象类，包含了红包的一些属性，是红包的界面
abstract class RedPacketFrame extends JFrame {
    //群主名
    public String owername = "谁谁谁";
    //红包的类型：普通红包还是拼手气红包
    public OpenMode opeanMode = null;
    //生成红包的界面
    //title为界面的标题
    public RedPacketFrame(String title) {
        super(title);
        //这里缺一个页面相关的初始化操作
    }

    public void setOwername(String owername) {
        this.owername = owername;
    }

    public void setOpeanMode(OpenMode opeanMode) {
        this.opeanMode = opeanMode;
    }
}

//一个接口，用来指定红包的类型
interface OpenMode {
    /**
     *  将 totalMoney 分成 count 份，保存到 ArrayList<Integer> 中，并返回
     * @param totalMoney 总金额，单位是“分”，总金额为方便计算，转换为分
     * @param count 红包的个数
     * @return 元素为各个红包的金额值，所有元素的值累加和等于总金额
     */
    public abstract ArrayList<Integer> divide(int totalMoney, int count);
}

//定义一个红包类，来继承RedPacketFrame
class RedPacket extends RedPacketFrame {
    public RedPacket(String title) {
        super(title);
    }
}

//设置普通红包的打开方式
class Common implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int count) {
        //创建保存各个红包的金额的集合
        ArrayList<Integer> list = new ArrayList<>();
        //定义循环的次数，总个数-1次
        int time = count - 1;
        //一次计算，生成平均金额
        int money = totalMoney / count;
        //循环分配
        for (int i = 0; i < time; i++) {
            //添加到集合中
            list.add(money);
            //总金额扣除已分配金额
            totalMoney -= money;
        }
        //剩余的金额，全包在最后一个红包里
        list.add(totalMoney);
        System.out.println("普通红包金额：" + list);
        return list;
    }
}

//设置拼手气红包的打开方式
class Lucky implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int count) {
        //创建保存各个红包的金额的集合
        ArrayList<Integer> list = new ArrayList<>();
        //定义循环的次数，总个数-1次
        int time = count - 1;
        //创建随机数对象
        Random random = new Random();
        //循环分配
        for (int i = 0; i < time; i++) {
            /*
                每次重新计算，生成随机金额
                随机的范围：totalMoney / count * 2 ，totalMoney不断的减少
                count 也不断的减少，所以这是一个可变化的范围
             */
            int money = random.nextInt(totalMoney / count * 2) + 1;
            //添加到集合中
            list.add(money);
            //总金额扣除已分配金额
            totalMoney -= money;
            //红包个数自减
            count--;
        }
        //剩余的金额，全包在最后一个红包里
        list.add(totalMoney);
        return list;
    }
}