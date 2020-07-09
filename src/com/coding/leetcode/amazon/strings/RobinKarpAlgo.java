package com.coding.leetcode.amazon.strings;/*
  @created 7/3/20
  @Author ** - Meeravali Shaik
 */

public class RobinKarpAlgo {

    int prime;
    private boolean findPattern(String input, String pattern){
        double patternHashCode = findHashCode(pattern);
        int patternLength = pattern.length();
        String subString = input.substring(0,patternLength);
        double rollingHashCode = findHashCode(subString);

        for(int i=1; i<input.length()-patternLength+1;i++){

            if(patternHashCode == rollingHashCode){
                if(matchPattern(input.substring(i-2,patternLength),pattern)){
                    return true;
                };
            } else {

            }





        }


        return false;
    }

    private boolean matchPattern(String input, String pattern){
       for(int i=0; i<pattern.length();i++){
           if(input.charAt(i)!=pattern.charAt(i)){
              return false;
           }
       }
       return true;
    }
    private double findHashCode(String pattern) {
        int length = pattern.length();
        double hashCode = 0;
        int pow = 0;
        while (length >= 0) {
            hashCode = hashCode + (pattern.charAt(length - 1) * Math.pow(prime, pow));
            pow++;
            length--;
        }
        return hashCode;
    }


}
