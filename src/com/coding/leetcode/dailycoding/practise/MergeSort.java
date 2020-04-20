package com.coding.leetcode.dailycoding.practise;/*
  @created 4/18/20
  @Author  Meeravali Shaik
 */


import java.util.Arrays;

/**
 * sorting the given array using Merge sort
 * Time : O(nlong)
 *
 *
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] input = {2,4,1,6,8,5,3,7};
        for(int i : mergeSort(input)){
            System.out.println(i);
        }
    }


    public static int[] mergeSort(int[] input){
        int n = input.length;
        if(n<2){
            return input;
        }
        int mid = n/2;
        int left[] = new int[mid];
        int right[] = new int[n-mid];

        for(int i=0 ; i<mid;i++){
            left[i] = input[i];
        }

        for(int j=mid; j<n;j++){
            right[j-mid] = input[j];
        }
        mergeSort(left);
        mergeSort(right);
       return merge(left,right,input);
    }



    public static int[] merge(int[] left, int right[] , int[] a ){

        int leftLength = left.length;
        int rightLength = right.length;
        int i =0 , j=0 , k=0;

        while(i<leftLength && j<rightLength){

            if(left[i] < right[j]){
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<leftLength){
            a[k] = left[i];
            i++;
            k++;
        }

        while (j<rightLength){
            a[k] = right[j];
            j++;
            k++;
        }
        return a;
    }



}
