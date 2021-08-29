package com.lyb.tree;

/**
 * Created with IntelliJ IDEA.
 * User: pz
 * Date: 2021/8/29
 * Time: 14:59
 * Description: No Description
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
    }
}

//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历`
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);

        if (index *2 +1 < arr.length){
            preOrder(index *2 +1);
        }
        if (index *2 +2 < arr.length){
            preOrder(index *2 +2);
        }
    }
}
