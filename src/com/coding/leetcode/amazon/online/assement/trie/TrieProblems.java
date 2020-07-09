package com.coding.leetcode.amazon.online.assement.trie;/*
  @created 7/9/20
  @Author ** - Meeravali Shaik
 */

public class TrieProblems {
    TrieNode root ;

    TrieProblems(){
        root = new TrieNode();
    }

    private void insert(String word){
        insertHelper(root,0,word);
    }

    private void insertHelper(TrieNode node, int position, String word){

        char letter = word.charAt(position);

        if(node.childs[letter-'a']!=null){

            TrieNode child = node.childs[letter-'a'];

            if(position==word.length()-1){
                child.wordEnd+=1;
                return;
            }else {
                insertHelper(child,position+1,word);
            }


        } else {
            TrieNode child = new TrieNode();
            child.val = letter;
            node.childs[letter-'a'] = child;
            if(position==word.length()-1){
                child.wordEnd+=1;
                return;
            } else {
                insertHelper(child,position+1,word);
            }

        }

    }

    private boolean searchWord(String word){
        return searchHelper(root,0,word);
    }

    private boolean searchHelper(TrieNode node, int position, String word){
        char letter = word.charAt(position);
        TrieNode child = node.childs[letter-'a'];
        if(child==null){
            return false;
        }

        if(position==word.length()-1 && child.wordEnd==0){
            return false;
        }

        if(position==word.length()-1 && child.wordEnd==1){
            return true;
        }

        return searchHelper(child,position+1,word);
    }

    public boolean delete(String word){
            if(word.length()==0 || word==null){
                return false;
            }
            return deleteHelper(root,0,word);
    }
    private boolean deleteHelper(TrieNode trieNode, int pos, String word){
        char letter = word.charAt(pos);
        TrieNode child = trieNode.childs[letter-'a'];

        if(child!=null){

            if(pos==word.length()-1 && child.wordEnd==0){
                return false;
            }

            if(pos==word.length()-1){
                child.wordEnd-=1;
                return true;
            }
            return deleteHelper(child,pos+1,word);
        }
        return false;
    }

    public boolean specialSearch(String word){
        return regExSearch(root,0,word);
    }

    public boolean regExSearch(TrieNode node, int pos,String word){
        if(node==null){
            return true;
        }
        char letter = word.charAt(pos);
        if(letter=='.' && pos==word.length()-1){
            for(TrieNode child : node.childs){
                if(child!=null && child.wordEnd>0){
                    return true;
                }
            }
            return false;
        }
        if(letter=='.'){
            for(TrieNode child : node.childs){
                if(child!=null) return regExSearch(child,pos+1,word);
            }
        }
        TrieNode child = node.childs[letter-'a'];
        if(child!=null){
            if(pos==word.length()-1&child.wordEnd==0){
                return false;
            }

            if(pos==word.length()-1&child.wordEnd>0){
                return true;
            }
            return regExSearch(child,pos+1,word);
        }
        return false;
    }

    public boolean prefixSearch(TrieNode node,String prefix,int pos){
        char letter = prefix.charAt(pos);
        TrieNode child = node.childs[letter-'a'];

        if(child!=null){

            if(pos==prefix.length()-1){
                return true;
            }
            return prefixSearch(child,prefix,pos+1);
        }
        return false;
    }
    public static void main(String[] args) {
        TrieProblems problems = new TrieProblems();
        problems.insert("abc");
        problems.insert("aba");
        problems.insert("bab");
        problems.insert("acb");
        System.out.println(problems.specialSearch("ab.."));
         }
}


class TrieNode {

    char val;
    TrieNode[] childs = new TrieNode[26];
    int wordEnd;

    public TrieNode() {
    }



}