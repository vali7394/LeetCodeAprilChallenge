package com.coding.leetcode.challenge.april.week5;

/*
  @created 4/30/20
  @Author  Meeravali Shaik
 */

/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 *
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
 *
 *
 */

public class ValidSequence {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root==null || arr==null){
            return false;
        }

        return isValidSeq(root,arr,arr.length,0);
    }

    private boolean isValidSeq(TreeNode root,int[] arr,int n , int pos){
        if(root==null)return false;
        else if(pos==n) return false;
        else if(root.val!=arr[pos]) return false;
        else if(root.left==null && root.right==null && pos==n-1) return true;
        return (isValidSeq(root.left,arr,n,pos+1) || isValidSeq(root.right,arr,n,pos+1));

    }
}

