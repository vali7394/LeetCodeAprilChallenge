package com.coding.leetcode.amazon.online.assement;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */

public class TreasureIsland {

    public static void main(String[] args) {
        char[][] grid = {{'S', 'O', 'O', 'S', 'S'},
            {'D', 'O', 'D', 'O', 'D'},
            {'O', 'O', 'O', 'O', 'X'},
            {'X', 'D', 'D', 'O', 'O'},
            {'X', 'D', 'D', 'D', 'O'}};
        TreasureIsland island = new TreasureIsland();
        System.out.println(island.treasureIsland(grid));

    }

    public int treasureIsland(char[][] island) {

        if(island==null || island.length==0){
            return 0;
        }

        boolean[][] visited = new boolean[island.length][island[0].length];
        int steps = Integer.MAX_VALUE;
        for(int i=0; i<island.length; i++){
            for(int j=0; j<island[0].length; j++){
                if(island[i][j]=='S'){
                    int curSteps = treasureDistanceHelper(island,i,j,visited,0);
                    steps = Math.min(steps,curSteps);
                }
            }
        }
        return steps;
    }

    private int treasureDistanceHelper(char[][] island, int row, int col,boolean[][] visited, int steps){
        if(row<0 || row>=island.length || col<0 || col>=island[0].length || visited[row][col] || island[row][col]=='D'){
            return Integer.MAX_VALUE;
        }

        visited[row][col] = true;
        if(island[row][col]=='X'){
            return steps;
        }
        steps=steps+1;
        int leftSteps = treasureDistanceHelper(island,row-1,col,visited,steps);
        int rightSteps = treasureDistanceHelper(island,row+1,col,visited,steps);
        int upSteps = treasureDistanceHelper(island,row,col-1,visited,steps);
        int downSteps = treasureDistanceHelper(island,row,col+1,visited,steps);
        visited[row][col] = false;
        return Math.min(Math.min(leftSteps,rightSteps),Math.min(upSteps,downSteps));
    }

}


/**
 You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.

 Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of steps to get to the treasure.

 Example:

 Input:
 [['O', 'O', 'O', 'O'],
 ['D', 'O', 'D', 'O'],
 ['O', 'O', 'O', 'O'],
 ['X', 'D', 'D', 'O']]

 Output: 5
 Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 **/