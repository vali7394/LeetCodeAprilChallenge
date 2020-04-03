package com.coding.leetcode.challenge.april;

/*
  @created 4/1/20
  @Author - Meeravali Shaik
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 *
 * Input: [2,2,1]
 * Output: 1
 *
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 */
public class SingleNumberDay1 {

    public static void main(String... args){

        int[] input1 = {2,2,1};
        System.out.println(hashMapApproach(input1));
        System.out.println(xorApproach(input1));

        int[] input2 = {4,1,2,1,2};
        System.out.println(hashMapApproach(input2));
        System.out.println(xorApproach(input2));

    }


    // Time - O(n) Space - O(n)
    private static int hashMapApproach(int[] input){
        Map<Integer,Integer> numbers = new HashMap(input.length);
        for(int number : input){
            if(numbers.containsKey(number)) {
                numbers.put(number,numbers.get(number)+1);
            }else {
                numbers.put(number,1);
            }
        }

        for(Entry<Integer,Integer> entry : numbers.entrySet()){
            if(entry.getValue()==1){
               return entry.getKey();
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int xorApproach(int[] input){
        int number = 0;
        for(int x : input){
            number = number^x;
        }
        return number;
    }


}
