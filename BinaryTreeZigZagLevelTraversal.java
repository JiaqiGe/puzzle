// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]

import java.util.*;

public class BinaryTreeZigZagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int level = 0;

        while (!deque.isEmpty()){
            Deque<TreeNode> nextLevelDeque = new LinkedList<>();
            List<Integer>   oneLevel       = new ArrayList<>();

            if (level % 2 == 0){
                while (!deque.isEmpty()){
                    TreeNode node = deque.pollFirst();
                    oneLevel.add(node.val);

                    if (node.left != null){
                        nextLevelDeque.offerLast(node.left);
                    }

                    if (node.right != null){
                        nextLevelDeque.offerLast(node.right);
                    }
                }
                result.add(oneLevel);
                deque = nextLevelDeque;
            }else{
              while(!deque.isEmpty()){
                TreeNode node = deque.pollLast();
                oneLevel.add(node.val);

                if(node.right != null){
                  nextLevelDeque.offerFirst(node.right);
                }

                if(node.left != null){
                  nextLevelDeque.offerFirst(node.left);
                }
              }
              result.add(oneLevel);
              deque = nextLevelDeque;
            }

            level++;
        }
        return result;
    }
}
