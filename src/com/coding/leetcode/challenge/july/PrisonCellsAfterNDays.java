package com.coding.leetcode.challenge.july;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellsAfterNDays {


    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> stateChanges = new HashSet<>();
        int n = cells.length;
        for(int i=0; i<N; i++){
            int[] state = getStateAfterNDays(cells);
            String hashCode = Arrays.toString(state);
            if(stateChanges.contains(hashCode)){
                return prisonAfterNDays(cells, N % stateChanges.size());
            }
            stateChanges.add(hashCode);
            cells = state;
        }
        return cells;
    }


    private int[] getStateAfterNDays(int[] cells){
        int[] state = new int[cells.length];
        for(int i=1; i<cells.length-1;i++) {
            state[i] = cells[i-1]==cells[i+1]?1:0;
        }
        return state;
    }

     /*while (N > 0) {
        N--;
        int[] cells2 = new int[8];
        for (int i = 1; i < 7; ++i)
            cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        cells = cells2;
    }
        return cells;*/

    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,1,1,0,0,1};
        PrisonCellsAfterNDays nDays = new PrisonCellsAfterNDays();
        nDays.prisonAfterNDays(input,7);
    }

}