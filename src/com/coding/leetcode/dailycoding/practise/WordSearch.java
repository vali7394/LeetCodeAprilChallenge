package com.coding.leetcode.dailycoding.practise;/*
  @created 6/7/20
  @Author ** - Meeravali Shaik
 */

public class WordSearch {

    char[][] board ;

    public  boolean exist(char[][] board, String word) {
        this.board = board;
        for(var i=0; i<board.length;i++){
            for (var j =0 ; j<board[0].length;j++){
                    if(existsHelper(board,word,0,i,j)){
                        return true;
                }
            }

        }
            return false;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

      //  System.out.println(exist(board,"ABCCED"));
    }

    public boolean existsHelper(char[][] board , String word , int currentChar, int i , int j){

        if(currentChar>=word.length()){
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
            || word.charAt(currentChar) != board[i][j]) {
            return false;
        }

        board[i][j] = '#';
        if(word.length()-1==currentChar && word.charAt(currentChar) == board[i][j]){
            return true;
        }
        if(existsHelper(board,word,currentChar+1,i+1,j)){
            return true;
        };
        if(existsHelper(board,word,currentChar+1,i-1,j)){
            return true;
        };
        if(existsHelper(board,word,currentChar+1,i,j+1)){
            return true;
        };
        if(existsHelper(board,word,currentChar+1,i,j-1)){
            return true;
        };
        board[i][j] = word.charAt(currentChar);
        return false;
    }

}


/**
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.


 Constraints:

 board and word consists only of lowercase and uppercase English letters.
 1 <= board.length <= 200
 1 <= board[i].length <= 200
 1 <= word.length <= 10^3
 */