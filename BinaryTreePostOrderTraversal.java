//
// Given a binary tree, return the postorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [3,2,1]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// hahaha! Nice work! This is way more simple than geekforce, with some additonal memory.

import java.util.*;

public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer>   result    = new ArrayList<>();
        Stack<TreeNode> stack     = new Stack<>();
        Set<TreeNode>   isVisited = new HashSet<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode curNode = stack.peek();
            TreeNode left    = curNode.left;
            TreeNode right   = curNode.right;
            boolean  bLeft   = (left == null || isVisited.contains(left));
            boolean  bRight  = (right == null || isVisited.contains(right));


            if (bLeft && bRight){
                TreeNode visit = stack.pop();
                isVisited.add(visit);
                result.add(visit.val);
            }else{
                if(right != null){
                  stack.push(right);
                }

                if(left != null){
                  stack.push(left);
                }
            }
        }
        return result;
    }
}
