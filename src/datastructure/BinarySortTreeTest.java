package datastructure;

public class BinarySortTreeTest {

    public static void main(String[] args) {

        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new BinaryTreeNode(arr[i]));
        }
        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树！！");
        binarySortTree.infixOrder();//1,2,3,5,7,9,10,12

        //测试一下删除节点的方法
        //删除叶子节点
        binarySortTree.delNode(2);
        System.out.println("删除节点后的树为：");
        binarySortTree.infixOrder();
        //删除只有一棵子树的节点
        //binarySortTree.delNode(1);
        //System.out.println("删除节点后的树为：");
        //binarySortTree.infixOrder();
        //删除有两棵子树的节点
        //binarySortTree.delNode(10);
        //System.out.println("删除节点后的树为：");
        //binarySortTree.infixOrder();

    }
}


//创建二叉排序树
class BinarySortTree {

    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    //添加节点的方法
    public void add(BinaryTreeNode node) {
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

    // 查找要删除的节点
    public BinaryTreeNode search(int val) {
        if(root == null) {
            return null;
        } else {
            return root.search(val);
        }
    }
    // 查找父节点
    public BinaryTreeNode searchParent(int val) {
        if(root == null) {
            return null;
        } else {
            return root.searchParent(val);
        }
    }
    // 找到该子树的最小节点、并删除的方法

    /**
     * 1.返回的是以node为根节点的二叉排序树的最小节点的值
     * 2.删除node为根节点的二叉排序树的最小节点
     * @param node 传入的节点（当作二叉树的根节点）
     * @return 返回的是以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(BinaryTreeNode node) {
        BinaryTreeNode target = node;//临时变量存储
        //循环的查找左子结点，就会找到最小的值
        while(target.left != null) {
            target = target.left;
        }
        //循环结束后，此时的target就指向了最小的节点
        //删除最小的节点
        delNode(target.val);
        return target.val;
    }
    // 删除节点的方法
    public void delNode(int val) {
        if(root == null) {
            return;
        } else {
            //1.需要先找到要删除的节点
            BinaryTreeNode targetNode = search(val);
            //如果没找到要删除的节点
            if(targetNode == null) {
                return;
            }
            //如果我们发现当前的这颗二叉排序树只有一个节点
            if(root.left == null && root.right == null) {
                root = null;//将根节点置空
                return;
            }
            //2.找到目标节点的父节点
            BinaryTreeNode parent = searchParent(val);
            //【一】如果要删除的节点是叶子节点
            if(targetNode.left == null && targetNode.right == null) {
                    //判断目标节点是父节点的左子结点，还是右子节点
                    if (parent.left != null && parent.left.val == val) {
                        parent.left = null;
                    } else if (parent.right != null && parent.right.val == val) {
                        parent.right = null;
                    }
            } else if(targetNode.left != null && targetNode.right != null) {//【二】删除有两棵子树的结点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.val = minVal;
            } else {//【三】删除只有一棵子树的结点
                //如果要删除的节点有左子结点
                if(targetNode.left != null) {
                    if(parent != null) {
                        //如果目标节点是父节点parent的左子结点
                        if(parent.left.val == val) {
                            parent.left = targetNode.left;
                        } else { //如果目标节点是父节点parent的右子结点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;//如果根节点为空，直接让root指向她的子节点
                    }
                } else {//如果要删除的节点有右子结点
                    if(parent != null) {
                        //如果目标节点是父节点parent的左子结点
                        if(parent.left.val == val) {
                            parent.left = targetNode.right;
                        } else { //如果目标节点是父节点parent的右子结点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;//如果根节点为空，直接让root指向她的子节点
                    }
                }
            }
        }
    }

}


//创建树的结点
class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" + "val=" + val + '}';
    }

    //添加节点的方法——递归添加
    //【注意】要满足二叉排序树的要求
    public void add(BinaryTreeNode node) {
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

    //查找要删除的节点
    public BinaryTreeNode search(int val) {
        if(val == this.val) {
            //找到了，就是该节点
            return this;
        } else if(val < this.val) {
            //如果查找的节点小于当前节点，向左子树递归查询
            //如果左子结点为空
            if(this.left == null) {
                return null;
            }
            return this.left.search(val);
        } else {
            //如果查找的值不小于当前的值（大于等于），则向右子树递归查找
            if(this.right == null) {
                return null;
            }
            return this.right.search(val);
        }
    }

    //查找要删除节点的父节点
    public BinaryTreeNode searchParent(int val) {
        //如果当前节点就是要删除的节点的父节点，就返回
        if((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值，并且当前节点的值不为空，向左子树递归查找
            if(this.left != null && val < this.val) {
                return this.left.searchParent(val);//向左子树递归查找
            } else if(this.right != null && val >= this.val) {
                return this.right.searchParent(val);//向右子树递归查找
            } else {
                return null;//没有找到父节点
            }
        }
    }

}