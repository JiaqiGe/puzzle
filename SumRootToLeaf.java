// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
// An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
// Find the total sum of all root-to-leaf numbers.
//
// For example,
//
//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
//
// Return the sum = 12 + 13 = 25.

// import TreeNode;
import java.util.*;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root){
        // divide and conquer
        if (root == null){
            return 0;
        }

        List<List<Integer>> pathes = help(root);
        int sum = 0;
        for(List<Integer> path : pathes){
          sum += getValue(path);
        }
        return sum;
    }

    private int getValue(List<Integer> path){

      int result = 0;
      int scale = 1;
      for(int i = path.size()-1; i >= 0; i--){
        result += scale * path.get(i);
        scale *= 10;
      }
      return result;
    }

    private List<List<Integer>> help(TreeNode root){
        // divide and conquer
        List<List<Integer>> result = new ArrayList<>();

        // base
        if (root.left == null && root.right == null){
            List<Integer> oneResult = new ArrayList<>();
            oneResult.add(root.val);
            result.add(oneResult);
            return result;
        }

        //

        if (root.left == null){
            result.addAll(help(root.right));
        }else if (root.right == null){
            result.addAll(help(root.left));
        }else{
            result.addAll(help(root.left));
            result.addAll(help(root.right));
        }

        for (List<Integer> oneResult : result){
            oneResult.add(0, root.val);
        }

        return result;
    }

    public static void main(String[] args){
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);

      SumRootToLeaf s = new SumRootToLeaf();
      int sum = s.sumNumbers(root);
      System.out.println(sum);
    }
}
