package com.coding.leetcode.amazon;/*
  @created 6/15/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowColumnSum {

    public static void rowColumnSum(int[][] input){
        if(input==null || input.length==0){
            return ;
        }
        int maxRowSum = Integer.MIN_VALUE;
        for(int i=0;i<input.length;i++){
            int rowSum = 0;
            int columnSum = 0;
            for(int j=0; j<input[0].length; j++){
                rowSum+=input[i][j];
            }
            maxRowSum = Math.max(maxRowSum,rowSum);
        }

        int maxColumnSum = Integer.MIN_VALUE;
        for(int i=0;i<input[0].length;i++){
            int sum = 0;
            for(int j=0; j<input.length; j++){
                sum+=input[j][i];
            }
            maxColumnSum = Math.max(maxColumnSum,sum);
        }

        System.out.println(maxRowSum);
        System.out.println(maxColumnSum);

    }

    public static void main(String[] args) {
        int[][] input = { {1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        rowColumnSum(input);
    }

}

/**
 *
 * Given a matrix of order m*n, the task is to find out the sum of each row and each column of a matrix.
 *
 * Examples:
 *
 * Input: array[4][4] = { {1, 1, 1, 1},
 *                        {2, 2, 2, 2},
 *                        {3, 3, 3, 3},
 *                        {4, 4, 4, 4}};
 * Output: Sum of the 0 row is = 4
 *         Sum of the 1 row is = 8
 *         Sum of the 2 row is = 12
 *         Sum of the 3 row is = 16
 *         Sum of the 0 column is = 10
 *         Sum of the 1 column is = 10
 *         Sum of the 2 column is = 10
 *         Sum of the 3 column is = 10
 *
 *
 */
