// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,
//
// Consider the following matrix:
//
// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.

// bug: line 39/41: careful about loop variant

public class SearchMatrix{
    public boolean searchMatrix(int[][] matrix, int target) {
        //binary search
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int lo = 0;
        int hi = cols * rows - 1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            int midValue = matrix[mid/cols][mid % cols];

            if(target == midValue){
                return true;
            }else if (target > midValue){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1,3,5,7};
        matrix[1] = new int[]{10,11,16,20};
        matrix[2] = new int[]{23,30,34,50};

        SearchMatrix s = new SearchMatrix();
        System.out.println(s.searchMatrix(matrix, 23));
    }
}
