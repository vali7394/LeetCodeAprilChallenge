package com.coding.leetcode.amazon;/*
  @created 6/18/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return List.of();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m;i++ ){
            for(int j=0; j<n;j++){

                if(matrix[i][j]==1){
                    int size = sizeOfRiver(matrix,m,n,i,j,0,visited);
                    if(size!=0) {
                        result.add(size);
                    }
                }


            }


        }
        return result;
    }


    private static int sizeOfRiver(int[][] matrix, int m , int n, int i, int j, int size,boolean[][] visited){
        if(i<0 || i>=m || j<0 || j>=n || matrix[i][j]==0 || visited[i][j]){
            return size;
        }
        if(matrix[i][j]==1){
            visited[i][j]=true;
            size+=1;
            size+=sizeOfRiver(matrix,m,n,i+1,j,0,visited);
            size+=sizeOfRiver(matrix,m,n,i-1,j,0,visited);
            size+=sizeOfRiver(matrix,m,n,i,j+1,0,visited);
            size+=sizeOfRiver(matrix,m,n,i,j-1,0,visited);
        }
        return size;
    }


    public static void main(String[] args) {
        int[][] river = {{1,0,0,1,0},{1,0,1,0,0},{0,0,1,0,1},{1,0,1,0,1},{1,0,1,1,0}};
        System.out.println(riverSizes(river));
    }
}
