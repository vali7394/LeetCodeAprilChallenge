package com.coding.leetcode.dailycoding.practise;/*
  @created 4/20/20
  @Author  Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamDebug {

    public static void main(String[] args) {
        int[] result = IntStream.of(10,37,97,43,121,20)
            .flatMap(StreamDebug::factorize)
            .distinct()
            .sorted()
            .toArray();
    }

    private static IntStream factorize(int value){
        List<Integer> factors = new ArrayList<>();
        for(int i=2;i<value;i++){
            while (value%i==0){
                factors.add(i);
                value/=i;
            }
        }
        return factors.stream().mapToInt(Integer::intValue);
    }


}
