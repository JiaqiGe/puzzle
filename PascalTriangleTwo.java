// Given an index k, return the kth row of the Pascal's triangle.
//
// For example, given k = 3,
// Return [1,3,3,1].
//
// Note:
// Could you optimize your algorithm to use only O(k) extra space?
//

import java.util.*;

public class PascalTriangleTwo {
    public List<Integer> getRow(int rowIndex){
        if (rowIndex < 0){
            return new ArrayList<>();
        }

        List<Integer> line = new ArrayList<>();
        line.add(1);

        int count = 0;
        while(count < rowIndex){
          List<Integer> nextLine = new ArrayList<>();
          nextLine.add(1);
          for(int i = 0; i < line.size()-1; i++){
            nextLine.add(line.get(i) + line.get(i+1));
          }
          nextLine.add(1);

          line = nextLine;
          count ++;
        }

        return line;
    }

    public static void main(String[] args){
      PascalTriangleTwo p = new PascalTriangleTwo();
      List<Integer> r = p.getRow(3);

      for(int i : r){
        System.out.print(i + " ");
      }
    }
}
