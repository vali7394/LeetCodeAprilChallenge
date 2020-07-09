package com.coding.leetcode.amazon.online.assement;/*
  @created 7/7/20
  @Author ** - Meeravali Shaik
 */
import java.util.*;
public class UniqueSumPair {

    public static void main(String[] args) {
        int[] input = {1, 1};
        System.out.println(uniquePairs(input,2));
    }

    public static int uniquePairs(int[] input, int target){
        if(input==null || input.length==0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        int totalUnique = 0;
        for(int i=0; i<input.length; i++){
            if(seen.contains(input[i])){
                continue;
            }
            if(target-input[i]==input[i]){
                totalUnique++;
                seen.add(input[i]);
            }
            seen.add(input[i]);
            if(map.containsKey(input[i])){
                totalUnique++;
            } else {
                map.put(target-input[i],i);
            }
        }
        return totalUnique;
    }

}
