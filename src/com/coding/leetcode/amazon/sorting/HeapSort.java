package com.coding.leetcode.amazon.sorting;/*
  @created 7/2/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {

    public static  void main(String[] args){
        /*var queue = new PriorityQueue<Integer>(5);
        for(var i=10; i>0;i--){
            queue.offer(i);
        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }*/

        int[] nums = {-95, 92, -85, 59, -59, -14, 88, -39, 2, 92, 94, 79, 78, -58, 37, 48, 63, -91,
            91, 74, -28, 39, 90, -9, -72, -88, -72, 93, 38, 14, -83, -2, 21, 4, -75, -65, 3, 63,
            100, 59, -48, 43, 35, -49, 48, -36, -64, -13, -7, -29, 87, 34, 56, -39, -5, -27, -28,
            10, -57, 100, -43, -98, 19, -59, 78, -28, -91, 67, 41, -64, 76, 5, -58, -89, 83, 26, -7,
            -82, -32, -76, 86, 52, -6, 84, 20, 51, -86, 26, 46, 35, -23, 30, -51, 54, 19, 30, 27,
            80, 45, 22};
        for(var i : maxSlidingWindow(nums,10)){
            System.out.println(i);
        }

    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        var result = new ArrayList<Integer>();
        var queue = new PriorityQueue<int[]>((i1,i2)->i2[1]-i1[1]);
        int i=0;
        while (i<k) {
            if(!queue.isEmpty() && queue.peek()[1] < nums[i]) {
                queue.poll();
            }
            queue.offer(new int[]{i,nums[i]});
            i++;
        }
        int j=0;
        result.add(queue.peek()[1]);
        while (!queue.isEmpty() && i<nums.length){
            int[] peak = queue.peek();
            if(peak[0]==(i-k) || peak[1]<nums[i]){
                queue.poll();
            }
            queue.offer(new int[]{i,nums[i]});
            result.add(queue.peek()[1]);
            i++;
            j++;
        }
        int[] output = new int[result.size()];
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
