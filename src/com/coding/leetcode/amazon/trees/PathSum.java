package com.coding.leetcode.amazon.trees;/*
  @created 7/5/20
  @Author ** - Meeravali Shaik
 */

public class PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root,sum);
    }


    private boolean helper(TreeNode node, int sum){
        if(sum==0 && node==null){
            return true;
        }

        if(sum!=0 && node==null){
            return false;
        }
        return helper(node.left,sum-node.val) || helper(node.right,sum-node.val);
    }
}
