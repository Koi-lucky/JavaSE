package extendstest;

import java.util.ArrayList;


/*
【发普通红包的案例】
1.群主、群成员都属于一个类——员工类，他两有共同的成员变量;姓名和账户余额
    员工类：两个成员变量——姓名、账户余额
2.群主类里面要定义一个“发红包”的方法，而群员的类里面要定义一个“收红包”的方法
    发红包的方法：
    {
        (1)返回值类型：集合类型——ArrayList<Integer>
           方法名称：send
           参数列表：要发的总钱数（int totalMoney）、分几份发出去（int count）
       （2）建一个集合用来存放将要分的红包
        (3)先看看自己的账户余额的钱数够不够发这个红包（即比较一下余额和要发的总钱数的大小），不够就发不了红包
        (4)按群成员的人数开始发红包，先给每个红包里面均等分钱，如果有零头直接包到最后一个红包里
        (5)把分好的红包一个一个放到集合中去，
       （6)最后要更新一下群主的余额——扣除掉发出去的钱数
    }
    收红包的方法：
    {
        (1)返回值类型：收入自己的钱包中，无需返回值类型——void类型
           方法名称：receive
           参数列表：从集合中任选一个收红包——ArrayList<Integer>
        (2)随机获取一个集合当中的索引编号,任选一个红包给我自己
        (3)根据索引，从集合当中删除你所选的红包，
        (4)领完红包之后，将领的红包加入自己的余额去
    }
3.创建一个主函数直接调用（创建一个群主+若干个群成员）
 */
public class RedLunckyMoney {

    public static void main(String[] args) {

        //new一个群主
        Manager manager = new Manager("群主",298);

        //new几个群成员
        Member one = new Member("群员A",0);
        Member two = new Member("群员B",0);
        Member three = new Member("群员C",0);
        Member four = new Member("群员D",0);

        //展示输出一下各自的账户余额
        manager.show();
        one .show();
        two.show();
        three.show();
        four.show();
        System.out.println("===============");

        //群主总共发111块钱的红包，均分成4份
        ArrayList<Integer> redList = manager.send(111,4);
        //接下来是四个成员收红包
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);
        four.receive(redList);


        //再显示一下收发完红包之后每个人账户的余额
        //现在的每个红包金额为：27、27、27、30
        //随机发给四个人
        manager.show();//298-111=187
        one .show();//随机红包
        two.show();//随机红包
        three.show();//随机红包
        four.show();//随机红包
    }
}
