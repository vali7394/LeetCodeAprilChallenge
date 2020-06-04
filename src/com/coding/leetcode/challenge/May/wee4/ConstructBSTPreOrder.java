package com.coding.leetcode.challenge.May.wee4;/*
  @created 5/24/20
  @Author  - Meeravali Shaik
 */


public class ConstructBSTPreOrder {

    TreeNode root;

    public void addValue(int val){
        root = insertIntoBst(root,val);
    }

    public TreeNode insertIntoBst(TreeNode node , int val){
        if(node==null){
            return new TreeNode(val);
        }
        if(node.val < val){
            node.right = insertIntoBst(node.right,val);
        } else {
            node.left = insertIntoBst(node.left,val);
        }
        return node;
    }


    public void inorder(TreeNode node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    public void preOrder(TreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(TreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);

    }

    public TreeNode bstFromPreorder(int[] pre) {
        TreeNode root = null;
        for(var val : pre){
            fromBST(root,val);
        }
        return root;
    }

    public TreeNode fromBST(TreeNode node , int val){
        if(node == null){
            return new TreeNode(val);
        }
        if(node.val < val){
            node.right = fromBST(node.right,val);
        } else {
            node.left = fromBST(node.left,val);
        }

        return node;
    }

    public static void main(String[] args) {
        ConstructBSTPreOrder bstPreOrder = new ConstructBSTPreOrder();
        bstPreOrder.addValue(10);
        bstPreOrder.addValue(7);
        bstPreOrder.addValue(15);
        bstPreOrder.addValue(13);
        bstPreOrder.addValue(17);
        bstPreOrder.addValue(5);
        bstPreOrder.addValue(8);
        bstPreOrder.postOrder(bstPreOrder.root);
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**

 Return the root node of a binary search tree that matches the given preorder traversal.

 (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

 Example 1:

 Input: [8,5,1,7,10,12]
 Output: [8,5,10,1,7,null,12]



 */