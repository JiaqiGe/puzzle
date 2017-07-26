// Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

// Example
// Given a binary tree:
//
//      1
//     /   \
//  -5     11
//  / \     /  \
// 1   2 4    -2
//
// return the node 11.

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

class TreeInfo {
    TreeNode maxNode;
    float    avgAtRoot;
    int      sumAtRoot;
    int      countAtRoot;
    float      maxAvg;

    public TreeInfo(TreeNode maxNode, float maxAvg, float avgAtRoot, int sumAtRoot, int countAtRoot){
        this.maxNode     = maxNode;
        this.avgAtRoot   = avgAtRoot;
        this.sumAtRoot   = sumAtRoot;
        this.maxAvg      = maxAvg;
        this.countAtRoot = countAtRoot;
    }
}

public class MaxSubTreeAvg {
    TreeNode findMaxSubTreeSum(TreeNode root){
        // divide and conquer
        if (root == null){
            return null;
        }

        TreeInfo treeInfo = help(root);
        return treeInfo.maxNode;
    }

    private TreeInfo help(TreeNode root){
        // base
        if (root.left == null&& root.right == null){
            TreeInfo treeInfo = new TreeInfo(root, root.val, root.val, root.val, 1);
            return treeInfo;
        }

        // divide and conquer
        TreeInfo treeInfo = null;
        if (root.left == null){
            TreeInfo right = help(root.right);
            // merge
            int sumAtRoot   = root.val + right.sumAtRoot;
            int countAtRoot = 1 + right.countAtRoot;
            float avgAtRoot   = sumAtRoot / (float)countAtRoot;

            if (avgAtRoot > right.maxAvg){
                 treeInfo = new TreeInfo(root, avgAtRoot, avgAtRoot, sumAtRoot, countAtRoot);
            }else{
                 treeInfo = new TreeInfo(right.maxNode, right.maxAvg, avgAtRoot, sumAtRoot, countAtRoot);
            }
        }else if (root.right == null){
            TreeInfo left = help(root.left);
            int sumAtRoot = root.val + left.sumAtRoot;
            int countAtRoot = 1 + left.countAtRoot;
            float avgAtRoot = sumAtRoot / (float) countAtRoot;

            if(avgAtRoot > left.maxAvg){
              treeInfo = new TreeInfo(root, avgAtRoot, avgAtRoot, sumAtRoot, countAtRoot);
            }else{
              treeInfo = new TreeInfo(left.maxNode, left.maxAvg, avgAtRoot, sumAtRoot, countAtRoot);
            }
        }else{
            TreeInfo left = help(root.left);
            TreeInfo right = help(root.right);

            int sumAtRoot = root.val + left.sumAtRoot + right.sumAtRoot;
            int countAtRoot = left.countAtRoot + right.countAtRoot + 1;
            float avgAtRoot = sumAtRoot / (float) countAtRoot;

            if(avgAtRoot >= left.maxAvg && avgAtRoot >= right.maxAvg){
              treeInfo = new TreeInfo(root, avgAtRoot, avgAtRoot, sumAtRoot, countAtRoot);
            }else if(left.maxAvg >= avgAtRoot && left.maxAvg >= right.maxAvg){
              treeInfo = new TreeInfo(left.maxNode, left.maxAvg, avgAtRoot, sumAtRoot, countAtRoot);
            }else if(right.maxAvg >= avgAtRoot && right.maxAvg >= left.maxAvg){
              treeInfo = new TreeInfo(right.maxNode, right.maxAvg, avgAtRoot, sumAtRoot, countAtRoot);
            }
        }
        return treeInfo;
    }

    public static void main(String[] args){
      //      1
      //     /   \
      //  -5     11
      //  / \     /  \
      // 1   2 4    -2
      TreeNode root = new TreeNode(1);
      TreeNode level11 = new TreeNode(-5);
      TreeNode level12 = new TreeNode(11);
      TreeNode level31 = new TreeNode(1);
      TreeNode level32 = new TreeNode(2);
      TreeNode level33 = new TreeNode(4);
      TreeNode level34 = new TreeNode(-2);

      root.left = level11;
      root.right = level12;
      level11.left= level31;
      level11.right = level32;
      level12.left = level33;
      level12.right = level34;

      MaxSubTreeAvg m = new MaxSubTreeAvg();
      TreeNode n = m.findMaxSubTreeSum(root);

      System.out.println(n.val);
    }
}
