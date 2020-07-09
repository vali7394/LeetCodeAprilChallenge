package com.coding.leetcode.amazon;/*
  @created 6/17/20
  @Author ** - Meeravali Shaik
 */

import java.util.Stack;

public class BasicCalculatorII {


    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        s=s.replaceAll("\\s+","");
        for(var i=0 ;i<s.length();i++){

            if(s.charAt(i)=='*' || s.charAt(i)=='/'){
                int leftDigit = Integer.parseInt(stack.pop());
                int rightDigit =  Character.getNumericValue(s.charAt(i+1));
                if(s.charAt(i)=='*'){
                    stack.push(""+leftDigit*rightDigit);
                }
                else {
                    stack.push(""+leftDigit/rightDigit);
                }
                i++;
            }else {
                stack.push(""+s.charAt(i));
            }

        }

        int sum = 0;

        while (!stack.isEmpty()){

            int k=0;
            int left = 0;
            int right = 0;
            String operator="";
            while (!stack.isEmpty() && k<3){
                if(k==0){
                    left = Integer.parseInt(stack.pop());
                }
                if(k==1){
                    operator = stack.pop();
                    if(!operator.equals("+") && !operator.equals("-")){
                        return Integer.parseInt(s);
                    }
                }
                if(k==2){
                    right = Integer.parseInt(stack.pop());
                }
                k++;
            }
            if("+".equals(operator)){
                sum+=(left+right);
            }else {
                sum+=(left-right);
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        BasicCalculatorII calculatorII = new BasicCalculatorII();
        String input = " 3/2 ";
        System.out.println(calculatorII.calculate(input.replaceAll("\\s+","")));
    }
}


/**
 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 Example 1:

 Input: "3+2*2"
 Output: 7
 Example 2:

 Input: " 3/2 "
 Output: 1
 Example 3:

 Input: " 3+5 / 2 "
 Output: 5
 Note:

 You may assume that the given expression is always valid.
 Do not use the eval built-in library function.
 */