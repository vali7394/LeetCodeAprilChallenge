package com.coding.leetcode.amazon.online.assement.practise;/*
  @created 7/10/20
  @Author b008245 - Meeravali Shaik 
 */

import java.util.*;

public class SearchSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if(products==null || searchWord==null){
            return Collections.emptyList();
        }

        var prefix = new StringBuilder();
        var productSuggestions = new ArrayList<List<String>>();
        Arrays.sort(products);
        for(int i=0; i<searchWord.length();i++){
            prefix.append(searchWord.charAt(i));
            int index = findTheIndexOfPrefix(products,prefix.toString());
            var suggestions = new ArrayList<String>();
            if(products.length-index<3){
                for(int j=index; j<products.length; j++){
                    if(products[j].startsWith(prefix.toString()))
                        suggestions.add(products[j]);
                }
            }
            else {
                var queue = new PriorityQueue<String>((s1,s2)->s2.compareTo(s1));

                for(int j=index; j<products.length; j++){
                    if(products[j].startsWith(prefix.toString())){
                        queue.offer(products[j]);
                        if(queue.size()>3){
                            queue.poll();
                        }
                    }
                }
                while(!queue.isEmpty()){
                    suggestions.add(queue.poll());
                }
                Collections.reverse(suggestions);
            }
            productSuggestions.add(suggestions);
        }
        return productSuggestions;

    }


    private int findTheIndexOfPrefix(String[] products, String prefix){
        int start=0; int end=products.length-1;

        while(start<=end){

            int mid = (start)+(end-start)/2;
            if(products[mid].startsWith(prefix)){
                end = mid-1;
            } else if(products[mid].compareTo(prefix)>0){
                end = mid-1;
            }else {
                start = mid+1;
            }

        }
        return start;
    }

}


/**
 Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed.
 Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

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
 **/