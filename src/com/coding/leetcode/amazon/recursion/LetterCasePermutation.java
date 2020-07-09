package com.coding.leetcode.amazon.recursion;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCasePermutation {


    public List<String> letterCasePermutation(String S) {
        if(S==null || S.isEmpty()){
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        letterCasePermutationHelper(S,0,result);
        System.out.println(result);
        return result;
    }

    public void letterCasePermutationHelper(String input , int start , List<String> result ){
            result.add(input);
        for(int i=start; i<input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                if(Character.isLowerCase(input.charAt(i))){
                    input = input.replace(input.charAt(i),Character.toUpperCase(input.charAt(i)));
                    letterCasePermutationHelper(input,i+1,result);
                    input = input.replace(input.charAt(i),Character.toLowerCase(input.charAt(i)));
                }else {
                    input = input.replace(input.charAt(i),Character.toLowerCase(input.charAt(i)));
                    letterCasePermutationHelper(input,i+1,result);
                    input = input.replace(input.charAt(i),Character.toUpperCase(input.charAt(i)));
                }
            }
        }

    }

    public static void main(String[] args) {
        LetterCasePermutation casePermutation = new LetterCasePermutation();
        casePermutation.letterCasePermutation("a1b2");
    }
}


/**
 Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

 Examples:
 Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

 Input: S = "3z4"
 Output: ["3z4", "3Z4"]

 Input: S = "12345"
 Output: ["12345"]
 */