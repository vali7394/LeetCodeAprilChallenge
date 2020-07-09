package com.coding.leetcode.amazon.recursion;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberPermutation {

    private List<List<Integer>> generatePermutations(List<Integer> input){
        if(input==null || input.size()==0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(input);
        boolean[] visited = new boolean[input.size()];
        permuteHelper(0,input,result,visited);
        System.out.println(result);
        return result;
    }

    private void permuteHelper(int start,List<Integer> input,List<List<Integer>> result,boolean[] visited){
        if(start==input.size()-1){
            result.add(new ArrayList<>(input));
            return;
        }

        for(int i=start; i<input.size(); i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            swap(start,i,input);
            permuteHelper(start+1,input,result,visited);
            swap(i,start,input);
            visited[i] = false;
            if (i > 0 && input.get(i) == input.get(i-1) && visited[i-1]) {
                return;
            }
        }
    }

    private void swap(int start, int end, List<Integer> input){
        int temp = input.get(start);
        input.set(start,input.get(end));
        input.set(end,temp);
    }

    public static void main(String[] args) {
        NumberPermutation permutation = new NumberPermutation();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(1);
        permutation.generatePermutations(input);
    }
}
