// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]

import java.util.*;

public class BinaryTreeLevelOrderTraversalTwo {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
          return result;
        }

        //bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
          Queue<TreeNode> nextLevelQueue = new LinkedList<>();
          List<Integer> oneLevel = new ArrayList<>();

          while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            oneLevel.add(node.val);

            if(node.left != null){
              nextLevelQueue.offer(node.left);
            }

            if(node.right != null){
              nextLevelQueue.offer(node.right);
            }
          }
          result.add(0,oneLevel);
          queue = nextLevelQueue;
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
