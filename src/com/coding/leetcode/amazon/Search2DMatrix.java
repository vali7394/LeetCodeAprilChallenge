package com.coding.leetcode.amazon;/*
  @created 6/18/20
  @Author ** - Meeravali Shaik
 */




public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }
        int left = 0;
        int right = matrix[0].length-1;

        while (left<matrix.length && right>=0){
            if(matrix[left][right]==target){
                return true;
            }
            else if(matrix[left][right]<target){
                left++;
            }else {
                right--;
            }

        }
        return false;
    }



}


/**

 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 Example:

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 **/