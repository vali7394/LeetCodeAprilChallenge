package com.coding.leetcode.challenge.june;/*
  @created 6/4/20
  @Author  - Meeravali Shaik
 */


public class ReverseString {

    public void reverseString(char[] s) {
        if(s==null){
            return;
        }
     int left = 0;
     int right = s.length-1;

     while (left<=right){
         var c = s[left];
         s[left]=s[right];
         s[right] = c;
         left++;
         right--;
     }

    }

}


/**
 Write a function that reverses a string. The input string is given as an array of characters char[].

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 You may assume all the characters consist of printable ascii characters.



 Example 1:

 Input: ["h","e","l","l","o"]
 Output: ["o","l","l","e","h"]
 Example 2:

 Input: ["H","a","n","n","a","h"]
 Output: ["h","a","n","n","a","H"]

 */