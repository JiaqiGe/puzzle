// Given a binary tree, flatten it to a linked list in-place.
//
// For example,
// Given
//
//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6

// pay attention to a non-recursive solution

public class FlatternBST {
    public void flatten(TreeNode root){
        help(root);
    }

    private TreeNode help(TreeNode root){
        if (root == null){
            return null;
        }

        TreeNode left = help(root.left);
        TreeNode right = help(root.right);

        if(left == null){
          root.right = right;
        }else{
          TreeNode runner = left;
          while(runner.right != null){
            runner = runner.right;
          }
          root.right = left;
          root.left = null;
          runner.right = right;
        }

        return root;
    }
}
