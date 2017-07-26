// Given numRows, generate the first numRows of Pascal's triangle.
//
// For example, given numRows = 5,
// Return
//
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

import java.util.*;
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0){
            return result;
        }

        List<Integer> line = new ArrayList<>();
        line.add(1);
        result.add(line);

        int count = 2;
        while (count <= numRows){
            List<Integer> nextLine = new ArrayList<>();
            nextLine.add(1);
            for (int i = 0; i < line.size() - 1; i++){
                nextLine.add(line.get(i) + line.get(i + 1));
            }
            nextLine.add(1);
            result.add(nextLine);
            line = nextLine;
            count ++;
        }

        return result;
    }

    public static void main(String[] args){
      PascalTriangle p = new PascalTriangle();
      List<List<Integer>> result = p.generate(5);
      for(List<Integer> line : result){
        for(int i : line){
          System.out.print(i + " ");
        }
        System.out.println();
      }
    }
}
