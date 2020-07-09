package com.coding.leetcode.amazon.strings;/*
  @created 7/3/20
  @Author ** - Meeravali Shaik
 */

public class KmpPrefixAlgo {

    public static void main(String[] args) {
        KmpPrefixAlgo prefixAlgo = new KmpPrefixAlgo();
        System.out.println(prefixAlgo.searchPattern("mississippi",
            "issipi"));
    }

    private boolean searchPattern(String input, String pattern){

        int[] lps = new int[pattern.length()];
        buildLps(pattern,lps);
        int i=0;
         int j=0;
         while (i<input.length() && j<pattern.length()){
                 if(input.charAt(i)==pattern.charAt(j)){
                     i++;
                     j++;
                 }

                 else {

                     if(j!=0){
                         j = lps[j-1];
                     }else {
                         i++;
                     }

                 }

             }

         if(j==pattern.length()){
             return true;
         }
         return false;
    }

    private void buildLps(String pattern,int[] lps){

        int i=0; int j=1;

        while (j<pattern.length()){

            if(pattern.charAt(i)==pattern.charAt(j)){
                lps[j] = i+1;
                j++;
                i++;
            } else {
                if(i!=0){
                    i = lps[i-1];
                }
               else {
                   lps[j]=0;
                   j++;
                }
            }

        }

    }

}
