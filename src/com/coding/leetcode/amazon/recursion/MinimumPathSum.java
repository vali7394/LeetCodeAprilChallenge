package com.coding.leetcode.amazon.recursion;/*
  @created 7/8/20
  @Author ** - Meeravali Shaik
 */

public class MinimumPathSum {


    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int[][] cache = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid,0,0,cache);
    }

    public int minPathSumHelper(int[][] grid, int i, int j,int[][] cache){
        if(i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        if(cache[i][j]!=0){
            return cache[i][j];
        }
        int leftSum = minPathSumHelper(grid,i+1,j,cache);
        int rightSum = minPathSumHelper(grid,i,j+1,cache);
        cache[i][j] = grid[i][j] + Math.max(leftSum,rightSum);
        return cache[i][j];
    }
}
