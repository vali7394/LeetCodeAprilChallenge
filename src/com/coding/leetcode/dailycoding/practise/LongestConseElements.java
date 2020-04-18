package com.coding.leetcode.dailycoding.practise;/*
  @created 4/17/20
  @Author  Meeravali Shaik
 */

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConseElements {

    public static void main(String[] args) {
            int[] input = {100,4,300,3,1,2};
            System.out.println(longestConArra(input));
    }


    private static int longestConArra(int[] input){

        int longestSubSeq = 0;
        Set<Integer> nums = Arrays.stream(input).boxed().collect(Collectors.toSet());

        for(int i=0; i<input.length;i++){
            int currentNum = input[i];
            int count = 1;
            if(!nums.contains(input[i]-1)){
                while (nums.contains(currentNum+1)){
                    currentNum+=1;
                    count++;
                }
            }
            longestSubSeq = Math.max(longestSubSeq,count);

        }


        return longestSubSeq;
    }

}
