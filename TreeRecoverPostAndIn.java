// Given inorder and postorder traversal of a tree, construct the binary tree.
//

public class TreeRecoverPostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder){
        if (inorder.length == 0){
            return null;
        }

        return help(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode help(int[] postorder, int index, int[] inorder, int lo, int hi){
        // base
        if (lo > hi){
            return null;
        }

        if (lo == hi){
            TreeNode root = new TreeNode(postorder[index]);
            return root;
        }

        // divide and conque
        TreeNode root = new TreeNode(postorder[index]);
        int      mid  = searchForRoot(inorder, lo, hi, root.val);

        TreeNode leftTree  = help(postorder, index - 1 - (hi - mid), inorder, lo, mid - 1);
        TreeNode rightTree = help(postorder, index - 1, inorder, mid + 1, hi);

        root.left  = leftTree;
        root.right = rightTree;
        return root;
    }

    private int searchForRoot(int[] inorder, int lo, int hi, int k){
        int index = -1;

        for (int i = lo; i <= hi; i++){
            if (inorder[i] == k){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args){
        TreeRecoverPostAndIn t = new TreeRecoverPostAndIn();


        int[] inorder  = new int[] { 4, 2, 1, 3 };
        int[] postorder = new int[] { 4, 2, 3, 1 };

        TreeNode root = t.buildTree(inorder, postorder);

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
