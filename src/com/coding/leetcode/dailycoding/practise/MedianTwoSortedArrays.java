package com.coding.leetcode.dailycoding.practise;/*
  @created 6/13/20
  @Author ** - Meeravali Shaik
 */

public class MedianTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var m = nums1.length;
        var n = nums2.length;
        int[] x = m < n ? nums1: nums2;
        int[] y = m > n ? nums1: nums2;
        var start = 0 ; var end = x.length;
        double median = Integer.MIN_VALUE;
        while (start <= end){
            var parX = (start+end)/2;
            var parY = (m+n+1)/2-parX;
            var minX = parX==x.length?Integer.MAX_VALUE:x[parX];
            var maxX = parX==0?Integer.MIN_VALUE:x[parX-1];
            var minY = parY==y.length?Integer.MAX_VALUE:y[parY];
            var maxY = parY==0?Integer.MIN_VALUE:y[parY-1];
            if(minX>=maxY && minY>=maxX) {
                if ((m + n) % 2 == 0) {
                    median = (double)(Math.max(minX, minY) + Math.min(maxX, maxY)) / 2;
                } else {
                    median = Math.max(minX,minY);
                }
            }
            else if(minX<maxY){
                    start = parX+1;
                }else {
                    end = parY-1;
                }

            }
        return median;
    }
}


/**

 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5

 */