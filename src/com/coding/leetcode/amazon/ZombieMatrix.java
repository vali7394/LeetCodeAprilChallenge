package com.coding.leetcode.amazon;/*
  @created 6/15/20
  @Author ** - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.Queue;

public class ZombieMatrix {

    public static void main(String[] args) {
        int[][] zombie = {{0, 1, 1, 0, 1},{0, 1, 0, 1, 0},{0, 0, 0, 0, 1},{0, 1, 0, 0, 0}};
        ZombieMatrix matrix = new ZombieMatrix();
        System.out.println(matrix.humanDays(zombie));
    }

    public int humanDays(int[][] matrix) {

        if(matrix==null || matrix.length==0){
            return -1;
        }
        Queue<Zombie> queue = new LinkedList<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==1){
                    queue.add(new Zombie(i,j,0));
                }
            }

        }
        int currentTurn = 0;
        while (!queue.isEmpty()){
            Zombie zombie = queue.poll();
            var i = zombie.i;
            var j = zombie.j;
            var turn = zombie.turn;
            turnZombie(i+1,j,matrix,turn+1,queue);
            turnZombie(i-1,j,matrix,turn+1,queue);
            turnZombie(i,j+1,matrix,turn+1,queue);
            turnZombie(i,j-1,matrix,turn+1,queue);
            currentTurn = Math.max(currentTurn,turn);
        }

        for(int i=0; i<matrix.length;i++){
            for(int j=0; j <matrix[0].length;j++){
                if(matrix[i][j]==0){
                    return -1;
                }
            }
        }
        return currentTurn;
    }

    private void turnZombie(int i, int j , int[][] matrix, int turn,Queue<Zombie> zombies){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]==1){
            return ;
        }
        matrix[i][j] = 1;
        zombies.add(new Zombie(i,j,turn));
    }
}

class Zombie{
    int i;
    int j;
    int turn;

    public Zombie(int i, int j, int turn) {
        this.i = i;
        this.j = j;
        this.turn = turn;
    }
}

/**

 Given a 2D grid, each cell is either a zombie or a human. Zombies can turn adjacent (up/down/left/right) human beings into zombies every day. Find out how many days does it take to infect all humans?

 Input:
 matrix, a 2D integer array where a[i][j] = 1 represents a zombie on the cell and a[i][j] = 0 represents a human on the cell.

 Output:
 Return an integer represent how many days does it take to infect all humans.
 Return -1 if no zombie exists.

 Example :
 Input:
 [[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

 Output:
 2

 Explanation:
 At the end of the day 1, the status of the grid:
 [[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

 At the end of the day 2, the status of the grid:
 [[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]





 */