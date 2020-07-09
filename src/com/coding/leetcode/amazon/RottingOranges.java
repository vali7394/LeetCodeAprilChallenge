package com.coding.leetcode.amazon;/*
  @created 6/15/20
  @Author ** - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        //int[][] oranges = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] oranges = {{0}};
        System.out.println(rottingOranges.orangesRotting(oranges));
    }

    public int orangesRotting(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return -1;
        }
        int freshOranges=0;
        Queue<Orange> rotten = new LinkedList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==2){
                    rotten.add(new Orange(i,j,0));
                }
                if(matrix[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges==0){
            return 0;
        }
        if(rotten.isEmpty()){
            return -1;
        }
        int maxMin = 0;
        while(!rotten.isEmpty()){
            Orange orange = rotten.poll();
            int i = orange.i;
            int j = orange.j;
            int minute = orange.minute;
            makeRotten(matrix,i+1,j,minute+1,rotten);
            makeRotten(matrix,i-1,j,minute+1,rotten);
            makeRotten(matrix,i,j+1,minute+1,rotten);
            makeRotten(matrix,i,j-1,minute+1,rotten);
            maxMin = Math.max(maxMin,minute);
        }

        for(int i=0; i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    return -1;
                }
            }
        }

        return maxMin;
    }

    private void makeRotten(int[][] matrix, int i, int j, int minute,Queue<Orange> rotten){
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0
            || matrix[i][j] == 2) {
            return;
        }
        matrix[i][j]=2;
        rotten.add(new Orange(i,j,minute));
    }


    public  static class Orange{
        int i;
        int j;
        int minute;

        public Orange(int i, int j, int minute) {
            this.i = i;
            this.j = j;
            this.minute = minute;
        }
    }
}


/**
 In a given grid, each cell can have one of three values:

 the value 0 representing an empty cell;
 the value 1 representing a fresh orange;
 the value 2 representing a rotten orange.
 Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

 Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



 Example 1:



 Input: [[2,1,1],[1,1,0],[0,1,1]]
 Output: 4
 Example 2:

 Input: [[2,1,1],[0,1,1],[1,0,1]]
 Output: -1
 Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 Example 3:

 Input: [[0,2]]
 Output: 0
 Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

 **/