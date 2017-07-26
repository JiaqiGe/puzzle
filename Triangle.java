// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]

import java.util.*;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle){
      if(triangle.isEmpty()){
        return 0;
      }

      //dp
      List<List<Integer>> dp = new ArrayList<>();

      // initialize
      dp.add(triangle.get(triangle.size()-1));

      for(int i = triangle.size() - 2; i  >= 0; i--){
        List<Integer> data = triangle.get(i);
        List<Integer> preSum = dp.get(0);
        List<Integer> sum = new ArrayList<>();
        for(int j = 0; j < data.size(); j++){
          int value = data.get(j) + Math.min(preSum.get(j), preSum.get(j+1));
          sum.add(value);
        }
        dp.add(0,sum);
      }

      return dp.get(0).get(0);
    }

    public static void main(String[] args){
      Triangle t  = new Triangle();

      List<List<Integer>> triangle = new ArrayList<>();
      List<Integer> l1  = new ArrayList<>();
      List<Integer> l2  = new ArrayList<>();

      l1.add(1);
      l2.add(2);
      l2.add(3);

      triangle.add(l1);
      triangle.add(l2);

      System.out.println(t.minimumTotal(triangle));

    }
}
