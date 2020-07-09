package com.coding.leetcode.amazon;/*
  @created 6/16/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> queue = new PriorityQueue<>( String::compareTo);
        List<List<String>> response = new ArrayList<>();
        for(int i=1;i<=searchWord.length();i++){
            String search = searchWord.substring(0,i);
            for(String product : products){
                if(product.startsWith(search)){
                    queue.offer(product);
                }
            }
                int k=0;
            List<String> words = new ArrayList<>();
            while (!queue.isEmpty()&&k<3){
                words.add(queue.poll());
                k++;
            }
            response.add(words);
            queue.clear();
        }
        return response;
    }
}


/**

 Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

 Return list of lists of the suggested products after each character of searchWord is typed.



 Example 1:

 Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 Output: [
 ["mobile","moneypot","monitor"],
 ["mobile","moneypot","monitor"],
 ["mouse","mousepad"],
 ["mouse","mousepad"],
 ["mouse","mousepad"]
 ]
 Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 Example 2:

 Input: products = ["havana"], searchWord = "havana"
 Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 Example 3:

 Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 Example 4:

 Input: products = ["havana"], searchWord = "tatiana"
 Output: [[],[],[],[],[],[],[]]


 Constraints:

 1 <= products.length <= 1000
 There are no repeated elements in products.
 1 <= Σ products[i].length <= 2 * 10^4
 All characters of products[i] are lower-case English letters.
 1 <= searchWord.length <= 1000
 All characters of searchWord are lower-case English letters.

 */