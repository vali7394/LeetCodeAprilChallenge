package com.coding.leetcode.challenge.May.week3;/*
  @created 5/15/20
  @Author - Meeravali Shaik
 */

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int curMaxSum = 0;
        int minSum = Integer.MAX_VALUE;
        int curMinSum = 0;
        int TotArrSum = 0;
        for (int i = 0; i < A.length; i++) {
            curMaxSum = curMaxSum + A[i];
            maxSum = Math.max(maxSum, curMaxSum);
            curMaxSum = Math.max(0, curMaxSum);
            curMinSum = curMinSum + A[i];
            minSum = Math.min(minSum, curMinSum);
            curMinSum = Math.min(0, curMinSum);
            TotArrSum += A[i];
        }
        if(TotArrSum==minSum) {
            return maxSum;
        }
        return Math.max(maxSum, TotArrSum - minSum);
    }



    public static void main(String[] args) {
        MaximumSumCircularSubarray subarray = new MaximumSumCircularSubarray();
        int[] input1 = {1,-2,3,-2};
        int[] input2 = {5,-3,5};
        int[] input3 = {3,-1,2,-1};
        System.out.println(subarray.maxSubarraySumCircular(input1));
        System.out.println(subarray.maxSubarraySumCircular(input2));
        System.out.println(subarray.maxSubarraySumCircular(input3));
    }

    private int maxSumSubArray(int[] input){
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0 ;i<input.length;i++){
            curSum = curSum + input[i];
            maxSum = Math.max(maxSum,curSum);
            curSum = Math.max(0,curSum);
        }
        return maxSum;
    }
}


/**

 Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

 Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

 Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)



 Example 1:

 Input: [1,-2,3,-2]
 Output: 3
 Explanation: Subarray [3] has maximum sum 3
 Example 2:

 Input: [5,-3,5]
 Output: 10
 Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 Example 3:

 Input: [3,-1,2,-1]
 Output: 4
 Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 Example 4:

 Input: [3,-2,2,-3]
 Output: 3
 Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 Example 5:

 Input: [-2,-3,-1]
 Output: -1
 Explanation: Subarray [-1] has maximum sum -1


 Note:

 -30000 <= A[i] <= 30000
 1 <= A.length <= 30000




 */