package com.coding.leetcode.amazon.recursion;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

public class Nqueen {

    public static void main(String[] args){

    List<List<Integer>> psblPlacements = new ArrayList<>();
    findNQueenPlacementHelper(0,4,new ArrayList<>(),psblPlacements);
    System.out.println(psblPlacements);
    }

    public static void findNQueenPlacementHelper(int row, int n , List<Integer> colPos,List<List<Integer>> psblPlacements) {
    if(row==n){
        psblPlacements.add(new ArrayList<>(colPos));
    }

    for(int i=0; i<n; i++){
        colPos.add(i);
        if(isValidPos(colPos)){
            findNQueenPlacementHelper(row+1,n,colPos,psblPlacements);
        }
        colPos.remove(colPos.size()-1);
    }

    }

    private static boolean isValidPos(List<Integer> colPos){
        int rowId = colPos.size()-1;

        for(int i=0; i<rowId; i++){
            int diff = Math.abs(colPos.get(i)-colPos.get(rowId));

            if(diff==0 || diff == rowId-i){
                return false;
            }

        }
    return true;
    }
}
