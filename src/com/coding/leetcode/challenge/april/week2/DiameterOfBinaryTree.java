package com.coding.leetcode.challenge.april.week2;/*
  @created 4/11/20
  @Author Meeravali Shaik
 */


/**
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 *
 *
 *
 */

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        System.out.println(diameter.diameterOfBinaryTree(treeNode));
    }


    int answer;
    public int diameterOfBinaryTree(TreeNode root) {
        answer = 1;
        maxDiameter(root);
        return answer-1;
    }


    public int maxDiameter(TreeNode node){
        if(node ==null) return 0;
        int leftLength = maxDiameter(node.left);
        int rightLength = maxDiameter(node.right);
        answer = Math.max(answer,leftLength+rightLength+1);
        return Math.max(rightLength,leftLength)+1;
    }
}

class TreeNode{

     int value;
     TreeNode left;
     TreeNode right;

     TreeNode(int value){
         this.value = value;
     }

    }

