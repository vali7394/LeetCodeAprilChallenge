package com.coding.leetcode.amazon;/*
  @created 6/17/20
  @Author ** - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

    public int shortestRouteToIslandDFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        boolean[][] visited = new boolean[m + 1][n + 1];
        int steps = findMinSteps(grid, 0, 0, 0, visited);
        return steps;
    }

    private int findMinSteps(char[][] grid, int i, int j, int steps, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 'D'
            || visited[i][j]) {
            return Integer.MAX_VALUE;
        }
        if (grid[i][j] == 'X') {
            return steps;
        }
        visited[i][j] = true;
        int leftSteps = findMinSteps(grid, i - 1, j, steps + 1, visited);
        int rightSteps = findMinSteps(grid, i + 1, j, steps + 1, visited);
        int downSteps = findMinSteps(grid, i, j + 1, steps + 1, visited);
        int upSteps = findMinSteps(grid, i, j - 1, steps + 1, visited);
        visited[i][j] = false;
        return Math.min(Math.min(leftSteps, rightSteps), Math.min(upSteps, downSteps));
    }

    public static void main(String[] args) {
        char[][] grid = {{'O', 'O', 'O', 'O'},{'D', 'O', 'D', 'O'},{'O', 'O', 'O', 'O'}, {'X', 'D', 'D', 'O'}};
        TreasureIsland island = new TreasureIsland();
        System.out.println(island.shortestRouteToIslandBFS(grid));
    }

    public int shortestRouteToIslandBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        Queue<Island> islands = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        islands.add(new Island(0,0,0));
        int steps = Integer.MAX_VALUE;
        while (!islands.isEmpty()){
            Island island = islands.poll();
            if(grid[island.row][island.column]=='X'){
                steps = Math.min(steps,island.steps);
            } else {
                int i=island.row;
                int j=island.column;
                int currentSteps = island.steps;
                findTreasureBfs(grid,i+1,j, islands, currentSteps, visited);
                findTreasureBfs(grid,i-1,j, islands, currentSteps, visited);
                findTreasureBfs(grid,i,j+1, islands, currentSteps, visited);
                findTreasureBfs(grid,i,j-1, islands, currentSteps, visited);
            }
        }
        return steps;
}

    private void findTreasureBfs(char[][] grid, int i, int j, Queue<Island> islands, int steps,
        boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j]=='D') {
            return;
        }
        visited[i][j] = true;
        steps=steps+1;
        islands.add(new Island(i, j, steps));
    }

private static class Island{
    int row;
    int column;
    int steps;

    public Island(int row, int column, int steps) {
        this.row = row;
        this.column = column;
        this.steps = steps;
    }
}
}

/**


 You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
 There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
 Assume the map area is a two dimensional grid, represented by a matrix of characters.
 You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
 The treasure island is marked as ‘X’ in a block of the matrix. ‘X’ will not be at the top-left corner.
 Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
 Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
 Output the minimum number of steps to get to the treasure.
 e.g.
 Input
 [
 [‘O’, ‘O’, ‘O’, ‘O’],
 [‘D’, ‘O’, ‘D’, ‘O’],
 [‘O’, ‘O’, ‘O’, ‘O’],
 [‘X’, ‘D’, ‘D’, ‘O’],
 ]


 */