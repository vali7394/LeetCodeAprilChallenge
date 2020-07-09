package com.coding.leetcode.challenge.june.week2;/*
  @created 6/9/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        var m = s.length();
        var n = t.length();
        if(m>n){
            return false;
        }
        var i=0;
        var j=0;
            while (i<m && j<n){
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                }
                j++;
            }
        if(i<m){
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        var subsequence = new IsSubsequence();
        System.out.println(subsequence.betterApproachMap("aaaaaa","bbaaaa"));
    }

    public boolean betterApproach(String s, String t){
        var index = -1;
        for(var letter : s.toCharArray()){
            index = t.indexOf(letter,index+1);
            if(index==-1){
                return false;
            }
        }
        return true;
    }

    public boolean betterApproachMap(String s, String t){

        var countMap = new HashMap<Character, List<Integer>>(26);
        for(var i=0; i<t.length();i++){
            Character letter = t.charAt(i);
            if(countMap.containsKey(letter)){
                countMap.get(letter).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                countMap.put(letter,list);
            }
        }

        int low = -1;

        for(var i=0; i<s.length();i++){

            var letter = s.charAt(i);
            if(!countMap.containsKey(letter)){
                return false;
            }
            List<Integer> indices = countMap.get(letter);
           var position = findUpperBound(indices,low);
           if(position==-1){
               return false;
           }
             low = position;
        }
        return true;

    }

    private int findUpperBound(List<Integer> indices,int index){
        int low = 0;
        int high = indices.size();
        int result= -1;
        while(low < high){
            int mid = low+(high-low)/2;
            if(indices.get(mid) > index){
                high = mid;
            } else {
                low = mid+1;
            }
            result = low==indices.size()?-1:indices.get(low);
        }
        return result;
    }

}


/**
 Given a string s and a string t, check if s is subsequence of t.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

 Credits:
 Special thanks to @pbrother for adding this problem and creating all test cases.



 Example 1:

 Input: s = "abc", t = "ahbgdc"
 Output: true
 Example 2:

 Input: s = "axc", t = "ahbgdc"
 Output: false
 */