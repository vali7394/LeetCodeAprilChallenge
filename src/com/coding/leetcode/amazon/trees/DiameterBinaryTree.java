package com.coding.leetcode.amazon.trees;/*
  @created 7/5/20
  @Author ** - Meeravali Shaik
 */

public class DiameterBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] dia = diameterOfBinaryTreeHelper(root);
        return Math.max(dia[0],dia[1]);
    }


    private int[] diameterOfBinaryTreeHelper(TreeNode node){
        if(node==null){
            return new int[]{0,0};
        }
        int[] leftDia = diameterOfBinaryTreeHelper(node.left);
        int[] rightDia = diameterOfBinaryTreeHelper(node.right);
        int internalPath = Math
            .max(1 + leftDia[0] + rightDia[0], Math.max(leftDia[1], rightDia[1]));
        return new int[]{1+Math.max(leftDia[0],rightDia[0]),internalPath};
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
    }
}