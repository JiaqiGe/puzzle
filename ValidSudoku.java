// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
import java.util.*;

public class ValidSudoku {
   public boolean isValidSudoku(char[][] board){
      //edge case

      if ((board.length != 9) || (board[0].length != 9)){
         return false;
      }

      //check row
      for (int i = 0; i < 9; i++){
         if (!isValidRow(board, i)){
            return false;
         }
      }

      //check column
      for (int j = 0; j < 9; j++){
         if (!isValidColumn(board, j)){

            return false;
         }
      }

      //check sub-square
      int[] rows = new int[]{ 0, 3, 6 };
      int[] cols = new int[]{ 0, 3, 6 };

      for (int i = 0; i < rows.length; i++){
         for (int j = 0; j < cols.length; j++){
             if(!isValidSubSquare(board,rows[i], rows[j])){

                 return false;
             }
         }
      }

      return true;
   }

   private boolean isValidRow(char[][] board, int row){
       return isValidArray(board[row]);
   }

   private boolean isValidColumn(char[][] board, int col){
       char[] array = new char[board.length];
       for(int i = 0; i < array.length; i++){
           array[i] = board[i][col];
       }

       return isValidArray(array);
   }

   private boolean isValidSubSquare(char[][] board, int x, int y){
       char[] array = new char[9];
       int index = 0;

       for(int i = x; i < x + 3; i++){
           for(int j = y; j < y + 3; j++){
               array[index++] = board[i][j];
           }
       }
       return isValidArray(array);
   }


   private boolean isValidArray(char[] array){
       Set<Character> set = new HashSet<Character>();
       for(char c : array){
           if(c == '.'){
               continue;
           }

           if(c <= '9' && c >= '1'){
               if(set.contains(c)){
                   return false;
               }else{
                   set.add(c);
               }
           }else{
               return false;
           }
       }
       return true;
   }

   public static void main(String[] args){
       char[][] board = new char[9][9];
       board[0] = ".........".toCharArray();
       board[1] = "......3..".toCharArray();
       board[2] = "...18....".toCharArray();
       board[3] = "...7.....".toCharArray();
       board[4] = "....1.97.".toCharArray();
       board[5] = ".........".toCharArray();
       board[6] = "...36.1..".toCharArray();
       board[7] = ".........".toCharArray();
       board[8] = ".......2.".toCharArray();

       ValidSudoku v = new ValidSudoku();
       System.out.println(v.isValidSudoku(board));
   }

}
