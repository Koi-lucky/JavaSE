package datastructure;

public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        //测试
        int[] arr = { 1, 2, 3, 4, 5, 6, 7};
        //创建一个ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //前序遍历
        System.out.print("前序遍历输出为：");
        arrBinaryTree.preOrder(0);//1 2 4 5 3 6 7
        System.out.println();
        //中序遍历
        System.out.print("中序遍历输出为：");
        arrBinaryTree.infixOrder(0);//4 2 5 1 6 3 7
        System.out.println();
        //后序遍历
        System.out.print("后序遍历输出为：");
        arrBinaryTree.postOrder(0);//4 5 2 6 7 3 1
    }
}


//编写一个用数组存储二叉树，实现三种遍历
class ArrBinaryTree {
    private int[] arr;//存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //三种遍历方法的实现
    //前序遍历
    //index为数组下标
    public void preOrder(int index) {
        //如果数组为空或数组的长度为0
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历！");
            return;
        }
        //输出当前这个元素
        System.out.print(arr[index] + " ");
        //向左递归遍历
        if((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
    //中序遍历
    public void infixOrder(int index) {
        //如果数组为空或数组的长度为0
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的中序遍历！");
            return;
        }
        //向左递归遍历
        if((2 * index + 1) < arr.length) {
            infixOrder(2 * index + 1);
        }
        //输出当前这个节点
        System.out.print(arr[index] + " ");
        //向右递归遍历
        if((2 * index + 2) < arr.length) {
            infixOrder(2 * index + 2);
        }
    }
    // 后序遍历
    public void postOrder(int index) {
        //如果数组为空或数组的长度为0
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的后序遍历！");
            return;
        }
        //向左递归遍历
        if((2 * index + 1) < arr.length) {
           postOrder(2 * index + 1);
        }
        //向右递归遍历
        if((2 * index + 2) < arr.length) {
            postOrder(2 * index + 2);
        }
        //输出当前这个节点
        System.out.print(arr[index] + " ");
    }
}