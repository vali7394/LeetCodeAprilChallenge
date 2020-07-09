package com.coding.leetcode.amazon;/*
  @created 6/18/20
  @Author ** - Meeravali Shaik
 */

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        SubtreeOfAnotherTree subtree = new SubtreeOfAnotherTree();
        subtree.constructBst(3);
        subtree.constructBst(4);
        subtree.constructBst(5);
        subtree.constructBst(1);
        subtree.constructBst(2);
       // subtree.inOrderTraversal(subtree.root);
        SubtreeOfAnotherTree tree = new SubtreeOfAnotherTree();
        tree.constructBst(4);
        tree.constructBst(1);
        tree.constructBst(2);
        subtree.isSubtree(subtree.root,tree.root);
    }

    TreeNode root ;

    private void inOrderTraversal(TreeNode node){
        inOrderTraversalHelper(node);
    }

    private void inOrderTraversalHelper(TreeNode node){
        if(node==null){
            return;
        }
        inOrderTraversalHelper(node.left);
        System.out.println(node.val);
        inOrderTraversalHelper(node.right);

    }

    private void constructBst(int i){
        root = constructBstHelper(root,i);
    }

    private TreeNode constructBstHelper(TreeNode node , int i){
        if(node==null){
            return new TreeNode(i);
        }

        if(node.val < i){
            node.right = constructBstHelper(node.right,i);
        }else {
            node.left = constructBstHelper(node.left,i);
        }
        return node;
    }



    private TreeNode getSubTree(TreeNode node , int target){
        if(node==null){
            return null;
        }
        if(node.val==target){
            return node;
        }

        if(node.val<target){
           return getSubTree(node.right,target);
        }else {
           return getSubTree(node.left,target);
        }
    }

    private boolean compareSubTrees(TreeNode s, TreeNode t){
        if(s==null || t==null){
            return false;
        }
        if(s==null && t==null){
            return true;
        }

        if(s.val!=t.val){
            return false;
        }

        return compareSubTrees(s.left,t.left) && compareSubTrees(s.right,t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        return compareSubTrees(s.left,t) || compareSubTrees(s.right,t);
    }

    private  static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}




/**
 Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

 Example 1:
 Given tree s:

 3
 / \
 4   5
 / \
 1   2
 Given tree t:
 4
 / \
 1   2
 Return true, because t has the same structure and node values with a subtree of s.


 Example 2:
 Given tree s:

 3
 / \
 4   5
 / \
 1   2
 /
 0
 Given tree t:
 4
 / \
 1   2
 Return false.

 **/