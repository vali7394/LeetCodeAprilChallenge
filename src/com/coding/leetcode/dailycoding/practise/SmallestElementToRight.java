package com.coding.leetcode.dailycoding.practise;/*
  @created 5/20/20
  @Author  - Meeravali Shaik
 */

public class SmallestElementToRight {

    public static void main(String[] args){
        var input = new int[]{1, 2, 3, 4, 5};
        for(var result : smallestToRight(input)){
            System.out.println(result);
        }
    }

    private static int[] smallestToRight(int[] input){
       var result = new int[input.length];
        result[input.length-1] = 0;
        var i = input.length-2;
        while(i>=0) {
            var j=i+1;
            var count = 0;
            while (j<input.length){
                if(input[i] > input[j]){
                    count++;
                }
                j++;
            }
            result[i] = count;
            i--;
        }
        return result;
    }

    private static int[] smallestToRightBetter(int[] input){
        var result = new int[input.length];

        return result;
    }
}



/**

 Write a function to count number of smaller elements on right of each element in an array. Given an unsorted array arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains count of smaller elements on right side of each element arr[i] in array.

 Examples:

 Input:   arr[] =  {12, 1, 2, 3, 0, 11, 4}
 Output:  countSmaller[]  =  {6, 1, 1, 1, 0, 1, 0}

 (Corner Cases)
 Input:   arr[] =  {5, 4, 3, 2, 1}
 Output:  countSmaller[]  =  {4, 3, 2, 1, 0}

 Input:   arr[] =  {1, 2, 3, 4, 5}
 Output:  countSmaller[]  =  {0, 0, 0, 0, 0}

 */