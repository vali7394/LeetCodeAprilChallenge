package com.coding.leetcode.amazon;/*
  @created 6/18/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberBalloons {

    public int maxNumberOfBalloons(String text) {

        Map<Character,Integer> charMap = new HashMap<>();

        for(Character letter : text.toCharArray()){
            if(charMap.containsKey(letter)){
                charMap.put(letter,charMap.get(letter)+1);
            } else {
                charMap.put(letter,1);
            }
        }

        int minValue = Integer.MAX_VALUE;
        String balloon = "balloon";
        for(Character character : balloon.toCharArray()){
            if(charMap.containsKey(character)){
                int curMin = charMap.get(character);
                if(character=='l' || character=='o'){
                    curMin = curMin/2;
                    if(curMin==0){
                        return 0;
                    }
                }
                minValue = Math.min(minValue,curMin);
            }else {
                return 0;
            }
        }
        return minValue;
    }

}


/**

 Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

 You can use each character in text at most once. Return the maximum number of instances that can be formed.



 Example 1:



 Input: text = "nlaebolko"
 Output: 1
 Example 2:



 Input: text = "loonbalxballpoon"
 Output: 2



 */