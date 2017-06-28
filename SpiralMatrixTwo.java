// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
// For example,
// Given n = 3,
//
// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
public class SpiralMatrixTwo{
    public int[][] generateMatrix(int n){
        if(n <= 0){
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];

        int x = 0;
        int y = 0;
        int length = n;
        int value = 1;

        while(length > 0){
            //generate outer
            value = fill(matrix, x, y, length, value);
            x++;
            y++;
            length -= 2;
        }

        return matrix;
    }

    //fill the circle with left top (x,y), length is length
    // return the next available vaule to be filled
    private int fill(int[][] matrix, int x, int y, int length, int value){
        int row = x;
        int col = y;

        if(length == 1){
            matrix[x][y] = value ++;
            return value;
        }

        //fill top row
        while(col < y  + length - 1){
            matrix[row][col] = value ++;
            col ++;
        }

        //fill right col
        while(row < x + length - 1){
            matrix[row][col] = value ++;
            row ++;
        }

        //fill bottom row
        while(col > y){
            matrix[row][col] = value ++;
            col --;
        }

        //fill left col
        while(row > x){
            matrix[row][col] = value ++;
            row -- ;
        }

        return value;
    }

    public static void main(String[] args){
        int n = 5;
        SpiralMatrixTwo s = new SpiralMatrixTwo();
        int[][] m = s.generateMatrix(n);

        for(int[] row : m){
            for(int i : row){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
