// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
// click to show follow up.
//
// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?


public class SetMatrixZero{
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        //find the first 0
        int x = 0;
        int y = 0;
        boolean isFound = false;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j ++){
                if(matrix[i][j] == 0){
                    if(!isFound){
                        isFound = true;
                        x = i;
                        y = j;
                    }else{
                        matrix[i][y] = 0;
                        matrix[x][j] = 0;
                    }
                }
            }
        }

        // mark zero
        for(int j = 0; j < cols; j++){
            if(j != y && matrix[x][j] == 0){
                setColumnZero(matrix, j);
            }
        }

        for(int i = 0; i < rows; i++){
            if(i != x && matrix[i][y] == 0){
                setRowZero(matrix, i);
            }
        }

        setColumnZero(matrix, y);
        setRowZero(matrix, x);

        return;
    }

    private void setColumnZero(int[][] matrix, int col){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }

        return;
    }

    private void setRowZero(int[][] matrix, int row){
        for(int j = 0; j < matrix[0].length; j++){
            matrix[row][j] = 0;
        }

        return;
    }

    public static void main(String[] args){
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,1,0};
        matrix[1] = new int[]{1,0,1};
        matrix[2] = new int[]{1,1,1};

        SetMatrixZero s = new SetMatrixZero();
        s.setZeroes(matrix);

        for(int[] row : matrix){
            for(int i : row){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
