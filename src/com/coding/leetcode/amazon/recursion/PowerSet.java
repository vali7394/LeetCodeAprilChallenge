package com.coding.leetcode.amazon.recursion;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet    {

    private List<List<Integer>> generatePowerSets(List<Integer> input){
        if(input==null || input.isEmpty()){
            return Collections.emptyList();
        }
        List<List<Integer>> powerSet  = new ArrayList<>();
        generatePowerSet(input,0, new ArrayList<>(),powerSet);
        System.out.println(powerSet);
        return powerSet;
    }

    private void generatePowerSet(List<Integer> input, int start,List<Integer> selected ,List<List<Integer>> powerSet){
        if(start==input.size()){
            powerSet.add(new ArrayList<>(selected));
        }
        selected.get(input.get(start));
        generatePowerSet(input,start+1,selected,powerSet);
        selected.remove(selected.size()-1);
        generatePowerSet(input,start+1,selected,powerSet);
    }

    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        powerSet.generatePowerSets(input);
    }

}

/**
 The power set of a set S is the set of all subsets of S, including both the empty set 0
 and S itself. The power set of {0,1, 2) is graphically illustrated in Figure 16.4.
 Figure 16.4: The power set of (0,1,2) is (0,(O),(1),(2),(O,1),(1,2),(O,2),(O,1,2|).
 Write a function that takes as input a set and returns its power set
 **/