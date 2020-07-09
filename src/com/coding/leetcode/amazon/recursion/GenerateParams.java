package com.coding.leetcode.amazon.recursion;/*
  @created 7/4/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParams {

    public static void main(String[] args) {
        GenerateParams params = new GenerateParams();
        params.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n,3,3,"",result);
        System.out.println(result);
        return result;
    }

    private void generateParenthesisHelper(int n, int left,int right ,String param, List<String> generateParam) {
        if(left==0 && right==0){
            generateParam.add(param);
            return;
        }

        if(left > 0){
            generateParenthesisHelper(n,left-1,right,param+"(",generateParam);
        }

        if(left<right){
            generateParenthesisHelper(n,left,right-1,param+")",generateParam);
        }

    }
}
