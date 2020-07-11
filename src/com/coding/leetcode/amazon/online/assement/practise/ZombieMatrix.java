package com.coding.leetcode.amazon.online.assement.practise;/*
  @created 7/10/20
  @Author b008245 - Meeravali Shaik 
 */

import java.util.*;
import java.util.stream.Collectors;

public class ZombieMatrix {

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
        List<List<Integer>> gird = Arrays.stream(grid).map(rows->Arrays.stream(rows).boxed().collect(Collectors.toList())).collect(
            Collectors.toList());
        ZombieMatrix matrix = new ZombieMatrix();
        System.out.println(matrix.minHours(4,5,gird));
    }

    int minHours(int rows, int columns, List<List<Integer>> grid) {
        if(grid==null){
            return 0;
        }

        var queue = new LinkedList<Zombie>();

        for(int i=0; i<rows ; i++){
            for(int j=0; j<columns; j++){
                if(grid.get(i).get(j)==1){
                    queue.offer(new Zombie(i,j,0));
                }
            }
        }
        if(queue.isEmpty()){
            return 0;
        }
        int totalDays = 0;
        while(!queue.isEmpty()) {
            var zombie = queue.poll();
            var row = zombie.row;
            var col = zombie.col;
            var day = zombie.time;
            totalDays = Math.max(totalDays,day);
            validateGridCell(row+1,col,rows,columns,day+1,grid,queue);
            validateGridCell(row-1,col,rows,columns,day+1,grid,queue);
            validateGridCell(row,col+1,rows,columns,day+1,grid,queue);
            validateGridCell(row,col-1,rows,columns,day+1,grid,queue);
        }
        return totalDays;
    }

    private void validateGridCell(int row, int col, int rows, int columns,int time, List<List<Integer>> grid, Queue<Zombie> queue) {
        if(row<0 || row>=rows || col <0 || col >=columns || grid.get(row).get(col)!=0){
            return;
        }
        grid.get(row).set(col,time);
        queue.offer(new Zombie(row,col,time));
    }

    private class Zombie {
        int row;
        int col;
        int time;

        Zombie(int row,int col,int time){
            this.row=row;
            this.col= col;
            this.time = time;
        }

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
 int minHours(int rows, int columns, List<List<Integer>> grid) {
 // todo
 }
 **/