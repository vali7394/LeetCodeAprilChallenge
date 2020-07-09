package com.coding.leetcode.amazon.online.assement;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */

import java.util.*;

public class SearchSuggestions {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if(products==null || products.length==0){
            return Collections.emptyList();
        }
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<searchWord.length();i++){

            List<String> suggestions = new ArrayList();
            sb.append(searchWord.charAt(i));
            int index = findTheFirstOccuranceOfPrefix(products,sb.toString());
            if(products.length-index < 3){
                int count = index;
                while(count<products.length){
                    if(products[count].startsWith(sb.toString())){
                        suggestions.add(products[count]);
                        count++;
                    }else {
                        break;
                    }
                }
            } else {
                int count=0;
                while(count<3){
                    if(products[index].startsWith(sb.toString())){
                        suggestions.add(products[index]);
                        index++;
                        count++;
                    }else{
                        break;
                    }
                }
            }
            result.add(suggestions);
        }

        return result;
    }

    private int findTheFirstOccuranceOfPrefix(String[] products, String prefix){
        var low = 0;
        var high = products.length-1;

        while(low<=high) {
            int mid = low+(high-low)/2;
            if(products[mid].startsWith(prefix)) {
                high = mid-1;
            }else if(products[mid].compareTo(prefix)>0){
                high = mid-1;
            }else {
                low = mid+1;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        SearchSuggestions suggestions = new SearchSuggestions();
        System.out.println(suggestions.suggestedProducts(products,"mouse"));
    }

}

/**

 Given an array of strings products and a string searchWord.
 We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products
 should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

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






 */
