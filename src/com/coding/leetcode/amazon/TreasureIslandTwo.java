package com.coding.leetcode.amazon;/*
  @created 6/17/20
  @Author ** - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIslandTwo {

    public static void main(String[] args) {
        char[][] grid = {{'S', 'O', 'O', 'S', 'S'},
            {'D', 'O', 'D', 'O', 'D'},
            {'O', 'O', 'O', 'O', 'X'},
            {'X', 'D', 'D', 'O', 'O'},
            {'X', 'D', 'D', 'D', 'O'}};
        TreasureIslandTwo islandTwo = new TreasureIslandTwo();
        System.out.println(islandTwo.findShortestRoute(grid));
    }

    private int findShortestRoute(char[][] grid){
        if(grid==null || grid.length==0){
            return -1;
        }
        int m = grid.length-1;
        int n = grid[0].length-1;
        boolean[][] visited = new boolean[m+1][n+1];
        int steps = Integer.MAX_VALUE;
        Queue<Island> islands = new LinkedList<>();
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n;j++){
                if(grid[i][j]=='S'){
                    islands.add(new Island(i,j,0));
                }
            }
        }

        int curSteps = Integer.MAX_VALUE;
        while (!islands.isEmpty()){
            Island island = islands.poll();
            int l = island.row;
            int r = island.column;
            int curStep = island.distance;
            if(grid[l][r]=='X'){
                curSteps = curStep;
                steps = Math.min(steps,curSteps);
            }else {
                minDistanceTOTreasure(grid,l-1,r,curStep+1,islands,visited);
                minDistanceTOTreasure(grid,l+1,r,curStep+1,islands,visited);
                minDistanceTOTreasure(grid,l,r-1,curStep+1,islands,visited);
                minDistanceTOTreasure(grid,l,r+1,curStep+1,islands,visited);
            }
        }
        steps = Math.min(steps,curSteps);

        return steps;
    }

    private void minDistanceTOTreasure(char[][] grid, int i, int j, int steps,Queue<Island> islands ,boolean[][] visited){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j]=='D') {
            return;
        }
        visited[i][j]=true;
        islands.add(new Island(i,j,steps));
    }

    private class Island{
        int row;
        int column;
        int distance;

        public Island(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }




}


/**

 You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to one of the treasure islands.

 Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from one of the starting point (marked as S) of the map and can move one block up, down, left or right at a time. The treasure island is marked as X. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. Output the minimum number of steps to get to any of the treasure islands.

 Example:

 Input:
 [['S', 'O', 'O', 'S', 'S'],
 ['D', 'O', 'D', 'O', 'D'],
 ['O', 'O', 'O', 'O', 'X'],
 ['X', 'D', 'D', 'O', 'O'],
 ['X', 'D', 'D', 'D', 'O']]

 Output: 3
 Explanation:
 You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).



 */