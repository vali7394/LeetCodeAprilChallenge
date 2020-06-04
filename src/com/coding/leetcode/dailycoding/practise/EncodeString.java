package com.coding.leetcode.dailycoding.practise;/*
  @created 5/15/20
  @Author  - Meeravali Shaik
 */

public class EncodeString {

    public static void main(String[] args) {
        String input = "AAAABBBCCDAA";
        System.out.println(encode(input));
        System.out.println(decode(encode(input)));
    }

    private static String encode(String encode){
        StringBuilder builder = new StringBuilder();

        int i=0;

        while (i<encode.length()){
            int charCount= 1;
            while (i<encode.length()-1 && encode.charAt(i)==encode.charAt(i+1)){
                charCount++;
                i++;
            }
            builder.append(charCount).append(encode.charAt(i));
            i++;
        }
        return builder.toString();
    }

    private static String decode(String decode){
        StringBuilder builder = new StringBuilder();
        int i=0 ;
        while (i<decode.length()-1) {
            int count = Character.getNumericValue(decode.charAt(i));
            char letter = decode.charAt(i+1);
            while (count>0){
                builder.append(letter);
                count--;
            }
            i+=2;
        }
        return builder.toString();
    }

}
