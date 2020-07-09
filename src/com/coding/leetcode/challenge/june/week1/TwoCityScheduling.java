package com.coding.leetcode.challenge.june.week1;/*
  @created 6/3/20
  @Author  - Meeravali Shaik
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class TwoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {
        var cost = 0;
        var queue = new PriorityQueue<Integer[]>((a,b)->b[0].compareTo(a[0]));
        for(var i=0; i<costs.length; i++){
            var profit = costs[i][1]- costs[i][0];
            queue.offer(new Integer[]{profit,i});
        }
        var k = costs.length/2;
        while (k>0){
            cost+=costs[queue.poll()[1]][0];
            k--;
        }

        while (!queue.isEmpty()){
            cost+=costs[queue.poll()[1]][1];
        }
        return cost;
    }

    public static void main(String[] args) {
        int[][] input = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(twoCitySchedCost(input));
    }

}

/**

 There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

 Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.



 Example 1:

 Input: [[10,20],[30,200],[400,50],[30,20]]
 Output: 110
 Explanation:
 The first person goes to city A for a cost of 10.
 The second person goes to city A for a cost of 30.
 The third person goes to city B for a cost of 50.
 The fourth person goes to city B for a cost of 20.

 The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

 */