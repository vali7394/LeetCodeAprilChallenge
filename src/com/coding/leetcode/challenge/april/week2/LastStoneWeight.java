package com.coding.leetcode.challenge.april.week2;/*
  @created 4/12/20
  @Author - Meeravali Shaik
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 *
 */


public class LastStoneWeight {

    public static void main(String[] args) {
        int[] input = {3,7,2};
        System.out.println(lastStoneWeight(input));
    }


    private static int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (n1, n2) -> n2 - n1);
        for(int i : stones){
            queue.add(i);
        }

        while (n>1){
            int first = queue.poll();
            int second = queue.poll();
            n-=2;
            first = first-second;

            if(first > 0){
                queue.add(first);
                n+=1;
            }

        }

        if(queue.isEmpty()){
            return 0;
        }else {
            return queue.peek();
        }


    }


}
