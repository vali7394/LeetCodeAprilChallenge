package com.coding.leetcode.amazon.sorting;/*
  @created 6/29/20
  @Author ** - Meeravali Shaik
 */

import java.util.Random;

public class QuickSort {


    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] input = {10 ,80, 30 ,90 ,40, 50, 70};
        sort.quickSort(input,0,input.length-1);
        for(int i : input){
            System.out.print(" " + i);
        }
    }

    public void quickSort(int[] input, int start, int end){
        if(start < end){
            int pIndex = randomizedQuickSort(input,start,end);
            quickSort(input,start,pIndex-1);
            quickSort(input,pIndex+1,end);
        }
    }


    public int getPartitionIndex(int[] input , int start, int end){
        int pivot = input[end];
        int pIndex = start;

        for(int i=start; i<=end-1 ; i++){
            if(input[i]<=pivot){
                swap(input,i,pIndex);
                pIndex++;
            }
        }
        swap(input,end,pIndex);
        return pIndex;
    }

    private void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private int randomizedQuickSort(int[] input,int start, int end){
        Random rand= new Random();
        int pivot = rand.nextInt(end-start) + start;
        swap(input,pivot,end);
        return getPartitionIndex(input,start,end);
    }
}


/**

 10 80 30 90 40 50 70


 */