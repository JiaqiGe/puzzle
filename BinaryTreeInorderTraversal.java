// Given a binary tree, return the inorder traversal of its nodes' values.
//
// For example:
// Given binary tree [1,null,2,3],
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].
//
// Note: Recursive solution is trivial, could you do it iteratively?

//mimic how recursive functions are called
// use stack to replace call stack

import java.util.*;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
      // List<Integer> result = new ArrayList<>();
      // recursiveInOrder(root, result);
      return iterateInOrder(root);
    }

    private void recursiveInOrder(TreeNode root, List<Integer> result){
      if(root == null){
        return;
      }

      recursiveInOrder(root.left, result);
      result.add(root.val);
      recursiveInOrder(root.right, result);
    }

    private List<Integer> iterateInOrder(TreeNode root){
      //stack
      if(root == null){
        return new ArrayList<>();
      }

      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);

      while(!stack.isEmpty()){
        TreeNode node = stack.pop();
        while(node.left != null){
          stack.push(node);
          node = node.left;
        }
        // now node.left == null, visit node
        result.add(node.val);
        while(node.right == null && !stack.isEmpty()){
          node = stack.pop();
          result.add(node.val);
        }

        if(node.right != null){
          stack.push(node.right);
        }
      }
      return result;
    }

    public static void main(String[] args){
      TreeNode n1 = new TreeNode(1);
      TreeNode n2 = new TreeNode(2);
      TreeNode n3 = new TreeNode(3);
      TreeNode n4 = new TreeNode(4);

      n1.right = n2;
      n2.left = n3;
      n1.left = n4;

      BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
      List<Integer> result = b.inorderTraversal(n1);
      for(int i : result){
        System.out.println(i+" ");
      }
    }
}


class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}
