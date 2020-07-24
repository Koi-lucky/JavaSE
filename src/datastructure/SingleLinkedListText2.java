package datastructure;
/**
 * 1.按结点的顺序插入到链表中去
 * 2.修改节点的信息【注意】是根据编号来修改的，所以编号不能动，如果编号变了那就是添加结点了，而不是修改
 * 3.删除节点信息
 */
public class SingleLinkedListText2 {

    public static void main(String[] args) {

        //先创建几个节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲","豹子头");

        //创建一个链表
        SingleLinkedList2 singleLinkedList = new SingleLinkedList2();
        //加入元素
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);

        //显示
        System.out.println("按顺序添加节点：");
        singleLinkedList.list();

        //测试修改节点信息
        HeroNode2 newHeroNode = new HeroNode2(2, "小噜噜噜噜", "玉麒麟~~~");
        singleLinkedList.upDate(newHeroNode);
        System.out.println("修改后的节点信息为：");
        singleLinkedList.list();


        //测试删除节点信息
        singleLinkedList.del(1);
        singleLinkedList.del(3);
        System.out.println("删除后的节点信息为：");
        singleLinkedList.list();


    }
}


//定义一个SingleLinkedList来管理我们的英雄
class SingleLinkedList2 {
    //先初始化一个头节点，头结点不能动，头结点一变化就找不到链表了
    private HeroNode2 head = new HeroNode2(0, "","");

    //添加节点到链表
    public void add(HeroNode2 heroNode) {

        //方法一：当不考虑编号顺序时
        //1.先找到当前链表的最后节点
        //2.将最后这个节点的next指向新的节点

        //因为头结点不能动，因此我们需要一个辅助变量来遍历——>temp
        HeroNode2 temp = head;//temp变量指向头节点
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
        HeroNode2 temp = head.next;//已经判断链表不为空，所以他至少有一个结点
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




    //方法二：按顺序添加结点，若结点已存在，则添加失败
    public void addByOrder(HeroNode2 heroNode) {
        //头结点不能动，因此我们仍需要一个辅助变量来找到添加的位置
        //单链表——>所以我们要找的位置在temp的下一个位置（即添加位置的前一个节点）
        HeroNode2 temp = head;
        boolean flag = false;//设一个标志位用于判断所要添加的编号是否存在
        while(true) {
            if(temp.next == null) {
                //说明temp已经在链表的尾部
                break;
            }
            if(temp.next.no > heroNode.no) {
                //说明我们已经找到要插入的位置了，在temp的后面
                break;
            } else if(temp.next.no == heroNode.no) {
                //说明该编号已存在
                flag = true;
                break;
            }
            //没找到的话，就将temp后移
            temp = temp.next;
        }
        //现在判断flag的值，也就是判断我们能不能插入节点
        if(flag) {
            System.out.printf("准备插入的%d节点已存在，无法插入！\n", heroNode.no);
        } else {
            //在temp的后面进行插入操作
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //修改节点的信息
    //根据编号来修改，并且编号不能变
    public void upDate(HeroNode2 heroNode) {
        //先判空
        if(head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //定义一个辅助变量来帮助我们找到结点在哪
        HeroNode2 temp = head.next;
        boolean flag = false;//设置一个标志量来判断是否找到节点
        while(true) {
            if(temp == null) {
                //辅助指针已到达链表的尾部
                break;
            }
            if(temp.no == heroNode.no) {
                //找到节点
                flag = true;
                break;
            }
            //指针后移
            temp = temp.next;
        }
        //判断是否找到结点
        if(flag) {
            //修改节点的相关信息
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            System.out.printf("没有找到%d节点的信息！\n",heroNode.no);
        }
    }



    //删除节点
    //头结点不能动，所以需要一个辅助变量来帮助我们找到该节点
    //在比较节点的时候，要用temp.next.no与要删除的节点的no进行比较
    public void del(int no) {
        HeroNode2 temp = head;
        boolean flag = false;//设置一个标志量用于判断是否找到要删除的节点
        while (true) {
            if(temp.next == null) {
                //说明已到链表的尾部
                break;
            }
            if(temp.next.no == no) {
                //说明已经找到要删除的节点了
                flag = true;
                break;
            }
            //temp后移
            temp = temp.next;
        }
        //判断是否找到要删除的节点
        if(flag) {
            //已找到，做修改的操作
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的\n节点不存在！", no);
        }
    }

}


//定义一个HeroNode，每个heroNode对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点

    //构造器
    public HeroNode2(int no, String name, String nickname) {
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
