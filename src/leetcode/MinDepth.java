package leetcode;

public class MinDepth {

    public static void main(String[] args) {
        //测试
        //创建一个树
        Tree2 tree = new Tree2();
        //添加节点
        TreeNode2 root = new TreeNode2(3);
        TreeNode2 no1 = new TreeNode2(9);
        TreeNode2 no2 = new TreeNode2(20);
        TreeNode2 no5 = new TreeNode2(15);
        TreeNode2 no6 = new TreeNode2(7);
        //手动创建二叉树
        root.left = no1;
        root.right = no2;
        no2.left = no5;
        no2.right = no6;
        //将节点与树联系起来
        tree.root = root;
        //测试树最小深度
        System.out.println("树的最小深度为： " + tree.minDepth(tree.getRoot()));
    }
}

//创建树
class Tree2 {

    TreeNode2 root = null;

    public TreeNode2 getRoot() {
        return root;
    }
    //求树高
    public int minDepth(TreeNode2 root) {
        if(root == null) {
            return 0;
        }
        //相比之下除了递归求解左右子树的深度外，还需要考虑左右子树是否为空这个情况
        //如果有为空的情况，则直接返回两者深度之和再加上根节点的 1
        //若都不为空，则求两者最小深度再加上根节点即可。
        if(root.left == null) {
            return minDepth(root.right) + 1;
        }
        if(root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

//创建树节点
class TreeNode2 {
    int val;
    public TreeNode2 left;
    public TreeNode2 right;

    public TreeNode2(int val) {
        this.val = val;
    }
}