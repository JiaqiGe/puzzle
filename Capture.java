// 围棋判断一个子被capture与否，被capture的定义就是这子或这子属于的整块同色子区域被另外颜色子包围。
//    (解法也很简单， dfs。 每次recusive call返回是否被capture, 遇到异色子或者出界都是true, 遇到同色子就recursively去call它)
// (那假设只有同色的子（没有对手的子），也算是被capture么？（这个点很好！！  可以当作edge case处理单独处理。）

// board:
//    '0': empty
//    'b': black
//    'w': white

public class Capture {
    public boolean isCaptured(char[][] board, int x, int y){
        if ((board.length == 0) || (board[0].length == 0)){
            return false;
        }

        // dfs
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        return dfs(board, x, y, board[x][y], isVisited);
    }

    private boolean dfs(char[][] board, int x, int y, char c, boolean[][] isVisited){
      // base

      if(board[x][y] == '0'){
        // at an empty point
        return false;
      }

      if(board[x][y] != c){
          // at a differnt color entity
          return true;
      }

      boolean result = true;
      // at the same color entity
      isVisited[x][y] = true;

      // x+1, y
      if(x+1 < board.length && !isVisited[x+1][y]){
        result = result && dfs(board, x+1, y, c, isVisited);
      }


      // x, y+1
      if(y+1 < board[0].length && !isVisited[x][y+1]){
        result = result && dfs(board, x, y+1, c, isVisited);
      }


      // x-1, y
      if(x-1 >= 0 && !isVisited[x-1][y]){
        result = result && dfs(board, x-1, y, c, isVisited);
      }
      // x, y-1
      if(y-1 >= 0 && !isVisited[x][y-1]){
        result = result && dfs(board, x, y-1, c, isVisited);
      }

      return result;
    }

    public static void main(String[] args){
      Capture c = new Capture();
      char[][] board = new char[3][3];
      char[] line1 = new char[]{'b','b','0'};
      char[] line2 = new char[]{'b','w','b'};
      char[] line3 = new char[]{'b','b','b'};
      board[0] = line1;
      board[1] = line2;
      board[2] = line3;
      System.out.println(c.isCaptured(board, 1, 1));
    }

}
