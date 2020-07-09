package com.coding.leetcode.challenge.june.week4;/*
  @created 6/23/20
  @Author ** - Meeravali Shaik
 */



public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return countNodeHelper(root);
    }

    private int countNodeHelper(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+countNodeHelper(node.left)+countNodeHelper(node.right);
    }

}

class TreeNode {
    int vsl;
    TreeNode left;
    TreeNode right;

    public TreeNode(int vsl) {
        this.vsl = vsl;
    }
}


/**
 Given a complete binary tree, count the number of nodes.

 Note:

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 Example:

 Input:
 1
 / \
 2   3
 / \  /
 4  5 6

 Output: 6
 */