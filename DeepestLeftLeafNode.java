// Deepest left leaf node in a binary tree
// Given a Binary Tree, find the deepest leaf node that is left child of its parent. For example, consider the following tree. The deepest left leaf node is the node with value 9.
//
//        1
//      /   \
//     2     3
//   /      /  \
//  4      5    6
//         \     \
//          7     8
//         /       \
//        9         10

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

class TreeInfo {
    int      level;
    TreeNode node;
    public TreeInfo(int level, TreeNode node){
        this.level = level;
        this.node  = node;
    }
}

public class DeepestLeftLeafNode {
    public TreeNode findDeepestLeafNode(TreeNode root){
        if (root == null){
            return null;
        }

        TreeInfo info = help(root, 0);
        return info.node;
    }

    private TreeInfo help(TreeNode root, int level){
        // divide and conquer
        // base
        if (root.left == null&& root.right == null){
            // leaf node
            TreeInfo info = new TreeInfo(level, root);
            return info;
        }

        // merge
        TreeInfo info = null;
        if (root.left == null){
            info = help(root.right, level + 1);
        }else if (root.right == null){
            info = help(root.left, level + 1);
        }else{
            TreeInfo leftInfo  = help(root.left, level + 1);
            TreeInfo rightInfo = help(root.right, level + 1);

            if (leftInfo.level > rightInfo.level){
                info = leftInfo;
            }else if (leftInfo.level < rightInfo.level){
                info = rightInfo;
            }else{
                info = leftInfo;
            }
        }

        return info;
    }

    public static void main(String[] args){
      TreeNode t11 = new TreeNode(1);
      TreeNode t21 = new TreeNode(2);
      TreeNode t31 = new TreeNode(-1);

      t11.left = t21;
      t21.right = t31;

      DeepestLeftLeafNode d = new DeepestLeftLeafNode();
      System.out.println(d.findDeepestLeafNode(t11).val);
    }
}
