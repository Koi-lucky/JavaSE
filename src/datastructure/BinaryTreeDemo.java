package datastructure;

public class BinaryTreeDemo {

    public static void main(String[] args) {

        //先创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点信息
        ListNodeTree root = new ListNodeTree( 1, "李明");
        ListNodeTree node2 = new ListNodeTree( 2, "张三");
        ListNodeTree node3 = new ListNodeTree( 3, "李四");
        ListNodeTree node4 = new ListNodeTree( 4, "王五");
        ListNodeTree node5 = new ListNodeTree( 5, "张麻子");
        ListNodeTree node6 = new ListNodeTree( 6, "李子健");
        ListNodeTree node7 = new ListNodeTree( 7, "李晓");
        ListNodeTree node8 = new ListNodeTree( 8, "李白");

        //此处我们手动创建该二叉树（从简单的开始）
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        //将数与其节点联系起来
        binaryTree.root = root;


        //1.测试一下遍历的方法
        //前序遍历
        System.out.println("前序遍历输出：");// 1, 2, 4, 8, 5, 3, 6, 7
        binaryTree.preOrder();
        // 中序遍历
        System.out.println("中序遍历输出：");// 4, 8, 2, 5, 1, 6, 3, 7
        binaryTree.infixOrder();
        // 后序遍历
        System.out.println("后序遍历输出：");// 8, 4, 5, 2, 6, 7, 3, 1
        binaryTree.postOrder();

        //2.测试一下查找的方法
        //前序遍历查找——>5次
        System.out.println("前序遍历查找");
        int no = 5;
        ListNodeTree resNode1 = binaryTree.preOrderSearch(no);
        if(resNode1 != null) {
            System.out.printf("找到了，该节点的信息为: no = %d , name = %s \n", resNode1.no, resNode1.name);
        } else {
            System.out.printf("没有找到节点no = %d的信息\n" , resNode1.no);
        }
        // 中序遍历查找——>4次
        System.out.println("中序遍历查找");
        ListNodeTree resNode2 = binaryTree.infixOrderSearch(no);
        if(resNode2 != null) {
            System.out.printf("找到了，该节点的信息为: no = %d , name = %s \n", resNode2.no, resNode2.name);
        } else {
            System.out.printf("没有找到节点no = %d的信息\n" , resNode2.no);
        }
        // 后序遍历查找——>3次
        System.out.println("后序遍历查找");
        ListNodeTree resNode3 = binaryTree.postOrderSearch(no);
        if(resNode3 != null) {
            System.out.printf("找到了，该节点的信息为: no = %d , name = %s \n", resNode3.no, resNode3.name);
        } else {
            System.out.printf("没有找到节点no = %d的信息\n" , resNode3.no);
        }
        //3.测试一下删除的方法
        System.out.println("删除前——>前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(no);
        System.out.println("删除后——>前序遍历");
        binaryTree.preOrder();

    }
}


//定义二叉树
class BinaryTree {
    public ListNodeTree root;//根节点

    //1.遍历的方法
    //前序遍历
    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历！！！");
        }
    }
    // 中序遍历
    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历！！！");
        }
    }
    // 后序遍历
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历！！！");
        }
    }

    //2.查找的方法
    //前序遍历查找
    public ListNodeTree preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }
    //中序遍历查找
    public ListNodeTree infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }
    //后序遍历查找
    public ListNodeTree postOrderSearch(int no) {
        if(root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }
    //3.删除的方法
    public void delNode(int no) {
        if(root != null) {
            //如果只有一个根节点，然后判断根节点是不是要删除的节点
            if(root.no == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树！！无法删除！！！");
        }
    }
}





//先创建二叉树结点
class ListNodeTree {
    public int no;
    public String name;
    public ListNodeTree left;//左子结点，默认值为空
    public ListNodeTree right;//右子节点，默认值为空

    public ListNodeTree(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ListNodeTree{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

    //1.遍历方法的编写——>前序、中序和后序
    // 前序遍历方法
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if(this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null) {
            this.right.preOrder();
        }
    }
    // 中序遍历方法
    public void infixOrder() {
        //递归向左子树前序遍历
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);//输出父节点
        //递归向右子树前序遍历
        if(this.right != null) {
            this.right.infixOrder();
        }
    }
    // 后序遍历方法
    public void postOrder() {
        //递归向左子树前序遍历
        if(this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);//输出父节点
    }

    //2.查找的方法
    //前序遍历查找

    /**
     *
     * @param no 查找编号为no的结点
     * @return 如果找到就返回该节点，找不到就返回空
     */
    public ListNodeTree preOrderSearch(int no) {
        System.out.println("进入前序遍历");//此条语句只适用于判断三种遍历方式的查找次数，无其他实际意义
        //比较当前节点是不是要查找的节点
        if(this.no == no) {
            return this;
        }
        //判断当前节点的左子结点是否为空，如果不空则递归前序查找
        //如果左递归前序查找，找到了，则返回
        ListNodeTree resNode = null;
        if(this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null) {
            //说明在左子树找到了
            return resNode;
        }
        //左子树没有，于是向该节点的右子树递归前序查找
        if(this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        //不管找没找到都返回
        return resNode;
    }
    //中序遍历查找
    public ListNodeTree infixOrderSearch(int no) {
        //判断当前节点的左子结点是否为空，如果不空则递归中序查找
        //如果左递归中查找，找到了，则返回
        ListNodeTree resNode = null;
        if(this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null) {
            //说明在左子树找到了
            return resNode;
        }
        System.out.println("进入中序遍历");//此条语句只适用于判断三种遍历方式的查找次数，无其他实际意义
        //比较当前节点是不是要查找的节点
        if(this.no == no) {
            return this;
        }
        //左子树没有，该节点也不是，于是向该节点的右子树递归中序查找
        if(this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        //不管找没找到都返回
        return resNode;
    }
    //后序遍历查找
    public ListNodeTree postOrderSearch(int no) {
        //判断当前节点的左子结点是否为空，如果不空则递归后序查找
        //如果左递归后序查找，找到了，则返回
        ListNodeTree resNode = null;
        if(this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null) {
            //说明在左子树找到了
            return resNode;
        }
        //左子树没有，于是向该节点的右子树递归后序查找
        if(this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null) {
            //说明在右子树找到了
            return resNode;
        }
        System.out.println("进入后序遍历");//此条语句只适用于判断三种遍历方式的查找次数，无其他实际意义
        //最后比较当前节点是不是要查找的节点
        if(this.no == no) {
            return this;
        }
        return resNode;
    }
    //3.删除的方法
    //如果删除的结点是节点是叶子节点，直接删除
    //如果删除的节点是非叶子节点，则需要删除该结点及所包含的子树
    public void delNode(int no) {
        //因为我们的二叉树是单向的，所以我们应该判断的是当前节点的子节点是不是要删除的节点，而不是判断当前这个节点要不要删除
        //如果当前节点的左子结点不为空，并且左子结点就是要删除的节点，将其置空，然后结束递归
        //如果当前节点的右子节点不为空，并且右子结点就是要删除的节点，将其置空，然后结束递归
        //如果左右子结点都不是要删除的节点，那么就需要向左子树进行递归删除；
        //如果左子树也没有，那就向右子树进行递归删除
        if(this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if(this.left != null) {
            this.left.delNode(no);
        }
        if(this.right != null) {
            this.right.delNode(no);
        }
    }
}