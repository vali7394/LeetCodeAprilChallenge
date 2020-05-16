package com.coding.leetcode.dailycoding.practise;/*
  @created 5/14/20
  @Author b008245 - Meeravali Shaik 
 */

public class TrieDataStructDemo {
    TrieNode root;
    TrieDataStructDemo(){
        root = new TrieNode();
    }


    public void insertIntoTrie(String word){
        insert(root,0,word.length(),word);
    }

    public boolean deleteFromTrie(String word){
        if(searchString(word)){
            deleteTrie(root,0,word.length(),word);
            return true;
        }
        return false;
    }

    public void insert(TrieNode node,int position,int length,String word){
        char data = word.charAt(position);
        if(node.childNodes[data-'a']!=null){
            TrieNode trieNode = node.childNodes[data-'a'];
            if(position==length-1){
                trieNode.wordEnd += 1;
                return;
            } else {
                insert(trieNode,position+1,length,word);
            }
        } else {
            TrieNode trieNode = new TrieNode();
            trieNode.data = data;
            node.childNodes[data-'a'] = trieNode;
            if(position==length-1){
                trieNode.wordEnd += 1;
                return;
            } else {
                trieNode.wordEnd = 0;
                insert(trieNode,position+1,length,word);
            }
        }
    }

    public boolean searchString(String word){
        return search(root.childNodes[word.charAt(0)-'a'],0,word.length(),word);
    }

    public boolean search(TrieNode trieNode, int position, int length, String word){
        if(trieNode==null){
            return false;
        }
        if(position==length-1 && trieNode.wordEnd==0){
            return false;
        }
        if(position==length-1 && trieNode.data==word.charAt(position)){
            return true;
        }

        if(trieNode.data==word.charAt(position)){
            TrieNode node = trieNode.childNodes[word.charAt(position+1)-'a'];
            if(node!=null){
                return search(node,position+1,length,word);
            } else {
                return false;
            }
        }

        return false;
    }


    public void deleteTrie(TrieNode node, int position, int length, String word) {
        if (position==length){
            node.wordEnd-=1;
            return ;
        }
        TrieNode trieNode = node.childNodes[word.charAt(position)-'a'];
        deleteTrie(trieNode,position+1,length,word);
    }

    public static void main(String[] args) {
        TrieDataStructDemo dataStructDemo = new TrieDataStructDemo();
        dataStructDemo.insertIntoTrie("abc");
        dataStructDemo.insertIntoTrie("abe");
        dataStructDemo.insertIntoTrie("ab");
        dataStructDemo.insertIntoTrie("bca");
        dataStructDemo.insertIntoTrie("zeba");
        System.out.println(dataStructDemo.searchString("abc"));
        System.out.println(dataStructDemo.searchString("zeba"));
        dataStructDemo.deleteFromTrie("zeba");
        System.out.println(dataStructDemo.searchString("zeba"));
        System.out.println(dataStructDemo.searchString("ab"));
    }


}


class TrieNode {

    char data;
    TrieNode[] childNodes = new TrieNode[26];
    int wordEnd;

    TrieNode(){

    }
}