package com.coding.leetcode.challenge.june;/*
  @created 6/1/20
  @Author  - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);
    }

    public TreeNode invertTreeHelper(TreeNode node){
        if(node==null){
            return null;
        }
        node.left = invertTreeHelper(node.left);
        node.right = invertTreeHelper(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }

    public TreeNode invertTreeRecursive(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left!=null) nodeQueue.offer(node.left);
            if(node.right!=null) nodeQueue.offer(node.right);
        }
        return root;
    }

}


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

}

/**
 Input:

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 Output:

 4
 /   \
 7     2
 / \   / \
 9   6 3   1

 */