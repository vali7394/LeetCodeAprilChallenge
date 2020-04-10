package com.coding.leetcode.challenge.april.week2;/*
  @created 4/9/20
  @Author Meeravali Shaik
 */

/**
 *  Backspace String Compare
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        System.out.println(getBackspacedString(S).equals(getBackspacedString(T)));

        S = "ab##";T = "c#d#";
        System.out.println(getBackspacedString(S).equals(getBackspacedString(T)));
        S = "a##c"; T = "#a#c";
        System.out.println(getBackspacedString(S).equals(getBackspacedString(T)));
        S = "a#c"; T = "b";
        System.out.println(getBackspacedString(S).equals(getBackspacedString(T)));

    }

    private static String getBackspacedString(String input) {
        StringBuffer stringBuffer = new StringBuffer(input.length());
        int i = input.length() - 1;
        int track = 0;
        while (i >= 0) {
            if('#'==input.charAt(i)){
                track++;
            } else if(track == 0) {
                stringBuffer.append(input.charAt(i));
            } else {
                track --;
            }
            i--;
        }
        return stringBuffer.toString();
    }


}
