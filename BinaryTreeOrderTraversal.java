// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

public class BinaryTreeOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
          Queue<TreeNode> nextLevel = new LinkedList<>();
          List<Integer> oneLevel = new ArrayList<>();

          while(!queue.isEmpty()){
              TreeNode node = queue.poll();
              oneLevel.add(node.val);

              if(node.left != null){
                nextLevel.offer(node.left);
              }

              if(node.right != null){
                nextLevel.offer(node.right);
              }
          }
          result.add(oneLevel);
          queue = nextLevel;
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
