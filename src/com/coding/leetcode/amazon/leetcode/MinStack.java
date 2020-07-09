package com.coding.leetcode.amazon.leetcode;/*
  @created 7/7/20
  @Author ** - Meeravali Shaik
 */

public class MinStack {
    private int top;
    private int minTop;
    private int[] array;
    private int[] minArray;

    MinStack(int size) {
        this.top = -1;
        this.array = new int[size];
        this.minTop = -1;
        this.minArray = new int[size];
    }

    public void push(int value){
        top++;
        array[top] = value;
        if(minTop==-1) {
            minTop++;
            minArray[minTop] = value;
        } else {
            int temp = minArray[minTop];
            minTop++;
            if( temp < value){
                minArray[minTop] = temp;
            }else {
                minArray[minTop] = value;
            }
        }
    }

    public int pop(){
        int temp = array[top];
        top--;
        minTop--;
        return temp;
    }

    public int top(){
        return array[top];
    }
    public int getMin(){
        return minArray[minTop];
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack(100);
        stack.push(10);
        stack.push(15);
        stack.push(5);
        stack.push(30);
        stack.push(5);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }

}
