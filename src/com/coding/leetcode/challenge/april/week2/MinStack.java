package com.coding.leetcode.challenge.april.week2;/*
  @created 4/10/20
  @Author  Meeravali Shaik
 */

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *  Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2
 *
 *
 */

public class MinStack {

    public static void main(String[] args) {
            Stack stack = new Stack(100);
            stack.push(0);
            stack.push(1);
            stack.push(0);

        System.out.println(stack.top());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }


}

class Stack {

    int[] stack;
    int size ;
    int track;
    java.util.Stack<Integer> minStack = new java.util.Stack<>();

    public Stack(int size) {
        this.stack = new int[size];
        this.size = size;
        this.track = 0;
    }

    public void push(int value) {
        if (track == 0) {
            minStack.push(value);
        } else if (value <= minStack.peek()) {
            minStack.push(value);
        }
        stack[track++] = value;
    }

    public int pop(){
        if(top() == minStack.peek()){
            minStack.pop();
        }
        track--;
        return stack[track];
    }

    public int size(){
        return track;
    }

    public int top(){
        return stack[track-1];
    }

    public int getMin(){
        if(minStack.empty()){
           return Integer.MIN_VALUE;
        }
        return minStack.peek();
    }

}
