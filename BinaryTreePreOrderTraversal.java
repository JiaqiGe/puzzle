// Given a binary tree, return the preorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].


public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

import java.util.*;

public class BinaryTreePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root){
      if(root == null){
        return new ArrayList<>();
      }

      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);

      while(!stack.isEmpty()){
        TreeNode curNode = stack.pop();
        result.add(curNode.val);

        if(curNode.right != null){
          stack.push(curNode.right);
        }

        if(curNode.left != null){
          stack.push(curNode.left);
        }
      }

      return result;
    }
}
