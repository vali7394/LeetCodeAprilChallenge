package com.coding.leetcode.amazon.recursion;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateSubSetSizeK {

    public static void main(String[] args) {
        GenerateSubSetSizeK subSetSizeK = new GenerateSubSetSizeK();
        System.out.println(subSetSizeK.combine(5,2));
    }

    public List<List<Integer>> combine(int n, int k){
        List<Integer> input  = IntStream.range(1,n+1).boxed().collect(Collectors.toList());
        List<List<Integer>> result= new ArrayList<>();
        subSetHelper(input,k,0,new ArrayList<>(),result);
        return result;
    }


    private void subSetHelper(List<Integer> input, int k, int start, List<Integer> selected ,List<List<Integer>> result){
        if(selected.size()==k){
            result.add(new ArrayList<>(selected));
            return;
        }

        if(selected.size()>k){
            return;
        }

       // int remaining = k-selected.size();

        for(int i=start; i<input.size(); i++){
            selected.add(input.get(i));
            subSetHelper(input,k,i+1,selected,result);
            selected.remove(selected.size()-1);
        }


    }

}
