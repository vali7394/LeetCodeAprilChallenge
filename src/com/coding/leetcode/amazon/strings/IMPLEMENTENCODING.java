package com.coding.leetcode.amazon.strings;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */

public class IMPLEMENTENCODING {

    public static String enCode(String input){

        StringBuilder sb = new StringBuilder();
        var i =0 ;
        while (i<input.length()) {
            int count = 1;
            char currentChar = input.charAt(i);
            while (i<input.length()-1 && input.charAt(i)==input.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(count+""+currentChar);
            i++;
        }
        return sb.toString();

    }

    public static String deCode(String decode){

        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i<decode.length()){

            if(Character.isDigit(decode.charAt(i))){
                int count = Character.getNumericValue(decode.charAt(i));
                while (i<decode.length()-1 && count>0){
                    sb.append(decode.charAt(i+1));
                    count--;
                }
                i+=2;
            } else {
                sb.append(decode.charAt(i));
                i++;
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(enCode("aaaabcccaa"));
        System.out.println(deCode("4a1b3c2a"));
    }


}

/**

 Run-length encoding (RLE) compression offers a fast way to do efficient on-the-fly compression
 and decompression of strings. The idea is simple—encode successive repeated characters by
 the repetition count and the character. For example,
 the RLE of "aaaabcccaa" is "4alb3c2a". The decoding of "3e4f2e" returns "eeeffffee".


 */
