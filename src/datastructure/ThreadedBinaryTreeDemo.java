package datastructure;

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        //测试线索二叉树的功能
        ThreadedNode root = new ThreadedNode(1, "李明");
        ThreadedNode node2 = new ThreadedNode(3, "李白");
        ThreadedNode node3 = new ThreadedNode(6, "黄山");
        ThreadedNode node4 = new ThreadedNode(8, "张三");
        ThreadedNode node5 = new ThreadedNode(10, "李四");
        ThreadedNode node6 = new ThreadedNode(14, "王麻子");

        //创建二叉树，目前先手动创建
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.root = root;


        //测试：以10号节点为例
        // 中序线索化遍历测试
        threadedBinaryTree.threadedTreeNode1(root);
        System.out.println("使用中序线索化的方式遍历中序线索化二叉树~~~");
        System.out.println("10号节点的前驱结点是; " + node5.left);
        System.out.println("10号节点的后继结点是; " + node5.right);
        //当线索化之后，不能使用之前的遍历方法，得用新的方法
        threadedBinaryTree.threadedList1();// 8, 3, 10, 1, 14, 6

    }
}

//创建线索化二叉树：前序、中序及后序
class ThreadedBinaryTree {
    public ThreadedNode root;

    //为实现线索化二叉树，需要创建指向当前结点的前趋结点的指针pre
    //在递归进行线索化时，pre总是保留该结点的前一个节点
    public ThreadedNode pre = null;

    //1.中序线索化二叉树建立+遍历
    //编写对二叉树进行中序线索化的方法
    //node就是当前要线索化的结点
    public void threadedTreeNode1 (ThreadedNode node) {
        //如果node等于空，不能线索化
        if(node == null) {
            return;
        }
        //线索化左子树
        threadedTreeNode1(node.left);

        //线索化当前节点
        //1.处理当前节点的前驱结点
        if(node.left == null) {
            //让当前结点的左指针指向前驱节点
            node.left = pre;
            //修改当前节点的左指针类型，指向前驱节点
            node.leftType = 1;
        }
        //2.处理当前节点的后继结点
        if(pre != null && pre.right  == null) {
            //让前驱节点的右指针指向当前结点
            pre.right = node;
            //修改前驱结点的右指针类型
            pre.rightType = 1;
        }
        //每处理一个节点，让当前节点是下一个结点的前驱结点
        pre = node;

        //线索化右子树
        threadedTreeNode1(node.right);
    }


    //遍历中序线索化二叉树的方法
    public void threadedList1() {
        //定义一个变量，存储当前遍历的结点，从root开始
        ThreadedNode node = root;
        while(node != null) {
            //循环找到leftType=1的结点，第一个找到的就是8结点
            //后面随着遍历而变化，
            // 因为当leftType=1时，说明该节点是按照线索化处理后的有效节点
            while (node.leftType == 0) {
                node = node.left;
            }
            //打印当前这个结点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继结点，就一直输出
            while (node.rightType == 1) {
                //获取到当前节点的后继结点
                node = node.right;
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.right;
        }
    }


    //2.前序线索化二叉树建立+遍历



    //3.后序线索化二叉树建立+遍历

}

//创建线索化二叉树的节点信息
class ThreadedNode {
    public int no;
    public String name;
    public ThreadedNode left;//左子结点，默认值为空
    public ThreadedNode right;//右子节点，默认值为空

    public int leftType;//如果leftType=0，则说明他指向的是左子树，如果leftType=1则说明他指向的是前驱结点
    public int rightType;//如果rightType=0，则说明他指向的是右子树，如果rightType=1则说明他指向的是后继结点

    public ThreadedNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThreadedNode{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

}