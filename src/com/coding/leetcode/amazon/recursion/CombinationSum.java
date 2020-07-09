package com.coding.leetcode.amazon.recursion;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class CombinationSum {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null || candidates.length==0){
            return Collections.emptyList();
        }
        List<Integer> input = Arrays.stream(candidates).filter(val -> val <= target).boxed().sorted()
            .collect(Collectors.toList());
        List<List<Integer>> result= new ArrayList<>();
        combinationSumHelper(input,0,new ArrayList<>(),target,result);
        System.out.println(result);
        return result;
    }


    private void combinationSumHelper(List<Integer> input, int start, List<Integer> selected,
        int target, List<List<Integer>> result) {
        if (target < 0){
            return;
        }

        if(0==target){
            result.add(new ArrayList<>(selected));
            return;
        }

        if(start==input.size() && target!=0) {
            return;
        }

            selected.add(input.get(start));
            combinationSumHelper(input, start+1, selected, target - input.get(start), result);
            selected.remove(selected.size() - 1);
            combinationSumHelper(input, start+1, selected, target, result);
        }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        sum.combinationSum2(new int[]{2,3,2,7},7);
    }
}
