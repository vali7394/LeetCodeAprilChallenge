package com.coding.leetcode.amazon.online.assement;/*
  @created 7/8/20
  @Author ** - Meeravali Shaik
 */

public class MaximumAverageSubtree {

    public double maximumAverageSubtree(TreeNode root) {
        return maximumAverageSubtreeHelper(root).avg;
    }

    public Average maximumAverageSubtreeHelper(TreeNode node){
        if(node==null){
            return new Average(0,0,0);
        }

        Average left = maximumAverageSubtreeHelper(node.left);
        Average right = maximumAverageSubtreeHelper(node.right);
        double childMax = Math.max(left.avg,right.avg);
        double curNodeAvg =
            (double) (node.val + left.sum + right.sum) / (1 + left.nodes + right.nodes);
        return new Average(1 + left.nodes + right.nodes, Math.max(curNodeAvg, childMax),
            node.val + left.sum + right.sum);
    }


    private class Average {
        int nodes;
        double avg;
        int sum;

        public Average(int nodes, double avg, int sum) {
            this.nodes = nodes;
            this.avg = avg;
            this.sum = sum;
        }
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
 Given the root of a binary tree, find the maximum average value of any subtree of that tree.

 (A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)



 Example 1:



 Input: [5,6,1]
 Output: 6.00000
 Explanation:
 For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
 For the node with value = 6 we have an average of 6 / 1 = 6.
 For the node with value = 1 we have an average of 1 / 1 = 1.
 So the answer is 6 which is the maximum.


 Note:

 The number of nodes in the tree is between 1 and 5000.
 Each node will have a value between 0 and 100000.
 Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 **/