package com.coding.leetcode.dailycoding.practise;/*
  @created 4/19/20
  @Author  Meeravali Shaik
 */


import java.util.Arrays;

public class BinarySearchVariations {

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,7,7,7,7,11,15,15,15,15};
        System.out.println(firstOccurrence(input,7));
        System.out.println(lastOccurrence(input,7));
        System.out.println(noOfOccurrences(input,7));
    }


    private static int binarySearch(int[] input , int k){
        int low = 0;
        int high = input.length-1;

        while (low<=high){
            int mid = (low+high)/2;
            if(input[mid]==k){
                return mid;
            } else if(k<input[mid]){
                high = mid-1;
            } else if(k>input[mid]){
                low = mid+1;
            }

        }
        return -1;
    }

    private static int firstOccurrence(int[] input, int k){
        int low = 0;
        int high = input.length-1;
        int firstOccurrence = -1;

        while (low<=high){
            int mid = (low+high)/2;
            if(input[mid]==k){
                firstOccurrence = mid;
                high = mid-1;
            } else if (input[mid]<k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return firstOccurrence;
    }

    private static int lastOccurrence(int[] input, int k){
        int low = 0;
        int high = input.length-1;
        int lastOccurrence = -1;

        while (low<=high){
            int mid = (low+high)/2;
            if(input[mid]==k){
                lastOccurrence = mid;
                low = mid+1;
            } else if (input[mid]<k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return lastOccurrence;
    }

    private static int noOfOccurrences(int[] input, int k){
        int low = 0;
        int high = input.length-1;
        int occurrences = 0;
        return lastOccurrence(input,k)-firstOccurrence(input,k)+1;
    }

    private static int findRotationCount(int[] input){

        int low = 0;
        int high = input.length-1;
        int n = input.length;

        while (low<=high){
            if(input[low] <= input[high]){
                return low;
            }
            int mid = (low+high)/2;
            int next = (mid+1)%n;
            int prev = (mid-1+n)%n;

            if(input[mid]<=input[next] && input[mid] <=input[prev]){
                return mid;
            }

           else if(input[mid]<=input[high]){
                mid = high-1;
            }  else if(input[mid]>=input[low]){
               mid = low+1;
            }
        }
        return -1;
    }

}
