package com.coding.leetcode.challenge.May.week2;/*
  @created 5/14/20
  @Author - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for(int i=0; i<word.length();i++){
            TrieNode node = currentNode.childNodes[word.charAt(i)-'a'];
            if(node!=null){
                if(i==word.length()-1){
                    node.wordEnd+=1;
                }
                currentNode = node;
            } else {
                TrieNode newNode = new TrieNode();
                newNode.data = word.charAt(i);
                if(i==word.length()-1){
                    newNode.wordEnd+=1;
                }
                currentNode.childNodes[word.charAt(i)-'a'] = newNode;
                currentNode = newNode;
            }
        }
    }

    public boolean search(String word) {
        TrieNode currentNode = root;

        for(int i=0; i<word.length();i++){
            TrieNode node = currentNode.childNodes[word.charAt(i)-'a'];
            if(node==null)return false;
            if(node.data!=word.charAt(i)) return false;
            if(i==word.length()-1&&node.wordEnd>0) return true;
            if(i==word.length()-1&&node.wordEnd==0) return false;
            currentNode = node;
            }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for(int i=0; i<prefix.length();i++){
            TrieNode node = currentNode.childNodes[prefix.charAt(i)-'a'];
            if(node==null)return false;
            if(node.data!=prefix.charAt(i)) return false;
            if(i==prefix.length()-1 && node!=null){
                return true;
            }
            currentNode = node;
        }
        return false;
    }

    /*public List<String> autoCompleteTrie(String prefix, int limit) {

        TrieNode currentNode = root;
        List<String> suggestions = new ArrayList<>();
        suggestions = autoCompleteSugg(currentNode, prefix, suggestions, limit);
        return suggestions;
    }*/

    /*public List<String> autoCompleteSugg(TrieNode node , String prefix, List<String> suggestions , int limit){

        if(node == null || suggestions.size()==limit){
            return suggestions;
        }
        if(node.wordEnd>0){
            suggestions.add(prefix+node.data);
        }
        for(int i=0 ; i<26 ;i++){
            TrieNode trieNode = node.childNodes[i];
            if(trieNode!=null){
                if(trieNode.wordEnd>0){
                    suggestions.add(prefix+trieNode.data);
                }
                autoCompleteSugg(trieNode,prefix+trieNode.data,suggestions,limit);
            }
        }
        return suggestions;
    }*/

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abe");
        trie.insert("zera");
        trie.insert("ab");
       // System.out.println(trie.autoCompleteTrie("a",10));
    }



}

class TrieNode {

    char data;
    TrieNode[] childNodes = new TrieNode[26];
    int wordEnd;

    public TrieNode() {
    }

    public TrieNode(char data) {
        this.data = data;
    }
}

/**

 Implement a trie with insert, search, and startsWith methods.

 Example:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true
 Note:

 You may assume that all inputs are consist of lowercase letters a-z.
 All inputs are guaranteed to be non-empty strings.



 */