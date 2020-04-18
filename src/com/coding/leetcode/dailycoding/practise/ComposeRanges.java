package com.coding.leetcode.dailycoding.practise;/*
  @created 4/17/20
  @Author - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ComposeRanges {

    public static void main(String[] args) {
        List<Integer[]> output = composeRanges(new int[]{-1,0,1,2,6,7,9});
        List<Integer[]> output1 = composeRanges(new int[]{-5,3,4,5,20,21,22});
        for(Integer[] i : output){
            if(i[0]!=i[1]) {
                System.out.println(i[0] + "-->" + i[1]);
            } else {
                System.out.print("      " + i[0]+ "   ");
            }
        }

        for(Integer[] i : output1){
            if(i[0]!=i[1]) {
                System.out.println(i[0] + "-->" + i[1]);
            }else {
                System.out.print("      " + i[0]+ "  ");
            }
        }
    }


    private static List<Integer[]> composeRanges(int[] input) {

        List<Integer[]> ranges = new ArrayList();

        for(int i=0;i<input.length;i++) {
            int start = input[i];
            while (i+1<input.length && input[i]+1==input[i+1])i++;
            ranges.add(new Integer[]{start,input[i]});
        }
        return ranges;
    }

}
