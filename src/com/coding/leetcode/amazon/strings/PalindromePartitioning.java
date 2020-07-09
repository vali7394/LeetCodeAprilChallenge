package com.coding.leetcode.amazon.strings;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {


    public List<List<String>> partition(String s) {
        if(s==null || s.isEmpty()){
            return Collections.emptyList();
        }

        List<List<String>> result = new ArrayList<>();
        partitionHelper(s,new ArrayList<>(),0,result);
        return result;
    }


    private void partitionHelper(String s , List<String> selected ,int start, List<List<String>> result){
        if(start==s.length()){
            result.add(selected);
            return;
        }
        for(int i=start; i<s.length(); i++){
           if(isPalindrum(s.substring(start,i+1))){
               selected.add(s.substring(start,i+1));
               partitionHelper(s,selected,i+1,result);
               selected.remove(selected.size()-1);
           }
        }

    }


    private boolean isPalindrum(String s){
        if(s.length()==1){
            return true;
        }

        int start =0 ;
        int end = s.length()-1;

        while (start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}


/**
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 **/