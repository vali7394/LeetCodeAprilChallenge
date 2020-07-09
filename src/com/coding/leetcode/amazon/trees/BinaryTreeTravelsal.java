package com.coding.leetcode.amazon.trees;/*
  @created 7/5/20
  @Author ** - Meeravali Shaik
 */

 class BinaryTreeTraversal<Integer> {


    public boolean isHeightBalanced(BinaryTree<Integer> root){
        if(root==null){
            return true;
        }
        return balanceHelper(root).balanced;
    }

    private BinaryTreeUtil balanceHelper(BinaryTree<Integer> root){
        if(root==null){
            return new BinaryTreeUtil(-1,Boolean.TRUE);
        }

        BinaryTreeUtil left = balanceHelper(root.left);
        if(!left.balanced){
            return left;
        }

        BinaryTreeUtil right = balanceHelper(root.right);
        if(!right.balanced){
            return right;
        }

        boolean balanced = Math.abs(left.height-right.height)<=1;
        return new BinaryTreeUtil(Math.max(left.height,right.height)+1,balanced);
    }



    public  void preOrderTraversal(BinaryTree<Integer> root){
        if(root==null){
            return;
        }
    }

    private void preOrderTraversalHelper(BinaryTree<Integer> node){
        if(node==null){
            return;
        }
        System.out.println(node.val);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

    }

    private void inOrderTraversalHelper(BinaryTree<Integer> node){
        if(node==null){
            return;
        }
        preOrderTraversal(node.left);
        System.out.println(node.val);
        preOrderTraversal(node.right);

    }

    private void postOrderTraversalHelper(BinaryTree<Integer> node){
        if(node==null){
            return;
        }
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        System.out.println(node.val);

    }

    class BinaryTreeUtil{
        int height;
        Boolean balanced;

        public BinaryTreeUtil(int height, Boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

}


class BinaryTree<T> {
    T val;
    BinaryTree<T> left;
    BinaryTree<T> right;

    public BinaryTree(T val, BinaryTree<T> left, BinaryTree<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}