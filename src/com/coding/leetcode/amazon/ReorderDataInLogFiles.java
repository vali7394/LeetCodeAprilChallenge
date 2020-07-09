package com.coding.leetcode.amazon;/*
  @created 6/16/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for(String log : logs){
            if(Character.isDigit(log.charAt(log.length()-1))){
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        Collections.sort(letterLogs,(s1,s2)->{
            String[] s1List = s1.split(" ",2);
            String[] s2List = s2.split(" ",2);
            if(s1List[1].compareTo(s2List[1])==0){
                return s1List[0].compareTo(s2List[0]);
            } else {
                return s1List[1].compareTo(s2List[1]);
            }
        });
        letterLogs.addAll(digitLogs);
        String[] result = new String[letterLogs.size()];
        return letterLogs.toArray(result);
    }

    public static void main(String[] args) {
        ReorderDataInLogFiles logFiles = new ReorderDataInLogFiles();
        logFiles.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
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


 Constraints:

 0 <= logs.length <= 100
 3 <= logs[i].length <= 100
 logs[i] is guaranteed to have an identifier, and a word after the identifier.




 */