package com.coding.leetcode.amazon.recursion;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecompo {

    public static void main(String[] args) {
        PalindromicDecompo decompo = new PalindromicDecompo();
        palindromePartitioning("abc");
            }

    public static List<List<String>> palindromePartitioning(String input) {
        List<List<String>> result = new ArrayList<>();
        palindrumDecompHelper(input,0,new ArrayList<>(),result);
        System.out.println(result);
        return result;
    }


    private static void palindrumDecompHelper(String input, int start, List<String> selected,
        List<List<String>> result) {
        if(start==input.length()) {
            result.add(new ArrayList<>(selected));
        }

        for(int i=start; i<input.length(); i++){
            if(isPalindrum(input.substring(start,i+1))){
                selected.add(input.substring(start,i+1));
                palindrumDecompHelper(input,i+1,selected,result);
                selected.remove(selected.size()-1);
            }
        }

    }


    private static boolean isPalindrum(String s){
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
