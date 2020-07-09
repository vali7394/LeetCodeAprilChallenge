package com.coding.leetcode.amazon.leetcode;/*
  @created 7/3/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterComb {


    public static void main(String[] args) {
        LetterComb comb = new LetterComb();
        comb.letterCombinations("23");
    }
    public List<String> letterCombinations(String digits) {
        String[] combos = digits.split("");
        List<String> result = new ArrayList<>();
        Map<String,String> keyPad = getLetterMapping();
        letterComboHelper("",digits,result,keyPad);
        return result;
    }


    private void letterComboHelper(String com, String digits , List<String> result,Map<String,String> keyPad){

        if(digits.length()==0){
            result.add(com);
            return;
        }

        String digit = digits.substring(0,1);
        String letters = keyPad.get(digit);

        for(int i=0; i<letters.length();i++){
            letterComboHelper(com+letters.charAt(i),digits.substring(1),result,keyPad);
        }

    }

    private Map<String,String> getLetterMapping() {
        return Map.of("2", "abc", "3",
            "def", "4", "ghi", "5", "jkl", "6", "mno", "7",
            "pqrs", "8", "tuv",
            "9", "wxyz");
    }
}


/**


 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 **/