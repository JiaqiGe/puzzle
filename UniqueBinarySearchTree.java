// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//
// For example,
// Given n = 3, there are a total of 5 unique BST's.
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
// ## memorization to reduce time complexity
import java.util.*;

public class UniqueBinarySearchTree {
    public int numTrees(int n){
      if(n <= 0){
        return 0;
      }
      Map<Integer, Integer> map = new HashMap<>();
      return help(1, n, map);
    }

    private int help(int lo, int hi, Map<Integer, Integer> map){
      if(lo >= hi){
        return 1;
      }

      //divide and conquer
      int count = 0;
      for(int i = lo; i <= hi; i++){

        int uniqueLeft = map.containsKey(i-1-lo) ? map.get(i-1-lo) : help(lo, i-1, map);
        int uniqueRight = map.containsKey(hi - i - 1) ? map.get(hi-i-1) : help(i+1, hi, map);
        count += (uniqueRight * uniqueLeft);
      }
      map.put(hi-lo, count);
      return count;
    }
}

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}
