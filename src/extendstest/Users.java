package extendstest;

import java.util.ArrayList;
import java.util.Random;


//定义一个用户类，群主和群成员都属于用户类
public class Users {
    private String name;
    private int money;

    public Users() {
    }

    public Users(String name, int money) {
        this.name = name;
        this.money = money;
    }

    //自定义一个方法，显示一下用户当前的余额数
    public void show() {
        System.out.println("我是" + name + ",我的余额数为：" + money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}


//定义一个群主类
class Manager extends Users {

    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney, int count) {
        //首先要建立一个集合，用来存储若干个红包的金额
        ArrayList<Integer> redList = new ArrayList<>();

        //首先看一下群主有多少钱
        int leftMoney = super.getMoney();//群主当前的余额
        if (totalMoney > leftMoney) {
            System.out.println("您的余额不足！");
            return redList;//返回空集合
        }

        //把发出去的钱扣掉，其实就是重新设置金额
        super.setMoney(leftMoney - totalMoney);

        //发红包需要平均分成count份
        int avg = totalMoney / count;
        int mod = totalMoney % count;//剩下不能再分的零头

        //咱就直接拔除不开的零头包在最后一个红包中
        //下面把红包一个一个放到集合中
        for (int i = 0; i < count; i++) {
            if(i == count - 1) {
                redList.add(avg + mod);
            } else {
                redList.add(avg);
            }
        }

        return redList;
    }
}



//定义一个群成员类
class Member extends Users {
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> list) {

        //从多个红包中挑一个给我自己
        //随机获取一个集合当中的索引编号
        int index = new Random().nextInt(list.size());
        //根据索引，从集合当中删除你所选的红包，并且得到被删除的红包给我自己
        int delta = list.remove(index);
        //当前成员自己本来有多少钱
        int money = super.getMoney();
        //领完红包之后，将领的红包加入自己的余额去
        super.setMoney(money + delta);

    }
}




