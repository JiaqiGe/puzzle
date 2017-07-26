// Given a binary tree, determine if it is height-balanced.
//
// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
      //divide and conquer
      if(root == null){
        return true;
      }

      TreeInfo info = help(root);
      return info.isBalanced;
    }

    private TreeInfo help(TreeNode root){
      //base
      if(root == null){
        return new TreeInfo(0, true);
      }

      TreeInfo leftInfo = help(root.left);
      TreeInfo rightInfo = help(root.right);

      if(!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.depth - rightInfo.depth) > 1){
        return new TreeInfo(0, false);
      }

      return new TreeInfo(Math.max(leftInfo.depth, rightInfo.depth) + 1, true);
    }
}

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

class TreeInfo{
  int depth;
  boolean isBalanced;

  TreeInfo(int depth, boolean isBalanced){
    this.depth = depth;
    this.isBalanced = isBalanced;
  }
}
