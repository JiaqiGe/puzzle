// Given preorder and inorder traversal of a tree, construct the binary tree.

public class TreeRecoverPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder.length != inorder.length){
            return null;
        }

        if (preorder.length == 0){
            return null;
        }

        //recursion
        return help(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode help(int[] preorder, int index, int[] inorder, int lo, int hi){
      // base
      if(lo == hi){
        TreeNode leaf = new TreeNode(inorder[lo]);
        return leaf;
      }

      if(lo > hi){
        return null;
      }

      // divide and conquer
      TreeNode root = new TreeNode(preorder[index]);

      int mid = searchForRoot(inorder, lo, hi, root.val);

      TreeNode leftTree = help(preorder, index+1, inorder, lo, mid - 1);
      TreeNode rightTree = help(preorder, index+mid-lo+1, inorder, mid + 1, hi);

      root.left = leftTree;
      root.right = rightTree;

      return root;

    }


    private int searchForRoot(int[] inorder, int lo, int hi, int k){
      int index = -1;
      for(int i = lo; i <= hi; i++){
        if(inorder[i] == k){
          index = i;
          break;
        }
      }
      return index;
    }

    public static void main(String[] args){
      TreeRecoverPreAndIn t = new TreeRecoverPreAndIn();


      int[] inorder = new int[]{4,2,1,3};
      int[] preorder = new int[]{1,2,4,3};

      TreeNode root = t.buildTree(preorder, inorder);

      System.out.println(root.val == 1);
      System.out.println(root.left.val == 2);
      System.out.println(root.right.val == 3);
      System.out.println(root.left.left.val == 4);

    }
}


class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}
