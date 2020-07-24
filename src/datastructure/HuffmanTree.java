package datastructure;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = { 13, 7, 8, 3, 29, 6, 1};
        Node1 root = createHuffmanTree(arr);
        //测试一下
        preOrder(root);
    }

    //写一个前序遍历的方法
    public static void preOrder(Node1 root) {
        if(root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，无法遍历~~");
        }
    }


    //写一个创建哈夫曼树的方法
    public static Node1 createHuffmanTree(int[] arr) {
        //第一步为了操作方便
        //1.先遍历arr数组
        //2.将arr的每个元素构成一个Node
        //3.将Node放入到ArrayList中
        ArrayList<Node1> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node1(value));
        }
        //我们处理的过程是一个循环的过程
        while(nodes.size() > 1) {
            //将数组从小到大进行排序
            Collections.sort(nodes);

            System.out.println("nodes = " + nodes);

            //取出根节点权值最小的两颗二叉树
            //1）取出权值最小的结点（二叉树）
            Node1 leftNode = nodes.get(0);
            //2)取出权值第二小的结点（二叉树）
            Node1 rightNode = nodes.get(1);
            //3)构建一颗新的二叉树
            //这棵树的根节点为前两个结点之和
            Node1 parent = new Node1(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //4)从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5)将parent加入到nodes
            nodes.add(parent);
        }
        //循环结束后，列表中仅剩一个值，即为最终结果
        //返回哈夫曼树的root点
        return nodes.get(0);
    }
}


//先创建节点类
//每次创建子树的时候，仍然要让node对象持续排序Collections集合排序
//让node实现Comparable接口
class Node1 implements Comparable<Node1> {

    int value;//权值
    Node1 left;//指向该节点的左子结点
    Node1 right;//指向该结点的右子节点

    public Node1(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    @Override
    public int compareTo(Node1 o) {
        //将数从大到小排序
        return this.value - o.value;
    }

    //写一个前序遍历的方法用于测试生成的哈夫曼树
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
}