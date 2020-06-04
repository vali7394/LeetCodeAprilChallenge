package com.coding.leetcode.challenge.May.week3;/*
  @created 5/20/20
  @Author  - Meeravali Shaik
 */

import java.util.PriorityQueue;

public class KthSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        var tracker = new PriorityQueue<Integer>((n1,n2)->(n2-n1));
        findKthSmallestElement(root,tracker,k);
        return tracker.peek();
    }

    public void findKthSmallestElement(TreeNode node , PriorityQueue<Integer> queue, int k){
        if(node == null || queue.size()==k){
            return;
        }
            findKthSmallestElement(node.left, queue, k);
            if(queue.size()<k) {
                queue.add(node.val);
                return;
            }
            findKthSmallestElement(node.right, queue, k);
    }

    TreeNode root;


    public static void main(String[] args) {
        KthSmallestElementBST smallestElementBST = new KthSmallestElementBST();
        smallestElementBST.addElement(5);
        smallestElementBST.addElement(3);
        smallestElementBST.addElement(6);
        smallestElementBST.addElement(2);
        smallestElementBST.addElement(4);
        smallestElementBST.addElement(1);
        int val = smallestElementBST.kthSmallest(smallestElementBST.root,4);
        System.out.println(val);
    }

    public void addElement(Integer val){
        root = addNode(root,val);
    }

    public TreeNode addNode(TreeNode node , int val){
        if(node==null){
            return new TreeNode(val);
        }
        if(node.val < val){
            node.right = addNode(node.right,val);
            return node;
        }

        node.left = addNode(node.left,val);
        return node;

    }

}



 class TreeNode {

     int val;
     TreeNode left;
     TreeNode right;

     public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     public TreeNode() {
     }

     public TreeNode(int val) {
         this.val = val;
     }
 }
/**


 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Example 1:

 Input: root = [3,1,4,null,2], k = 1
 3
 / \
 1   4
 \
 2
 Output: 1
 Example 2:

 Input: root = [5,3,6,2,4,null,null,1], k = 3
 5
 / \
 3   6
 / \
 2   4
 /
 1
 Output: 3
 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?




 */