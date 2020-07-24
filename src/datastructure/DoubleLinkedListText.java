package datastructure;

public class DoubleLinkedListText {

    public static void main(String[] args) {
        //测试双向链表

        //先创建节点
        ListNode t1 = new ListNode(1,"lxx");
        ListNode t2 = new ListNode(2,"lxy");
        ListNode t3 = new ListNode(3,"lyx");
        ListNode t4 = new ListNode(4,"lhh");
        ListNode t5 = new ListNode(5,"lwx");
        ListNode t6 = new ListNode(6,"lzw");

        //创建双向链表
        DoubleLinkedList doubleLinked = new DoubleLinkedList();
        doubleLinked.add(t1);
        doubleLinked.add(t2);
        doubleLinked.add(t3);
        doubleLinked.add(t4);
        doubleLinked.add(t5);
        doubleLinked.add(t6);

        doubleLinked.list();

        //修改
        ListNode ttt = new ListNode(2,"lrf~~~~");
        doubleLinked.update(ttt);
        System.out.println("修改后的链表显示：");
        doubleLinked.list();

        //删除
        doubleLinked.delete(4);
        System.out.println("删除后的链表显示：");
        doubleLinked.list();
    }
}


//创建一个双向链表的类
class DoubleLinkedList {

    //初始化一个头节点，头结点不能动
    //头结点为虚拟的节点
    ListNode head = new ListNode(0, "");
    //返回头节点
    public ListNode getHead() {
        return head;
    }

    //遍历双向链表
    public void list() {
        //判空
        if(head.next == null) {
            System.out.println("该链表为空！！");
            return;
        }
        //设置一个指针进行操作
        ListNode temp = head.next;
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


    //尾插法向双向链表添加一个节点
    public void add(ListNode listNode) {
        //设置指针
        ListNode temp = head;
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
        listNode.pre = temp;
    }


    //修改一个节点的内容
    public void update(ListNode listNode) {
        //判空
        if(head.next == null) {
            System.out.println("链表为空，无法修改！！！");
            return;
        }
        //设置指针
        ListNode temp = head.next;
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


    //从双向链表中删除一个节点
    public void delete(int val) {
        //判空
        if(head.next == null) {
            System.out.println("链表为空，无法删除！");
            return;
        }
        //设置指针
        ListNode temp = head.next;
        Boolean flag = false;
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.val == val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.pre.next = temp.next;
            //如果是最后一个结点就不需要下面这句话
            // 如果最后一个结点执行底下这个操作会出现空指针异常
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("没找到编号为%d的结点，无法删除！\n",val);
        }
    }

}




//定义ListNode,每个ListNode对象就是一个节点
class ListNode {
    public int val;//节点的序号
    public String name;//节点的名称
    public ListNode next;//指向下一个节点
    public ListNode pre;//指向节点的前一个节点


    public ListNode(int val, String name) {
        this.val = val;
        this.name = name;
    }

    @Override
    public String toString() {
        return "结点：" + val + "，其名称为：" + name;
    }
}
