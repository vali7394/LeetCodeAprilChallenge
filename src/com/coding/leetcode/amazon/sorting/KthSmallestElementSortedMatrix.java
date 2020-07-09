package com.coding.leetcode.amazon.sorting;/*
  @created 6/26/20
  @Author ** - Meeravali Shaik
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        var queue = new PriorityQueue<Integer>((n1,n2)->n2-n1);
        int m = matrix.length;
        int n= matrix[0].length;

        int i=0; int j=0;
        queue.offer(matrix[i][j]);
        while (i<m && j <n){
            if(queue.size()==k){
                return queue.poll();
            }

            if(i+1==m){
                queue.offer(matrix[i][j]);
                j++;
            } else if(j+1==n){
                queue.offer(matrix[i][j]);
                i++;
            }

            else if(matrix[i+1][j] < matrix[i][j+1]){
                queue.offer(matrix[i+1][j]);
                i++;
            } else {
                queue.offer(matrix[i][j+1]);
                j++;
            }
        }
        return -1;
    }



}


/**

 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ n2.
 */