// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
// For example,
// Given the following matrix:
//
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].

// two bugs: 1) infinity loop => forgot to add i++/j++ in 1-d array
//          2) be careful of using i++/++i, make sure it does what you want

import java.util.*;

public class SpiralMatrix{
    public List<Integer> spiralOrder(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<>();

        int height = matrix.length ;
        int width = matrix[0].length;
        int x = 0;
        int y = 0;

        while(height > 0 && width > 0){
            help(matrix, x, y, height, width, result);
            x++;
            y++;
            height -= 2;
            width -= 2;
        }

        return result;
    }

    private void help(int[][] matrix, int x, int y, int height, int width, List<Integer> list){
        // add the outer circle to list
        int i = x;
        int j = y;

        if(height == 1){
            while(j < y + width){
                list.add(matrix[i][j]);
                j++;
            }
            return;
        }

        if(width == 1){
            while(i < x + height){
                list.add(matrix[i][j]);
                i++;
            }
            return;
        }


        while(j < y + width - 1){
            list.add(matrix[i][j]);
            j++;
        }

        while(i < x + height - 1){
            list.add(matrix[i][j]);
            i++;
        }

        while(j > 0){
            list.add(matrix[i][j]);
            j--;
        }

        while(i > 0){
            list.add(matrix[i][j]);
            i--;
        }
        return;
    }

    public static void main(String[] args){
        SpiralMatrix s = new SpiralMatrix();
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
        matrix[2] = new int[]{7,8,9};
        List<Integer> list = s.spiralOrder(matrix);
        for(int i : list){
            System.out.print(i+" ");
        }
    }
}
