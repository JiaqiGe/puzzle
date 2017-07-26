// Given a binary tree, find the maximum path sum.
//
// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//
// For example:
// Given the below binary tree,
//
//        1
//       / \
//      2   3
// Return 6.
class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

class TreeInfo{
  int maxFromRoot;
  int maxSum;
  TreeInfo(int maxFromRoot, int maxSum){
    this.maxFromRoot = maxFromRoot;
    this.maxSum = maxSum;
  }
}

public class BTMaxPathSum {
    public int maxPathSum(TreeNode root){
      if(root == null){
        return 0;
      }

      // divide and conquer
      TreeInfo info = help(root);
      return info.maxSum;
    }

    private TreeInfo help(TreeNode root){
      // base
      if(root.left == null && root.right == null){
        return new TreeInfo(root.val, root.val);
      }

      // divide and conquer
      int maxSum = root.val;
      int maxFromRoot = root.val;

      if(root.left == null && root.right != null){
        TreeInfo rightInfo = help(root.right);
        maxFromRoot = Math.max(maxFromRoot, rightInfo.maxFromRoot + root.val);
        maxSum = Math.max(rightInfo.maxSum, maxFromRoot);
      }else if(root.left != null && root.right == null){
        TreeInfo leftInfo = help(root.left);
        maxFromRoot = Math.max(maxFromRoot, leftInfo.maxFromRoot + root.val);
        maxSum = Math.max(leftInfo.maxSum, maxFromRoot);
      }else{
        TreeInfo leftInfo = help(root.left);
        TreeInfo rightInfo = help(root.right);


        // merge to get maxFromRoot
        maxFromRoot = Math.max(maxFromRoot, Math.max(root.val + rightInfo.maxFromRoot, root.val + leftInfo.maxFromRoot));

        // merge to get maxSum
        maxSum = Math.max(maxSum, leftInfo.maxSum);
        maxSum = Math.max(maxSum, rightInfo.maxSum);
        maxSum = Math.max(maxSum, leftInfo.maxFromRoot + root.val);
        maxSum = Math.max(maxSum, rightInfo.maxFromRoot + root.val);
        maxSum = Math.max(maxSum, leftInfo.maxFromRoot + root.val + rightInfo.maxFromRoot);
      }

      return new TreeInfo(maxFromRoot, maxSum);
    }

    public static void main(String[] args){
      TreeNode root = new TreeNode(-10);
      root.left = new TreeNode(9);
      root.right = new TreeNode(3);

      BTMaxPathSum b = new BTMaxPathSum();
      System.out.println(b.maxPathSum(root));
    }
}
