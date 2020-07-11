package com.coding.leetcode.amazon.online.assement.practise;/*
  @created 7/10/20
  @Author b008245 - Meeravali Shaik 
 */

public class Islands {

    public int numIslands(char[][] grid) {

        int islands = 0;
        if(grid==null || grid.length==0){
            return islands;
        }

        int rows = grid.length; int cols = grid[0].length;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    islands++;
                    markTheConnectedIslandsToVisited(grid,rows,cols,i,j,visited);
                }
            }

        }
        return islands;
    }

    private void markTheConnectedIslandsToVisited(char[][] grid, int rows, int cols, int i, int j,boolean[][] visited){
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || grid[i][j]=='0'){
            return;
        }
        visited[i][j] = true;
        markTheConnectedIslandsToVisited(grid,rows,cols,i+1,j,visited);
        markTheConnectedIslandsToVisited(grid,rows,cols,i-1,j,visited);
        markTheConnectedIslandsToVisited(grid,rows,cols,i,j+1,visited);
        markTheConnectedIslandsToVisited(grid,rows,cols,i,j-1,visited);
    }

}


/**
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.



 Example 1:

 Input: grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 Output: 1
 Example 2:

 Input: grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 Output: 3
 **/