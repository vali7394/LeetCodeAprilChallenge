package com.coding.leetcode.challenge.june.week1;/*
  @created 6/6/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(inputOne,inputTwo)->{
            if(inputOne[0]==inputTwo[0]){
                return inputOne[1]-inputTwo[1];
            } else {
                return inputTwo[0]-inputOne[0];
            }
        });
        List<int[]> resultList = new ArrayList<>(people.length);
        for(int[] input : people){
            resultList.add(input[1],input);
        }
        int[][] result = new int[resultList.size()][];
        return resultList.toArray(result);
    }

}


/**

 Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.


 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 */