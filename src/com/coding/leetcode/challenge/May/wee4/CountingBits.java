package com.coding.leetcode.challenge.May.wee4;/*
  @created 5/28/20
  @Author  - Meeravali Shaik
 */

public class CountingBits {


    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        for(var i=0 ;i<=num;i++){
            int count = 0;
            for(var j=0 ; j<32;j++){
              var k= 1<<j;
                if((i&k)>0){
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }


    public static int[] countBitsII(int num) {
        int[] result = new int[num+1];
        for(var i=0; i<=num;i++){
            result[i] = Integer.bitCount(i);
        }
        return result;
    }


    public static void main(String[] args) {
        for(var count : countBits(5)){
            System.out.println(count);
        }
    }

    /*public int[] countBitsIII(int num) {

    }*/

}


/**

 Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example 1:

 Input: 2
 Output: [0,1,1]
 Example 2:

 Input: 5
 Output: [0,1,1,2,1,2]

 */