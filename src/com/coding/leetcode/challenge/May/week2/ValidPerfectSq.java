package com.coding.leetcode.challenge.May.week2;/*
  @created 5/8/20
  @Author - Meeravali Shaik
 */

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 *
 */
public class ValidPerfectSq {


    public static void main(String[] args) {
            System.out.println(isPerfectSquarePartTwo(16));
    }

    // TC - O(SqRoot(n))
    public boolean isPerfectSquare(int num) {
        int i=1;
        while (i*i<num){
            i++;
        }

        if(i*i==num){
            return true;
        } else {
            return false;
        }
    }

    // TS - O(Logn)
    public static boolean isPerfectSquarePartTwo(int num) {
        int low = 1;
        int high = 10000;
        long mid ;
        while (low<=high){
            mid = low+(high-low)/2;
            long sq = mid*mid;
            if(sq==num){
                return true;
            } else if(sq <num){
                low = (int) mid+1;
            } else {
                high = (int) mid-1;
            }

        }
        return false;
    }

}
