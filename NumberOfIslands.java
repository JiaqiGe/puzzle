// Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
//
// Input : mat[][] = {{1, 1, 0, 0, 0},
//                    {0, 1, 0, 0, 1},
//                    {1, 0, 0, 1, 1},
//                    {0, 0, 0, 0, 0},
//                    {1, 0, 1, 0, 1}
// Output : 5

public class NumberOfIslands{
  public int numberOfIslands(int[][] board){
    if(board.length == 0 || board[0].length == 0){
      return 0;
    }

    int rows = board.length;
    int cols = board[0].length;

    boolean[][] isVisited = new boolean[rows][cols];
    int count = 0;

    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
        if(board[i][j] == 1 && !isVisited[i][j]){
          dfs(board, i, j, isVisited);
          count ++;
        }
      }
    }

    return count;
  }

  private void dfs(int[][] board, int i, int j, boolean[][] isVisited){
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
      return;
    }

    if(board[i][j] == 0 || isVisited[i][j]){
      return;
    }

    isVisited[i][j] = true;
    dfs(board, i+1, j, isVisited);
    dfs(board, i-1, j, isVisited);
    dfs(board, i, j+1, isVisited);
    dfs(board, i, j-1, isVisited);

    return;
  }

  public static void main(String[] args){
    NumberOfIslands n = new NumberOfIslands();
    int[][] board = new int[5][5];
    board[0] = new int[]{1, 1, 0, 0, 0};
    board[1] = new int[]{0, 1, 0, 0, 1};
    board[2] = new int[]{1, 0, 0, 1, 1};
    board[3] = new int[]{0, 0, 0, 0, 0};
    board[4] = new int[]{1, 0, 1, 0, 1};
    System.out.print(n.numberOfIslands(board));
  }
}
