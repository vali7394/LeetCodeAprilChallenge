package com.coding.leetcode.amazon;/*
  @created 6/15/20
  @Author ** - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        WallsAndGates gates = new WallsAndGates();
        gates.wallsAndGates(rooms);
        System.out.println("");

    }

    public void wallsAndGates(int[][] rooms) {
    if(rooms==null || rooms.length==0){
        return;
    }
    Queue<Gate> gates = new LinkedList<>();
     for(int i=0; i< rooms.length; i++){
         for(int j=0; j<rooms[0].length; j++){
             if(rooms[i][j]==0){
                 gates.add(new Gate(i,j,0));
             }
         }
     }

     if(gates.isEmpty()){
         return;
     }

     while (!gates.isEmpty()){
         Gate gate = gates.poll();
         int i=gate.i;
         int j= gate.j;
         int nearestGate = gate.nearestGate;
         findNearestGate(rooms,i+1,j,nearestGate+1,gates);
         findNearestGate(rooms,i-1,j,nearestGate+1,gates);
         findNearestGate(rooms,i,j+1,nearestGate+1,gates);
         findNearestGate(rooms,i,j-1,nearestGate+1,gates);
     }
        System.out.println(rooms);
    }

    public void findNearestGate(int[][] rooms , int i, int j, int nearestGate,Queue<Gate> gates){
        if(i<0 || i>=rooms.length || j<0 || j>=rooms[0].length || rooms[i][j]==-1 || rooms[i][j]==0){
            return;
        }
        if(rooms[i][j]==Integer.MAX_VALUE) {
            rooms[i][j] = nearestGate;
            gates.add(new Gate(i, j, nearestGate));
        }
    }

    public static class Gate{
        int i;
        int j;
        int nearestGate;

        public Gate(int i, int j, int nearestGate) {
            this.i = i;
            this.j = j;
            this.nearestGate = nearestGate;
        }
    }

}



/**

 You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 Example:

 Given the 2D grid:

 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4

 */
