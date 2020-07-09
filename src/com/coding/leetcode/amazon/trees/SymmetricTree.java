package com.coding.leetcode.amazon.trees;/*
  @created 7/5/20
  @Author ** - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {



    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return symmetricHelper(root.left,root.right);
    }



    public boolean symmetricHelper( TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return symmetricHelper(left.left,right.right)&&symmetricHelper(left.right,right.left);

    }

    private boolean isSymmetricIterative(TreeNode root){
        if(root==null){
           return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (queue.size()>1){
                var left = queue.poll();
                var right=queue.poll();

                if(left==null && right==null){
                    continue;
                }

                if(left==null || right==null){
                    return false;
                }

                if(left.val!=right.val){
                    return false;
                }

                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);

        }
        return true;
    }

}
