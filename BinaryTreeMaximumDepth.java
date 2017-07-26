// Given a binary tree, find its maximum depth.
//
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
public class BinaryTreeMaximumDepth {
    public int maxDepth(TreeNode root){
      //recursive

      // base
      if(root == null){
        return 0;
      }

      //recursive function

      int leftMax = maxDepth(root.left);
      int rightMax = maxDepth(root.right);

      return Math.max(leftMax, rightMax) + 1;
    }
}
