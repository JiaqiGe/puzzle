// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//         _______6______
//        /              \
//     ___2__          ___8__
//    /      \        /      \
//    0      _4       7       9
//          /  \
//          3   5
// For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val   = val;
        this.left  = null;
        this.right = null;
    }
}

public class LowestLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // assume that p and q are present in the tree

        if (root == null){
            return null;
        }


        // find either p or q
        if ((root.val == q.val) || (root.val == p.val)){
            return root;
        }

        TreeNode leftLCA  = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // one in left tree and one in right tree
        if (leftLCA != null&& rightLCA != null){
            return root;
        }

        return leftLCA == null ? rightLCA : leftLCA;
    }

  static boolean findP = false;
  static boolean findQ = false;

  public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
      if(root == null){
        return null;
      }

      if(root.val == p.val){
        findP = true;
        return root;
      }

      if(root.val == q.val){
        findQ = true;
        return root;
      }

      TreeNode leftLCA = findLCA(root.left, p, q);
      TreeNode rightLCA = findLCA(root.right, p, q);

      if(!findP || !findQ){
        return null;
      }

      if(leftLCA != null && rightLCA != null){
        return root;
      }

      return leftLCA == null ? rightLCA : leftLCA;
  }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);

        root.left        = new TreeNode(2);
        root.right       = new TreeNode(3);
        root.left.left   = new TreeNode(4);
        root.left.right  = new TreeNode(5);
        root.right.left  = new TreeNode(6);
        root.right.right = new TreeNode(7);

        LowestLCA l = new LowestLCA();
        System.out.println("LCA(4, 5) = " +
                           l.findLCA(root, new TreeNode(4), new TreeNode(5)).val);
    }
}
