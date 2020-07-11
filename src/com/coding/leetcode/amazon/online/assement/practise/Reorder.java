package com.coding.leetcode.amazon.online.assement.practise;/*
  @created 7/10/20
  @Author b008245 - Meeravali Shaik 
 */
import java.util.*;
public class Reorder {


    public String[] reorderLogFiles(String[] logs) {

        if(logs==null || logs.length==0){
            return logs;
        }

        List<String> letterLogs  = new ArrayList<>();
        List<String> digitLogs  = new ArrayList<>();

        for(String log : logs){
            String[] words = log.split(" ",2);
            char lastLetter = words[1].charAt(words[1].length()-1);
            if(Character.isDigit(lastLetter)){
                digitLogs.add(log);
            }else{
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs, ((s1,s2)->{
            String[] logOne = s1.split(" ",2);
            String[] logTwo = s2.split(" ",2);

            if(logOne[1].compareTo(logTwo[1])==0){
                return logOne[0].compareTo(logTwo[0]);
            }
            return logOne[1].compareTo(logTwo[1]);
        }));

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[letterLogs.size()]);
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
 **/