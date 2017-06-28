// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
// For example, given the following matrix:
//
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// Return 6.
// import java.util.*;

public class MaximumRectangle {
    public int maximalRectangle(int[][] matrix){
        //dfs
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 1){
                    boolean[][] isVisited = new boolean[rows][cols];
                    int area = search(matrix, i, j, i, j, isVisited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int search(int[][] matrix, int leftTopX, int leftTopY, int rightBottomX, int rightBottomY, boolean[][] isVisited){
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rightBottomX >= rows || rightBottomY >= cols ){
            return 0;
        }

        int maxArea = (rightBottomX - leftTopX + 1) * (rightBottomY - leftTopY + 1);
        isVisited[rightBottomX][rightBottomY] = true;
        //check bottom line
        boolean isDown = rightBottomX + 1 < rows;
        if(rightBottomX + 1 < rows){
            for(int j = leftTopY; j <= rightBottomY; j++){
                if(matrix[rightBottomX + 1][j] != 1){
                    isDown = false;
                    break;
                }
            }
            if(isDown && !isVisited[rightBottomX+1][rightBottomY]){
                int area = search(matrix, leftTopX, leftTopY, rightBottomX+1, rightBottomY, isVisited);
                maxArea = Math.max(maxArea, area);
            }
        }

        //check right
        boolean isRight = rightBottomY + 1 < cols;
        if(rightBottomY + 1 < cols){
            for(int i = leftTopX; i <= rightBottomX; i++){
                if(matrix[i][rightBottomY + 1] != 1){
                    isRight = false;
                    break;
                }
            }
            if(isRight && !isVisited[rightBottomX][rightBottomY+1]){
                int area = search(matrix, leftTopX, leftTopY, rightBottomX, rightBottomY+1, isVisited);
                maxArea = Math.max(maxArea, area);
            }
        }

        if(isDown && isRight && (matrix[rightBottomX+1][rightBottomY+1] == 1) && !isVisited[rightBottomX+1][rightBottomY+1]){
            int area = search(matrix,leftTopX, leftTopY, rightBottomX+1, rightBottomY+1, isVisited);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args){
        int[][] matrix = new int[4][5];
        matrix[0] = new int[]{1, 0, 1, 0, 0};
        matrix[1] = new int[]{0, 1, 1, 1, 1};
        matrix[2] = new int[]{1, 1, 1, 1, 1};
        matrix[3] = new int[]{1, 0, 0, 1, 0};

        MaximumRectangle m = new MaximumRectangle();
        System.out.println(m.maximalRectangle(matrix));
    }
}
