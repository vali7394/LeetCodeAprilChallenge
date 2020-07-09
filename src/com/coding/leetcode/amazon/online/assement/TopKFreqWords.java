package com.coding.leetcode.amazon.online.assement;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFreqWords {


    public String[] findTopKFreqWords(String[] keywords , String[] reviews , int k){

        Set<String> keyWordSet = Arrays.stream(keywords).map(String::toLowerCase).collect(Collectors.toSet());

        Map<String, Long> map = Arrays.stream(reviews).map(review -> review.split("\\W+"))
            .flatMap(words -> Arrays.stream(words)).map(String::toLowerCase)
            .filter(word -> keyWordSet.contains(word))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var queue = new PriorityQueue<String>((word1,word2)->{
            //When the count of the occurances is same then sort by lexo
            if(map.get(word1).compareTo(map.get(word2))==0){
                return word1.compareTo(word2);
            }


            return map.get(word1).compareTo(map.get(word2));
        });

        for(var word : map.keySet()){
            queue.offer(word);
            if(queue.size()>k){
                queue.poll();
            }
        }

        String[] result = new String[k];
        var count= k-1;
        while(!queue.isEmpty()) {
            result[count]=queue.poll();
            count--;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] keys = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = {"I love anacell Best services; Best services provided by anacell",
            "betacellular has great services",
            "deltacellular provides much better services than betacellular",
            "cetracular is worse than anacell",
            "Betacellular is better than deltacellular."};
        TopKFreqWords freqWords =  new TopKFreqWords();
        for(String word : freqWords.findTopKFreqWords(keys,reviews,2)){
            System.out.println(word);
        }
    }

}


/**
 Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.

 The comparison of strings is case-insensitive.
 Multiple occurances of a keyword in a review should be considred as a single mention.
 If keywords are mentioned an equal number of times in reviews, sort alphabetically.

 Example 1:

 Input:
 k = 2
 keywords = ["anacell", "cetracular", "betacellular"]
 reviews = [
 "Anacell provides the best services in the city",
 "betacellular has awesome services",
 "Best services provided by anacell, everyone should use anacell",
 ]

 Output:
 ["anacell", "betacellular"]

 Explanation:
 "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
 Example 2:

 Input:
 k = 2
 keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
 reviews = [
 "I love anacell Best services; Best services provided by anacell",
 "betacellular has great services",
 "deltacellular provides much better services than betacellular",
 "cetracular is worse than anacell",
 "Betacellular is better than deltacellular.",
 ]

 Output:
 ["betacellular", "anacell"]

 Explanation:
 "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.
 **/