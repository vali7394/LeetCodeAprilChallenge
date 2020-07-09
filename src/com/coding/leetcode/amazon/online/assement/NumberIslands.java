package com.coding.leetcode.amazon.online.assement;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */

public class NumberIslands {


    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }

        int totalIslands = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    markIslandToWater(i,j,grid);
                    totalIslands+=1;
                }
            }
        }
        return totalIslands;
    }

    private void markIslandToWater(int i, int j, char[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return ;
        }
        grid[i][j]='0';
        markIslandToWater(i+1,j,grid);
        markIslandToWater(i-1,j,grid);
        markIslandToWater(i,j-1,grid);
        markIslandToWater(i,j+1,grid);
    }

    public static void main(String[] args) {

    }


}



/**
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 Input:
 11110
 11010
 11000
 00000

 Output: 1
 Example 2:

 Input:
 11000
 11000
 00100
 00011

 Output: 3
 **/