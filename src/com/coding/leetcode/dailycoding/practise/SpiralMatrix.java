package com.coding.leetcode.dailycoding.practise;/*
  @created 4/23/20
  @Author - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralMatrix {

    public static void main(String[] args) {
            int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
            System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> sprialElements = new ArrayList<>();
        int top = 0;
        int left = 0;
        int down = matrix.length-1;
        int right = matrix[0].length-1;

        int direction = 0;

        while (top<=down && left<=right){

            if(direction==0){

                for(int i=left;i<=right;i++){
                    sprialElements.add(matrix[top][i]);
                }
                top++;
            } else if(direction==1){
                for(int i=top;i<=down;i++){
                    sprialElements.add(matrix[i][right]);
                }
                right--;
            } else if(direction==2){
                for (int i=right;i>=left;i--){
                    sprialElements.add(matrix[down][i]);
                }
                down--;
            } else if(direction==3){
                for(int i=down;i>=top;i--){
                    sprialElements.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction+1)%4;
        }

        return sprialElements;
    }


}
