package com.coding.leetcode.amazon.recursion;/*
  @created 7/8/20
  @Author ** - Meeravali Shaik
 */

public class UniquePath {


    public static int getUniquePath(int m, int n){
        if(m==0){
            return 0;
        }
        if(m==1 && n==1){
            return 1;
        }
       int[][] cache = new int[m][n];
        return totalUniquePaths(1, 0, m, n,cache) + totalUniquePaths(0, 1, m, n,cache);
    }

    private static int totalUniquePaths(int i, int j, int m, int n,int[][] cache){
        if(i>=m || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(cache[i][j]!=0){
            return cache[i][j];
        }
        cache[i][j] = totalUniquePaths(i+1,j,m,n,cache) + totalUniquePaths(i,j+1,m,n,cache);
        return  cache[i][j];
    }

    public static void main(String[] args) {
        System.out.println(getUniquePath(7,3));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstaclesHelper(obstacleGrid, 1, 0, cache)
            + uniquePathsWithObstaclesHelper(obstacleGrid, 0, 1, cache);
    }

    public int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int i, int j,int[][] cache){
            if(i>=obstacleGrid.length || j>=obstacleGrid[0].length || obstacleGrid[i][j]==1){
                return 0;
            }

            if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1){
                return 1;
            }
            if(cache[i][j]!=0){
                return cache[i][j];
            }
            cache[i][j] = uniquePathsWithObstaclesHelper(obstacleGrid,i+1,j,cache)+
                uniquePathsWithObstaclesHelper(obstacleGrid,i,j+1,cache);
            return cache[i][j];
    }

    public int uniquePathsIII(int[][] grid) {
        if(grid==null || grid.length==0){
                return 0;
        }
        int start = -1; int end=-1;
        int checkEnd = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j]==1){
                    start=i;
                    end = j;
                }

                if(grid[i][j]==0){
                    checkEnd++;
                }

            }
        }
        if(start==-1){
            return 0;
        }
        return uniquePathsIIIHelper(grid,-1,start,end,checkEnd);
    }

    public int uniquePathsIIIHelper(int[][] grid, int count,int i, int j,int emptyCount){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==-1){
            return 0;
        }
        if(grid[i][j]==2){
            if(emptyCount==count){
                return 1;
            }else {
                return 0;
            }
        }
        grid[i][j] = -1;
        int total = uniquePathsIIIHelper(grid,count+1,i+1,j,emptyCount);
        total+=uniquePathsIIIHelper(grid,count+1,i-1,j,emptyCount);
        total+=uniquePathsIIIHelper(grid,count+1,i,j-1,emptyCount);
        total+=uniquePathsIIIHelper(grid,count+1,i,j+1,emptyCount);
        grid[i][j]=0;
        return total;
    }

}


/**
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?


 Above is a 7 x 3 grid. How many possible unique paths are there?



 Example 1:

 Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Right -> Down
 2. Right -> Down -> Right
 3. Down -> Right -> Right
 **/