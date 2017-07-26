// Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:
//     2
//    / \
//   1   3
// Binary tree [2,1,3], return true.
// Example 2:
//     1
//    / \
//   2   3
// Binary tree [1,2,3], return false.

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root){
        //divide and conquer
        if (root == null){
            return true;
        }

        TreeInfo info = help(root);
        return info.isBST;
    }

    private TreeInfo help(TreeNode root){
        //base
        if (root.left == null&& root.right == null){
            return new TreeInfo(root.val, root.val, true);
        }

        //divie & conquer
        TreeInfo left  = null;
        TreeInfo right = null;

        if (root.left != null){
            left = help(root.left);
        }

        if (root.right != null){
            right = help(root.right);
        }

        if (left != null){
            if (!left.isBST || (left.max >= root.val)){
                return new TreeInfo(0, 0, false);
            }
        }

        if (right != null){
            if (!right.isBST || (right.min <= root.val)){
                return new TreeInfo(0, 0, false);
            }
        }

        return new TreeInfo(left.min, right.max, true);
    }

    public static void main(String[] args){
      ValidateBinarySearchTree v = new ValidateBinarySearchTree();
      TreeNode root = new TreeNode(2);
      TreeNode left = new TreeNode(1);
      TreeNode right = new TreeNode(3);

      root.left = left;
      root.right = right;

      System.out.println(v.isValidBST(root));
    }
}

class TreeInfo {
    int     min;
    int     max;
    boolean isBST;
    TreeInfo(int minValue, int maxValue, boolean isValid){
        this.min   = minValue;
        this.max   = maxValue;
        this.isBST = isValid;
    }
}

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}
