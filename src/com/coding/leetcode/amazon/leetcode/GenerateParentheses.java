package com.coding.leetcode.amazon.leetcode;/*
  @created 7/3/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper("",result,n,n);
        return result;
    }


    public void generateParenthesisHelper(String param, List<String> result,
        int leftParam, int rightParam) {
        if(leftParam==0 && rightParam==0){
            result.add(param);
            return;
        }

        if(leftParam>0){
            generateParenthesisHelper(param+"(",result,leftParam-1,rightParam);
        }

        if(leftParam<rightParam){
            generateParenthesisHelper(param+")",result,leftParam,rightParam-1);
        }

    }

}
