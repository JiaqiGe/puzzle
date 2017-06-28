// You are given an n x n 2D matrix representing an image.
//
// Rotate the image by 90 degrees (clockwise).
//
// Follow up:
// Could you do this in-place?
//
// Subscribe to see which companies asked this question.


//record:  3 bugs! 06/05:
//   1. length --; ==> length -= 2
//   2. moveRight/up => happends after swap
//   3. swap should be a deep copy in matrix


public class RotateImage {
    public void rotate(int[][] matrix){
        if ((matrix.length == 0) || (matrix[0].length == 0)){
            return;
        }

        int size   = matrix.length % 2 == 0 ? matrix.length / 2 : (matrix.length / 2 + 1);
        int length = matrix.length - 1;

        int x = 0;

        while (x < size && length > 0){
            rotateOneCircle(matrix, x, length);

            x++;
            length -= 2;
        }
    }

    private void rotateOneCircle(int[][] matrix, int x, int length){
        //derive four corner points
        Point topLeft     = new Point(x, x);
        Point topRight    = new Point(x, x + length);
        Point bottomRight = new Point(x + length, x + length);
        Point bottomLeft  = new Point(x + length, x);

        for (int i = 0; i < length; i++){
            rotateOneCell(matrix, topLeft, topRight, bottomRight, bottomLeft);
            topLeft.moveRight();
            topRight.moveDown();
            bottomRight.moveLeft();
            bottomLeft.moveUp();
        }
    }

    private void rotateOneCell(int[][] matrix, Point p1, Point p2, Point p3, Point p4){
        int tmp = matrix[p1.x][p1.y];

        matrix[p1.x][p1.y] = matrix[p4.x][p4.y];
        matrix[p4.x][p4.y] = matrix[p3.x][p3.y];
        matrix[p3.x][p3.y] = matrix[p2.x][p2.y];
        matrix[p2.x][p2.y] = tmp;

        return;
    }

    public static void main(String[] args){
        RotateImage r = new RotateImage();

        int[][] matrix = new int[3][3];
        matrix[0] = new int[] { 1, 2, 3 };
        matrix[1] = new int[] { 4, 5, 6 };
        matrix[2] = new int[] { 7, 8, 9 };

        r.rotate(matrix);
        for (int[] row : matrix){
            for (int i : row){
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }
}

class Point {
    protected int x;
    protected int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveRight(){
        this.y++;
    }

    public void moveLeft(){
        this.y--;
    }

    public void moveDown(){
        this.x++;
    }

    public void moveUp(){
        this.x--;
    }
}
