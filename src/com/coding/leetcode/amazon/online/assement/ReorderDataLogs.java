package com.coding.leetcode.amazon.online.assement;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */

import java.util.*;

public class ReorderDataLogs {

    public String[] reorderLogFiles(String[] logs) {

        List<String> digitLogs = new ArrayList<>();
        var queue = new PriorityQueue<String>((s1,s2)->{
            String[] log1 = s1.split(" ",2);
            String[] log2 = s2.split(" ",2);
            if(log1[1].compareTo(log2[1])==0){
                return log1[0].compareTo(log2[0]);
            }
            return log1[1].compareTo(log2[1]);

        });
        for(String log : logs){
            if(Character.isDigit(log.charAt(log.length()-1))){
                digitLogs.add(log);
            } else {
                queue.offer(log);
            }
        }

        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll());
        };

        result.addAll(digitLogs);

        return result.toArray(new String[result.size()]);

    }
}


/**
 You have an array of logs.  Each log is a space delimited string of words.

 For each log, the first word in each log is an alphanumeric identifier.  Then, either:

 Each word after the identifier will consist only of lowercase letters, or;
 Each word after the identifier will consist only of digits.
 We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

 Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

 Return the final order of the logs.



 Example 1:

 Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 **/