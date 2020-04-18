package com.coding.leetcode.challenge.april.week3;/*
  @created 4/16/20
  @Author  Meeravali Shaik
 */

import java.util.Stack;

/**
 *
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 *
 *
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        String input = "";
        /*  System.out.println(isValid(input));
          System.out.println(isValid("()"));
          System.out.println(isValid("(*)"));
        System.out.println(isValid("(*))"));
        System.out.println(isValid(")(")); */
        System.out.println(isValid("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }

    private static boolean isValid(String input){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        for(int i=0 ; i<input.length();i++){
            if('('==input.charAt(i)){
                stack.push(i);
            } else if(')'==input.charAt(i)){
                if(!stack.isEmpty()) {
                    stack.pop();
                }else if (!integerStack.isEmpty()){
                   integerStack.pop();
                } else {
                    return false;
                }
            } else {
                integerStack.push(i);
            }
        }

        while (!stack.isEmpty() && !integerStack.isEmpty()){
            if(integerStack.peek() > stack.peek()) {
                stack.pop();
                integerStack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();

    }

    private static boolean isValidParString(String input){
        String[] chars = input.split("");
        Stack<String> stackLeft = new Stack<>();
        Stack<String> stackRight = new Stack<>();
        int countOfSpeciChars = 0;

        for(String s : chars){
            if("(".equals(s)){
                stackLeft.push(s);
            } else if(")".equals(s)){
                stackRight.push(s);
            }
            else {
                countOfSpeciChars++;
            }
        }

        while (!stackLeft.isEmpty() && !stackRight.isEmpty()){
            stackLeft.pop();
            stackRight.pop();
        }

        while (countOfSpeciChars>0 && !stackLeft.isEmpty()){
            stackLeft.pop();
            countOfSpeciChars--;
        }

        return stackLeft.isEmpty() && stackRight.isEmpty();

    }




}
