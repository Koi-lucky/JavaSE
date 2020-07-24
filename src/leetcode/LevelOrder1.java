package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder1 {

    public static void main(String[] args) {

        //测试
        //创建一个树
        Tree3 tree = new Tree3();
        //添加节点
        TreeNode3 root = new TreeNode3(3);
        TreeNode3 no1 = new TreeNode3(9);
        TreeNode3 no2 = new TreeNode3(20);
        TreeNode3 no5 = new TreeNode3(15);
        TreeNode3 no6 = new TreeNode3(7);
        //手动创建二叉树
        root.left = no1;
        root.right = no2;
        no2.left = no5;
        no2.right = no6;
        //将节点与树联系起来
        tree.root = root;
        //测试树的广度优先遍历
        System.out.println(Arrays.toString(tree.levelOrder(root)));
    }
}

//创建树
class Tree3 {

    TreeNode3 root = null;

    public TreeNode3 getRoot() {
        return root;
    }
    //树的广度优先遍历
    public int[] levelOrder(TreeNode3 root) {
        if(root == null) return new int[0];
        Queue<TreeNode3> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode3 node = queue.poll();//poll()和remove()都将移除并且返回对头，但是在poll()在队列为空时返回null，而remove()会抛出NoSuchElementException异常。
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

}


//创建树节点
class TreeNode3 {
    int val;
    public TreeNode3 left;
    public TreeNode3 right;

    public TreeNode3(int val) {
        this.val = val;
    }
}