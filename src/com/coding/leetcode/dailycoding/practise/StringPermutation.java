package com.coding.leetcode.dailycoding.practise;/*
  @created 6/29/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation permutation = new StringPermutation();
        permutation.permutations("aabc");
    }

    public void permutations(String input){
        List<String> list = new ArrayList<>();
        permuteHelper(input,0,list);
        System.out.println(list.size());
        list.forEach(System.out::println);
    }



    private void permuteHelper(String input, int i , List<String> result){

        if(i==input.length()){
            result.add(input);
        }

        for(int j=i ; j<input.length(); j++){
            input = swap(i,j,input);
            permuteHelper(input,i+1,result);
            input = swap(i,j,input);
        }
    }


    private String swap(int i, int j, String input) {
        char[] permute = input.toCharArray();
        char temp = permute[i];
        permute[i] = permute[j];
        permute[j] = temp;
        return String.valueOf(permute);
    }

}
