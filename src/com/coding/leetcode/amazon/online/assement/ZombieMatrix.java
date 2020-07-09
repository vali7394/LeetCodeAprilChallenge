package com.coding.leetcode.amazon.online.assement;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.Arrays;

public class ZombieMatrix {


    int minHours(int rows, int columns, int[][] grid) {
        if (grid==null || grid.length==0) {
            return 0;
        }
        var queue = new LinkedList<Zombie>();
        int totalTime=0;
        for(int i=0; i<grid.length ; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    queue.offer(new Zombie(0,i,j));
                }
            }
        }

        while (!queue.isEmpty()){
            Zombie zombie = queue.poll();
            int row = zombie.row;
            var col = zombie.col;
            var age = zombie.age;
            getMaxTimeBfs(rows, columns, row + 1, col, grid, queue, age + 1);
            getMaxTimeBfs(rows, columns, row - 1, col, grid, queue, age + 1);
            getMaxTimeBfs(rows, columns, row, col+1, grid, queue, age + 1);
            getMaxTimeBfs(rows, columns, row, col -1, grid, queue, age + 1);
            totalTime = Math.max(totalTime,age);
        }
        System.out.println(totalTime);
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j]==0){
                    System.out.println(-1);
                    return -1;
                }
            }
        }

        return totalTime;
    }


    private void getMaxTimeBfs(int rows, int cols, int row, int col, int[][] grid,
        Queue<Zombie> queue, int age) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col]==1) {
            return;
        }
        grid[row][col]=1;
        queue.add(new Zombie(age, row, col));
    }


    private class Zombie {

        int age;
        int row;
        int col;

        Zombie(int age, int row, int col) {
            this.age = age;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {

        int[][] grid = {{0, 1, 1, 0, 1},{0, 1, 0, 1, 0},{0, 0, 0, 0, 1},{0, 1, 0, 0, 0}};
        List<List<Integer>> input = new ArrayList<>();
        for(int[] row : grid){
            input.add((Arrays.stream(row).boxed().collect(Collectors.toList())));
        }
        ZombieMatrix matrix = new ZombieMatrix();
        matrix.minHours(input.size(),input.get(0).size(),grid);
    }

}

/**
 Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?

 Example:

 Input:
 [[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

 Output: 2

 Explanation:
 At the end of the 1st hour, the status of the grid:
 [[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

 At the end of the 2nd hour, the status of the grid:
 [[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]

 **/