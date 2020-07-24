package leetcode;

import java.util.*;

public class LevelOrder2 {

    public static void main(String[] args) {

        //测试
        //创建一个树
        Tree4 tree = new Tree4();
        //添加节点
        TreeNode4 root = new TreeNode4(3);
        TreeNode4 no1 = new TreeNode4(9);
        TreeNode4 no2 = new TreeNode4(20);
        TreeNode4 no5 = new TreeNode4(15);
        TreeNode4 no6 = new TreeNode4(7);
        //手动创建二叉树
        root.left = no1;
        root.right = no2;
        no2.left = no5;
        no2.right = no6;
        //将节点与树联系起来
        tree.root = root;
        //测试树的广度优先遍历
        System.out.println(Arrays.toString(tree.levelOrder(root).toArray()));
    }
}

//创建树
class Tree4 {

    TreeNode4 root = null;

    public TreeNode4 getRoot() {
        return root;
    }
    //树的广度优先遍历
    public List<List<Integer>> levelOrder(TreeNode4 root) {
        Queue<TreeNode4> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode4 node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

}


//创建树节点
class TreeNode4 {
    int val;
    public TreeNode4 left;
    public TreeNode4 right;

    public TreeNode4(int val) {
        this.val = val;
    }
}