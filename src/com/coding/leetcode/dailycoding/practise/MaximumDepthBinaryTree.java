package com.coding.leetcode.dailycoding.practise;/*
  @created 6/1/20
  @Author  - Meeravali Shaik
 */


public class MaximumDepthBinaryTree {

    public int maxDepthHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthHelper(node.left), maxDepthHelper(node.right));
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}


/**

 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 Note: A leaf is a node with no children.

 Example:

 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 return its depth = 3.
 */