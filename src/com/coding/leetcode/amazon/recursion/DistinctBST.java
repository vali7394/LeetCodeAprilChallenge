package com.coding.leetcode.amazon.recursion;/*
  @created 7/5/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistinctBST {


        public List<BinaryTreeNode<Integer>> generateBinaryTrees(int n){
            List<BinaryTreeNode<Integer>> binaryTreeNodes = new ArrayList<>();
            if(n==0) {
                binaryTreeNodes.add(null);
            }

            for(int i=0;i<n;i++){

                int rightSubTreesNodes = n-i-1;
                List<BinaryTreeNode<Integer>> leftSubTrees = generateBinaryTrees(i);
                List<BinaryTreeNode<Integer>> rightSubTrees = generateBinaryTrees(rightSubTreesNodes);

                for(BinaryTreeNode left : leftSubTrees){
                    for(BinaryTreeNode right : rightSubTrees){
                        binaryTreeNodes.add(new BinaryTreeNode<>(0,left,right));
                    }
                }

            }
            return binaryTreeNodes;
        }





    private class BinaryTreeNode<T>{
        T val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(T val, BinaryTreeNode left,
            BinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public BinaryTreeNode(BinaryTreeNode left,
            BinaryTreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

}
