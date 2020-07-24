package datastructure;

public class AVLTreeDemo {

    public static void main(String[] args) {
        //int[] arr = { 4, 3, 6, 5, 7, 8};//测试左旋
        //int[] arr = { 10, 12, 8, 9, 7, 6};//测试右旋
        int[] arr = { 10, 11, 7, 6, 8, 9};//测试双旋

        //创建一个AVLTree的对象
        AVLTree avlTree = new AVLTree();
        //添加节点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new TreeNode(arr[i]));
        }
        //中序遍历
        System.out.println("中序遍历~~");
        avlTree.infixOrder();
        //测试
        System.out.println("平衡处理后的数据！！");
        System.out.println("树的高度为 ： " + avlTree.getRoot().height());//3
        System.out.println("树的左子树的高度为 ： " + avlTree.getRoot().leftHeight());//2
        System.out.println("树的右子树高度为 ： " + avlTree.getRoot().rightHeight());//2
        System.out.println("当前树的根结点为 ： " + avlTree.getRoot());//8
    }
}

//创建AVLtree
class AVLTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    //添加节点的方法
    public void add(TreeNode node) {
        if(root == null) {
            root = node;//如果node为空，则直接让root指向node
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if(root != null){
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历！");
        }
    }
}


// 创建树的结点
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode { " + "val=" + val + '}';
    }

    // 返回左子树的高度
    public int leftHeight() {
        if(left == null ){
            return 0;
        }
        return left.height();
    }
    // 返回右子树的高度
    public int rightHeight() {
        if(right == null ){
            return 0;
        }
        return right.height();
    }
    //返回以该节点为根节点的树的高度
    public int height() {
        return Math.max( (left == null) ? 0 : left.height(), (right == null) ? 0 : right.height()) + 1;
    }
    //左旋方法
    private void leftRotate() {
        //创建新的节点，以当前根节点的值创建
        TreeNode newNode = new TreeNode(val);
        //让 新的节点的左子树 指向 当前根节点的左子树
        newNode.left = left;
        //让 新的节点的右子树 指向 当前根节点的右子树的左子树
        newNode.right = right.left;
        //把当前根节点的值 替换成 当前节点的右子树的值
        val = right.val;
        //让 新的当前节点的右子树 指向 旧的当前节点的右子树的右子树
        right = right.right;
        //让 新的当前节点的左子树 指向 新设置的节点
        left = newNode;
    }
    // 右旋方法
    private void rightRotate() {
        TreeNode newNode = new TreeNode(val);
        newNode.right = right;
        newNode.left = left.right;
        val = left.val;
        left = left.left;
        right = newNode;
    }

    //添加节点的方法——递归添加
    //【注意】要满足二叉排序树的要求
    public void add(TreeNode node) {
        if(node == null) {
            return;
        }
        //判断传入的结点的值，和当前子树根节点的值的关系
        if(node.val < this.val) {
            //如果当前节点的左子结点为null
            if(this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else {//添加的节点的值大于当前节点的值
            //如果当前节点的右子结点为null
            if(this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }

        //当添加完一个节点后，如果：（右子树的高度 - 左子树的高度）> 1 ——> 左旋
        if(rightHeight() - leftHeight() > 1) {
            //判断是否需要双旋

            //如果他的右子树的高度 > 他的右子树的右子树的高度
            if(right != null && rightHeight() > right.rightHeight()) {
                //先对当前根节点的右子节点进行 —— 右旋
                right.rightRotate();
                //然后再对当前根节点进行 —— 左旋
                leftRotate();
            } else {
                //直接左旋
                leftRotate();
            }
            return;//这个条件满足后，执行完直接退出，不能再判断后面的操作
        }

        //当添加完一个节点后，如果：（左子树的高度 - 右子树的高度）> 1 ——> 右旋
        if(leftHeight() - rightHeight() > 1) {
            //判断是否需要双旋

            //如果他的左子树的右子树的高度 > 他的左子树的高度
            if(left != null && leftHeight() > left.leftHeight()) {
                //先对当前根节点的左子节点进行 —— 左旋
                left.leftRotate();
                //然后再对当前根节点进行 —— 右旋
                rightRotate();
            } else {
                //直接右旋
                rightRotate();
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }
}