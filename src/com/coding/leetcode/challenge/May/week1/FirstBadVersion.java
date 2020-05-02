package com.coding.leetcode.challenge.May.week1;/*
  @created 5/1/20
  @Author  Meeravali Shaik
 */

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class FirstBadVersion {
    // This problem is similar to first occurance of number in sorted array with duplicate value
    // TIme O(logn) space O(1)
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int result = end;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)){
                end = mid-1;
                result = mid;
            } else {
                start = mid+1;
            }
        }
        return result;
    }

    boolean isBadVersion(int version){
        return false;
    }
}
