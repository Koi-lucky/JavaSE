package datastructure;

public class JosepfuCircle {

    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);//添加5个孩子结点
        circleSingleLinkedList.show();

        circleSingleLinkedList.countBoy(1, 3, 5);
    }
}


//创建一个环形单向链表
class CircleSingleLinkedList {
    //先创建一个first结点，当前没有编号
    //first相当于实际的头结点
    private Boy first = null;

    //添加小孩节点，构成一个环形的链表
    public void add(int val) {
        //先对数据进行校验
        if(val < 1) {
            System.out.println("输入的数值不正确！！！");
            return;
        }

        //设置辅助指针，帮助构建环形链表
        Boy temp = null;
        //利用for循环构建链表
        for (int i = 1; i <= val; i++) {
            //根据所输入的编号创建对应的小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i == 1) {
                //first一直就是在指向第一个孩子，不会动，相当于实际的头结点
                first = boy;
                first.next = first;//构成了环
                temp = first;//让temp指针指向第一个小孩
            } else {
                temp.next = boy;//temp指针的next域指向新加的孩子
                boy.next = first;//新加的孩子的next域指向头，这样才形成了环
                temp = boy;//temp指针后移
            }
        }
    }


    //遍历当前的环形链表
    public void show() {
        //先判空
        if(first == null) {
            System.out.println("链表为空！！");
            return;
        }
        //因为头结点不能动，所以通过辅助指针来遍历
        Boy temp = first;
        while(true) {
            System.out.printf("小孩的编号为：%d\n", temp.val);
            if(temp.next == first) {
                break;
            }
            temp = temp.next;
        }
    }



    //根据用户的输入，计算出小孩的出圈顺序

    /**
     *
     * @param startNo 表示从第几个小孩开始数
     * @param countNum 表示数到第几个数就出圈
     * @param nums 表示最开始有多少个小孩参与游戏
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if(first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入的数据不合理！！");
            return;
        }
        //创建辅助指针帮助小孩出圈
        Boy temp = first;
        while(true) {
            if(temp.next == first) {
                break;
            }
            temp = temp.next;
        }
        //小孩报数前先让first和temp移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            temp = temp.next;
        }
        //当小孩报数时，让first和temp同时移动m-1次，然后出圈
        //循环操作，直至只剩一个结点为止
        while(true) {
            //只剩一个节点
            if(temp == first) {
                break;
            }
            //让first和temp同时移动countNum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.next;
                temp = temp.next;
            }
            //这时first指向的节点就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.val);
            //这是将first指向的小孩节点出圈
            first = first.next;
            temp.next = first;
        }
        System.out.printf("最后留在圈中的小孩编号为%d\n",first.val);
    }
}


//创建链表节点信息
class Boy {
    public int val;//节点编号
    public Boy next;//指向下一个节点

    public Boy(int val) {
        this.val = val;
    }
}