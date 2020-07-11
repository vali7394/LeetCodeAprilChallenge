package com.coding.leetcode.amazon.online.assement.practise;/*
  @created 7/10/20
  @Author b008245 - Meeravali Shaik 
 */
import java.util.*;
import java.util.stream.Collectors;

public class TopKFreq {

    public List<String> findTopGreqKWords(String[] keyword, String[] reviews, int k){

        if(reviews==null || keyword==null){
            return Collections.emptyList();
        }

        var freqTracker = new HashMap<String,Integer>();
        var keyWords = Arrays.stream(keyword).map(String::toLowerCase).collect(Collectors.toSet());
        for(String review : reviews){
            Set<String> words = Arrays.stream(review.split("\\W")).map(String::toLowerCase)
                .collect(Collectors.toSet());
            for (String word : words) {
                if (keyWords.contains(word)) {
                    if (freqTracker.containsKey(word)) {
                        freqTracker.put(word, freqTracker.get(word) + 1);
                    } else {
                        freqTracker.put(word, 1);
                    }
                }
            }
        }

        var queue = new PriorityQueue<String>((s1,s2)->{
            if(freqTracker.get(s1).compareTo(freqTracker.get(s2))==0){
                return s2.compareTo(s1);
            }
            return freqTracker.get(s1).compareTo(freqTracker.get(s2));
        });

        for(String word : freqTracker.keySet()){
            queue.offer(word);
            if(queue.size() > k){
                queue.poll();
            }
        }

        var topKFeqWords  = new ArrayList<String>();

        while(!queue.isEmpty()){
            topKFeqWords.add(queue.poll());
        }

        Collections.reverse(topKFeqWords);

        return topKFeqWords;
    }

    public static void main(String[] args) {
        TopKFreq freq = new TopKFreq();
        String[] keyWords = new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = new String[]{"I love anacell Best services; Best services provided by anacell",
            "betacellular has great services",
            "deltacellular provides much better services than betacellular",
            "cetracular is worse than anacell",
            "Betacellular is better than deltacellular.",};
        System.out.println(freq.findTopGreqKWords(keyWords,reviews,2));
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