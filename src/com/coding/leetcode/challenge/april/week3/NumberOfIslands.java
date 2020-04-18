package com.coding.leetcode.challenge.april.week3;/*
  @created 4/17/20
  @Author - Meeravali Shaik
 */

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 *
 *
 *
 */
public class NumberOfIslands {

    public static void main(String[] args) {
       // char[][] grid = {{1,0,0},{0,1,0},{0,1,0}};
       // System.out.println(noOfIslands(grid));

        //char[][] grid1 = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
      //  System.out.println(noOfIslands(grid1));

        char[][] grid2 = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        System.out.println(noOfIslands(grid2));
    }

    private static int noOfIslands(char[][] grid){

        int totalNoOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0 ; i<m;i++ ){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ++totalNoOfIslands;
                    markIsland(grid,i,j);
                }

            }

        }
        return totalNoOfIslands;
    }

    private static void markIsland(char[][] grid, int start, int end) {
        if ((start < 0 || start >= grid.length) || (end < 0 || end >= grid[0].length)) {
            return;
        }
        if (grid[start][end] == 0 || grid[start][end] == 2) {
            return;
        } else {
            grid[start][end] = 2;
            markIsland(grid, start - 1, end);
            markIsland(grid, start + 1, end);
            markIsland(grid, start, end - 1);
            markIsland(grid, start, end + 1);
        }
    }


}
