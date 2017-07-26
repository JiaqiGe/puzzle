// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums){
      //divide and conquer
      if(nums.length == 0){
        return null;
      }

      return help(nums, 0, nums.length - 1);
    }


    private TreeNode help(int[] nums, int lo, int hi){
      if(lo == hi){
        TreeNode root = new TreeNode(nums[lo]);
      }

      if(lo > hi){
        return null;
      }

      int mid = (lo + hi) / 2;
      TreeNode root = new TreeNode(nums[mid]);

      TreeNode left = help(nums, lo, mid - 1);
      TreeNode right = help(nums, mid + 1, hi);

      root.left = left;
      root.right = right;

      return root;
    }
}

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}
