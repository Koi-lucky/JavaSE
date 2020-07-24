package leetcode;

import java.util.ArrayList;

public class NTree_1 {

    public static void main(String[] args) throws Exception{

        //测试n叉树的前序遍历和后序遍历
        //创建一个N叉树
        NTree1 tree = new NTree1();
        //创建节点信息
        NTreeNode1 root = new NTreeNode1(1);
        NTreeNode1 node1 = new NTreeNode1(3);
        NTreeNode1 node2 = new NTreeNode1(2);
        NTreeNode1 node3= new NTreeNode1(4);
        NTreeNode1 node4 = new NTreeNode1(5);
        NTreeNode1 node5 = new NTreeNode1(6);
        //手动创建n叉树
        try {
            root.children.add(node1);
            root.children.add(node2);
            root.children.add(node3);
            node1.children.add(node4);
            node1.children.add(node5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //将树与其子节点连接起来
        tree.root = root;
        //测试前序遍历
        System.out.println("前序遍历");
        tree.preOrder(root);
        // 测试后序遍历
        System.out.println("后序遍历");
        tree.postOrder(root);
        //测试N叉树深度
        System.out.println("N叉树的深度为：" + tree.maxDepth(root));
    }
}

//创建N叉树
class NTree1 {
    public NTreeNode1 root;//根节点

    ArrayList<Integer> res = new ArrayList<>();//用于存放遍历后的结果

    //前序遍历——递归实现
    public ArrayList<Integer> preOrder(NTreeNode1 root) {
        if(root != null) {
            res.add(root.val);//将当前节点加入列表
            for (NTreeNode1 child : root.children) {
                //遍历孩子节点
                preOrder(child);
            }
        }
        return res;
    }
    // 后序遍历——递归实现
    public ArrayList<Integer> postOrder(NTreeNode1 root) {
        if(root != null) {
            for (NTreeNode1 child : root.children) {
                //遍历孩子节点
                postOrder(child);
            }
            res.add(root.val);//将当前节点加入列表
        }
        return res;
    }
    //求N叉树深度
    public int maxDepth(NTreeNode1 root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        for(NTreeNode1 child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return depth + 1;
    }
}

//创建节点信息
class NTreeNode1 {
    int val;
    ArrayList<NTreeNode1> children;//孩子节点

    public NTreeNode1() {
    }

    public NTreeNode1(int val) {
        this.val = val;
    }

    public NTreeNode1(int val, ArrayList<NTreeNode1> children) {
        this.val = val;
        this.children = children;
    }
}