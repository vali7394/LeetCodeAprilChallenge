package com.coding.leetcode.amazon.leetcode;/*
  @created 7/9/20
  @Author b008245 - Meeravali Shaik 
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> wordQueue = new LinkedList<>();

        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordQueue.offer(beginWord);
        int level = 1;

        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            for (int i = 0; i < size; i++) {
                String word = wordQueue.poll();
                if (word.equals(endWord)) {
                    return level + 1;
                }
                char[] letters = word.toCharArray();
                for (int j = 0; j < letters.length; j++) {
                    char originalChar = letters[j];

                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        if (letter == originalChar) {
                            continue;
                        }
                        letters[j] = letter;
                        String dictWord = String.valueOf(letters);
                        if(dictWord.equals(endWord)){
                            return level+1;
                        }
                        if (wordSet.contains(dictWord)) {
                            wordQueue.offer(dictWord);
                            wordSet.remove(dictWord);
                        }
                    }
                    letters[j] = originalChar;
                }

            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        numTeams(new int[]{13, 3, 4, 10, 7, 8});
    }

    public static int numTeams(int[] arr) {
        int count = 0;
        int len = arr.length;
        for (int j = 0; j < len; j++) {
            int leftSmaller = 0, rightLarger = 0;
            int leftLarger = 0, rightSmaller = 0;
            for (int i = 0; i < j; i++) {
                if (arr[i] < arr[j]) {
                    leftSmaller++;
                } else if (arr[i] > arr[j]) {
                    leftLarger++;
                }
            }
            for (int k = j + 1; k < len; k++) {
                if (arr[j] < arr[k]) {
                    rightLarger++;
                } else if (arr[j] > arr[k]) {
                    rightSmaller++;
                }
            }
            count += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }

        return count;
    }


}

/**
 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: 0

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 **/