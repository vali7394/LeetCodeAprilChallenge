package com.coding.leetcode.challenge.april.week1;

/*
  @created 4/2/20
  @Author Meeravali Shaik
 */


import java.util.HashSet;
import java.util.Set;

/**
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or
 * it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */
public class HappyNumberDay2 {

    public static void main(String[] args) {
        System.out.println(isHappyNumber(19));
    }


    private static boolean isHappyNumber(int number){

        Set<Integer> numbers= new HashSet<>();
        while (true) {
            int val = 0;
            while(number > 0){
                int temp = number%10;
                val = val + temp * temp;
                number = number/10;
            }

            if(val==1){
                return true;
            } else if(numbers.contains(val)){
                return false;
            } else {
                numbers.add(val);
            }
            number = val;
        }

    }

}
