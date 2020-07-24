package datastructure;

public class TextSingleLinkedList {

    public static void main(String[] args) {
        //测试单链表

        //先创建节点
        ListNode1 t1 = new ListNode1(1,"lxx");
        ListNode1 t2 = new ListNode1(2,"lxy");
        ListNode1 t3 = new ListNode1(3,"lyx");
        ListNode1 t4 = new ListNode1(4,"lhh");
        ListNode1 t5 = new ListNode1(5,"lwx");
        ListNode1 t6 = new ListNode1(6,"lzw");

        //创建双向链表
        SingleLinkedList1 singleLinkedList = new SingleLinkedList1();
        singleLinkedList.add(t1);
        singleLinkedList.add(t2);
        singleLinkedList.add(t3);
        singleLinkedList.add(t4);
        singleLinkedList.add(t5);
        singleLinkedList.add(t6);

        singleLinkedList.list();

        //修改
        ListNode1 newList = new ListNode1(2,"lrf~~~~");
        singleLinkedList.update(newList);
        System.out.println("修改后的链表显示：");
        singleLinkedList.list();

        //删除
        singleLinkedList.delete(4);
        System.out.println("删除后的链表显示：");
        singleLinkedList.list();
    }
}


class SingleLinkedList1 {
    //初始化一个头节点，头结点不能动
    //头结点为虚拟的节点
    private ListNode1 head = new ListNode1(0, "");
    //返回头节点
    public ListNode1 getHead() {
        return head;
    }

    //遍历链表
    public void list() {
        //判空
        if(head.next == null) {
            System.out.println("该链表为空！！");
            return;
        }
        //设置一个指针进行操作
        ListNode1 temp = head.next;
        while(true) {
            if(temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //指针后移
            temp = temp.next;
        }
    }


    //尾插法向链表添加一个节点
    public void add(ListNode1 listNode) {
        //设置指针
        ListNode1 temp = head;
        //遍历链表找最后一个结点
        while(true) {
            //已到链表的最后一个结点
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //退出循环时，已找到最后一个结点
        //进行添加操作
        temp.next = listNode;
    }


    //按顺序添加节点
    public void addByOrder(ListNode1 listNode) {
        ListNode1 temp = head;
        boolean flag = false ;
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.val > listNode.val) {
                //位置找到了，就在temp的后面插入
                break;
            } else if(temp.next.val == listNode.val) {
                //链表中已存在该节点
                flag = true;
            }
            temp = temp.next;
        }
        if(flag) {
            listNode.next = temp.next;
            temp.next = listNode;
        }
    }


    //修改一个节点的内容
    public void update(ListNode1 listNode) {
        //判空
        if(head.next == null) {
            System.out.println("链表为空，无法修改！！！");
            return;
        }
        //设置指针
        ListNode1 temp = head.next;
        boolean flag = false;//设置标志位
        while(true) {
            if(temp == null) {
                break;
            }
            if(listNode.val == temp.val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.name = listNode.name;
        } else {
            System.out.printf("没找到编号为%d的节点，无法删除！\n",listNode.val);
        }
    }


    //从链表中删除一个节点
    public void delete(int val) {
        //判空
        if(head.next == null) {
            System.out.println("链表为空，无法删除！");
            return;
        }
        //设置指针
        ListNode1 temp = head;
        Boolean flag = false;
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.val == val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没找到编号为%d的结点，无法删除！\n",val);
        }
    }


}

//定义ListNode,每个ListNode对象就是一个节点
class ListNode1 {
    public int val;//节点的序号
    public String name;//节点的名称
    public ListNode1 next;//指向下一个节点


    public ListNode1(int val, String name) {
        this.val = val;
        this.name = name;
    }

    @Override
    public String toString() {
        return "结点：" + val + "，其名称为：" + name;
    }
}
