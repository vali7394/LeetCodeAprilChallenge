package com.coding.leetcode.amazon.online.assement;/*
  @created 7/8/20
  @Author ** - Meeravali Shaik
 */

import java.util.List;

public class SubtreeMaximumAverage {

    public TreeNode maxAvgOfSubArray(TreeNode node){
        if(node==null){
            return null;
        }
        return findSubTreeWithMaxAbgHelper(node).result;
    }

    private Average findSubTreeWithMaxAbgHelper(TreeNode node){
        if(node==null){
            return new Average(0,0,0, null);
        }

        TreeNode result = null;
        int totalNodes = 1;
        int totalSum = node.val;
        double maxAvg = Double.MIN_VALUE;
        for(TreeNode child : node.child){
            Average childAvg =findSubTreeWithMaxAbgHelper(child);
            totalNodes+=childAvg.nodes;
            totalSum+=childAvg.sum;
            if(maxAvg < childAvg.avg){
                maxAvg = childAvg.avg;
                result = childAvg.result;
            }
        }

        double curAvg = (double) totalSum/totalNodes;

        if(curAvg > maxAvg){
            return new Average(totalNodes,totalSum,curAvg,node);
        }else {
            return new Average(totalNodes,totalSum,maxAvg,result);
        }

    }



    private class TreeNode {
        int val;
        List<TreeNode> child;
    }

    private class Average{
        int nodes;
        int sum;
        double avg;
        TreeNode result;

        public Average(int nodes, int sum, double avg,
            TreeNode result) {
            this.nodes = nodes;
            this.sum = sum;
            this.avg = avg;
            this.result = result;
        }
    }

}



/**
 Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
 A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.

 Example 1:

 Input:
 20
 /   \
 12     18
 /  |  \   / \
 11   2   3 15  8

 Output: 18
 Explanation:
 There are 3 nodes which have children in this tree:
 12 => (11 + 2 + 3 + 12) / 4 = 7
 18 => (18 + 15 + 8) / 3 = 13.67
 20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125

 18 has the maximum average so output 18.
 **/