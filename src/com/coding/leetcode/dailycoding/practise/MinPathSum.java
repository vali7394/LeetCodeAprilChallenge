package com.coding.leetcode.dailycoding.practise;/*
  @created 6/22/20
  @Author ** - Meeravali Shaik
 */
import java.util.Arrays;
public class MinPathSum {

    public int minPathSum(int[][] input){
        int[][] cache = new int[input.length][input[0].length];

        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length;j++){
                cache[i][j] = -1;
            }
        }

        return minPathRec(input,0,0,cache);
    }


    private int minPathRec(int[][] input, int i, int j,int[][] cache) {

        if (i >= input.length || j >= input[0].length) {
            return Integer.MAX_VALUE;
        }
        if(cache[i][j]!=-1){
            return cache[i][j];
        }
        if(i+1>=input.length && j+1>=input[0].length) {
            cache[i][j] = input[i][j];
            return cache[i][j];
        }
        cache[i][j] = input[i][j] + Math.min(minPathRec(input, i + 1, j,cache), minPathRec(input, i, j + 1,cache));
        return cache[i][j];
    }

    public int minPathSumDyn(int[][] input){
        if(input==null || input.length==0){
            return 0;
        }
        int[][] costMatrix = new int[input.length][input[0].length];
        costMatrix[0][0] = input[0][0];
        for (int i = 1; i < input.length; i++) {
            costMatrix[i][0] = costMatrix[i - 1][0] + input[i][0];
        }

        for (int i = 1; i < input[0].length; i++) {
            costMatrix[0][i] = costMatrix[0][i - 1] + input[0][i];
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                costMatrix[i][j] =
                    input[i][j] + Math.min(costMatrix[i - 1][j], costMatrix[i][j - 1]);
            }
        }
        return costMatrix[(input.length - 1)][(input[0].length - 1)];
    }

    public static void main(String[] args) {
        MinPathSum pathSum = new MinPathSum();
        int[][] input = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(pathSum.minPathSum(input));
    }
}


/**
 /**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 *
 *
 *
 */
