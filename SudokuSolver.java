// Sudoku Solver
//
// Write a program to solve a Sudoku puzzle by filling the empty cells.
//
// Empty cells are indicated by the character '.'.
//
// You may assume that there will be only one unique solution.
import java.util.*;

public class SudokuSolver {
   public void solveSudoku(char[][] board){
      //dfs
      if ((board.length != 9) || (board[0].length != 9)){
         return;
      }
      helpSolveSudoku(board, 0, 0);
   }

   private boolean helpSolveSudoku(char[][] board, int i, int j){
      if (i >= 9){
         return true;
      }

      if (j >= 9){
         return helpSolveSudoku(board, i + 1, 0);
      }

      if (board[i][j] != '.'){
         return helpSolveSudoku(board, i, j + 1);
      }

      for (char c = '1'; c <= '9'; c++){
         board[i][j] = c;
         if (isValid(board, i, j)){
            if (helpSolveSudoku(board, i, j + 1)){
               return true;
            }
         }
      }
      board[i][j] = '.';

      return false;
   }

   private boolean isValid(char[][] board, int x, int y){
      //check row
      if (!isValidArray(board[x])){
         return false;
      }

      //check column
      char[] array = new char[board.length];
      for (int i = 0; i < array.length; i++){
         array[i] = board[i][y];
      }

      if (!isValidArray(array)){
         return false;
      }

      //check sub-square
      int index = 0;
      for (int i = 0; i < 3; i++){
         for (int j = 0; j < 3; j++){
            array[index++] = board[i + 3 * (x / 3)][j + 3 * (y / 3)];
         }
      }

      if (!isValidArray(array)){
         return false;
      }

      return true;
   }

   private boolean isValidArray(char[] array){
      Set<Character> set = new HashSet<>();

      for (char c : array){
         if (c != '.'){
            if (set.contains(c)){
               return false;
            }else{
               set.add(c);
            }
         }
      }
      return true;
   }

   public static void main(String[] args){
       char[][] board = new char[9][9];
       board[0] = "..9748...".toCharArray();
       board[1] = "7........".toCharArray();
       board[2] = ".2.1.9...".toCharArray();
       board[3] = "..7...24.".toCharArray();
       board[4] = ".64.1.59.".toCharArray();
       board[5] = ".98...3..".toCharArray();
       board[6] = "...8.3.2.".toCharArray();
       board[7] = "........6".toCharArray();
       board[8] = "...2759..".toCharArray();

       SudokuSolver s = new SudokuSolver();
       s.solveSudoku(board);
       for(int i = 0; i < 9; i++){
           for(int j = 0; j < 9; j++){
               System.out.print(board[i][j]);
           }
           System.out.println();
       }
   }
}
