package com.coding.leetcode.amazon;/*
  @created 6/17/20
  @Author ** - Meeravali Shaik
 */

public class ShortestDistanceBuildings {

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int minDistanceToReach = Integer.MAX_VALUE;
        for(int i=0 ;i<m;i++){

            for(int j=0; j<n;j++){

            }

        }
        return 0;
    }

    private int getDistanceForAllHomes(int m, int n, int i, int j, int[][] grid, boolean[][] visited, int sum){
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j]==2){
            return 0;
        }

        if(grid[i][j]==1){
            return sum+1;
        }

        visited[i][j] = true;



return 0;

    }

}


/**

 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.
 Example:

 Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 Output: 7

 Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 the point (1,2) is an ideal empty land to build a house, as the total
 travel distance of 3+3+1=7 is minimal. So return 7.


 */