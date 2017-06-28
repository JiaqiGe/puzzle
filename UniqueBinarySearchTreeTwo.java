//
// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3

import java.util.*;

public class UniqueBinarySearchTreeTwo {
    public List<TreeNode> generateTrees(int n){
        if (n == 0){
            return new ArrayList<>();
        }
        //recursion
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int lo, int hi){
        List<TreeNode> result = new ArrayList<>();

        // base
        if(lo > hi){
          return result;
        }

        if (lo == hi){
            TreeNode node = new TreeNode(lo);
            result.add(node);
            return result;
        }

        //recursive function: divide & conquer
        for (int i = lo; i <= hi; i++){
            List<TreeNode> leftTrees = buildTrees(lo, i-1);
            List<TreeNode> rightTrees = buildTrees(i+1, hi);

            //merge
            if(leftTrees.isEmpty() && rightTrees.isEmpty()){
              TreeNode root = new TreeNode(i);
              result.add(root);
            }else if(leftTrees.isEmpty()){
              for(TreeNode rightTree : rightTrees){
                TreeNode root = new TreeNode(i);
                root.right = rightTree;
                result.add(root);
              }
            }else if(rightTrees.isEmpty()){
              for(TreeNode leftTree : leftTrees){
                TreeNode root = new TreeNode(i);
                root.left = leftTree;
                result.add(root);
              }
            }else{
              for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                  TreeNode root = new TreeNode(i);
                  root.left = left;
                  root.right = right;
                  result.add(root);
                }
              }
            }
        }
        return result;
    }
}

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}
