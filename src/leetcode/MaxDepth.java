package leetcode;

public class MaxDepth {

    public static void main(String[] args) {

        //测试
        //创建一个树
        Tree1 tree = new Tree1();
        //添加节点
        TreeNode1 root = new TreeNode1(3);
        TreeNode1 no1 = new TreeNode1(9);
        TreeNode1 no2 = new TreeNode1(20);
        TreeNode1 no5 = new TreeNode1(15);
        TreeNode1 no6 = new TreeNode1(7);
        //手动创建二叉树
        root.left = no1;
        root.right = no2;
        no2.left = no5;
        no2.right = no6;
        //将节点与树联系起来
        tree.root = root;
        //测试树高
        System.out.println("树的高度为： " + tree.maxDepth(tree.getRoot()));
    }
}


//创建树
class Tree1 {

    TreeNode1 root = null;

    public TreeNode1 getRoot() {
        return root;
    }
    //求树高
    public int maxDepth(TreeNode1 root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

//创建树节点
class TreeNode1 {
    int val;
    public TreeNode1 left;
    public TreeNode1 right;

    public TreeNode1(int val) {
        this.val = val;
    }
}