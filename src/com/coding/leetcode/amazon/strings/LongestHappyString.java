package com.coding.leetcode.amazon.strings;/*
  @created 6/25/20
  @Author ** - Meeravali Shaik
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestHappyString {

    public static String longestDiverseString(int a, int b, int c) {

        StringBuilder builder = new StringBuilder();
        Map<Character,Integer> freqMap = new HashMap<>(3);
        freqMap.put('a',a);
        freqMap.put('b',b);
        freqMap.put('c',c);
        PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.comparingInt(freqMap::get).reversed());
        queue.add('a');
        queue.add('b');
        queue.add('c');
        while (queue.size()>1){
            Character letter = queue.poll();
            Integer size = freqMap.get(letter);
            if(size<2){
                builder.append(letter);
            }else {
                builder.append(letter+""+letter);
                freqMap.put(letter,letter-2);
                queue.offer(letter);
            }
        }

        return builder.toString();

    }


    private static StringBuilder appendString(StringBuilder builder, String letter){
        return builder.append(letter);
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1,1,7));
    }

}


/**

 A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

 Given three integers a, b and c, return any string s, which satisfies following conditions:

 s is happy and longest possible.
 s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
 s will only contain 'a', 'b' and 'c' letters.
 If there is no such string s return the empty string "".



 Example 1:

 Input: a = 1, b = 1, c = 7
 Output: "ccaccbcc"
 Explanation: "ccbccacc" would also be a correct answer.
 Example 2:

 Input: a = 2, b = 2, c = 1
 Output: "aabbc"
 Example 3:

 Input: a = 7, b = 1, c = 0
 Output: "aabaa"
 Explanation: It's the only correct answer in this case.

 **/