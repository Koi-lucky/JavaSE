package datastructure;
/**
 * 直接将元素添加到链表的尾部，不考虑顺序
 */
public class SingleLinkedListText1 {

    public static void main(String[] args) {

        //先创建几个节点
       HeroNode hero1 = new HeroNode(1, "宋江","及时雨");
       HeroNode hero2 = new HeroNode(2, "卢俊义","玉麒麟");
       HeroNode hero3 = new HeroNode(3, "吴用","智多星");
       HeroNode hero4 = new HeroNode(4, "林冲","豹子头");

       //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入元素
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        //显示
        singleLinkedList.list();
    }
}



//定义一个SingleLinkedList来管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点，头结点不能动，头结点一变化就找不到链表了
    private HeroNode head = new HeroNode(0, "","");

    //添加节点到链表
    //当不考虑编号顺序时
    //1.先找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {

        //因为头结点不能动，因此我们需要一个辅助变量来遍历——>temp
        HeroNode temp = head;//temp变量指向头节点
        //遍历链表，找到最后节点
        while(true) {
            //找到链表的最后
            if(temp.next == null) {//找到了
                break;
            }
            //如果没找到，就把temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }

    //显示链表，遍历
    public void list() {
        //先判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能为空，不能动，所以需要一个辅助变量来遍历
        HeroNode temp = head.next;//已经判断链表不为空，所以他至少有一个结点
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出这个节点的信息
            System.out.println(temp);
            //将temp后移,不然是个死循环
            temp = temp.next;
        }
    }
}


//定义一个HeroNode，每个heroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重写toString


    @Override
    public String toString() {
        return "HeroNode [ no = " + no + ", name = " + name +", nickname = " + nickname + "]";
    }
}