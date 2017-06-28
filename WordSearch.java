// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// For example,
// Given board =
//
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.


public class WordSearch{
  public boolean exist(char[][] board, String word){
    if(board.length == 0 || board[0].length == 0){
      return false;
    }

    if(word.isEmpty()){
      return true;
    }

    //dfs
    int rows = board.length;
    int cols = board[0].length;


    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
        if(board[i][j] == word.charAt(0)){
          boolean[][] isVisited = new boolean[rows][cols];
          boolean isFound = search(board, i, j, word, isVisited);
          if(isFound){
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean search(char[][] board, int i, int j, String word, boolean[][] isVisited){
    //recursion dfs

    //base
    if(word.isEmpty()){
      return true;
    }

    if(i < 0 || i >= board.length || j < 0|| j >= board[0].length ){
      return false;
    }

    if(isVisited[i][j]){
      return false;
    }

    if(board[i][j] != word.charAt(0)){
      return false;
    }

    isVisited[i][j] = true;

    boolean b1 = search(board, i, j+1, word.substring(1), isVisited);
    boolean b2 = search(board, i, j-1, word.substring(1), isVisited);
    boolean b3 = search(board, i+1, j, word.substring(1), isVisited);
    boolean b4 = search(board, i-1, j, word.substring(1), isVisited);

    return b1 || b2 || b3 || b4;
  }

  public static void main(String[] args){
    char[][] board = new char[3][4];

    board[0] = new char[]{'A','B','C','E'};
    board[1] = new char[]{'S','F','C','S'};
    board[2] = new char[]{'A','D','E','E'};

    WordSearch w = new WordSearch();
    System.out.println(w.exist(board, "ABCB"));
  }
}
