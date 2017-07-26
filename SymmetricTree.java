//
// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following [1,2,2,null,3,null,3] is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.
//
// bug: line 53 i < j => i <= j

import java.util.*;
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }

        if (root.left == null&& root.right == null){
            return true;
        }

        if ((root.left == null) || (root.right == null)){
            return false;
        }
        //recursive
        return recursive(root.left, root.right);
    }

    private boolean iterative2(TreeNode root){
        if (root == null){
            return true;
        }

        Queue<TreeNode> lQueue = new LinkedList<>();
        Queue<TreeNode> rQueue = new LinkedList<>();

        lQueue.offer(root);
        rQueue.offer(root);

        while (!lQueue.isEmpty() && !rQueue.isEmpty()){
            TreeNode l = lQueue.poll();
            TreeNode r = rQueue.poll();

            if (!isSame(l.left, r.right) || !isSame(l.right, r.left)){
                return false;
            }

            if(l.left != null){
              lQueue.offer(l.left);
            }

            if(l.right != null){
              lQueue.offer(l.right);
            }

            if(r.right != null){
              rQueue.offer(r.right);
            }

            if(r.left != null){
              rQueue.offer(r.left);
            }
        }

        return true;
    }

    private boolean isSame(TreeNode n1, TreeNode n2){
        if (n1 == null&& n2 == null){
            return true;
        }

        if ((n1 == null) || (n2 == null) || (n1.val != n2.val)){
            return false;
        }

        return true;
    }

    private boolean iterative(TreeNode root){
        if (root == null){
            return true;
        }

        TreeNode[] nodes = new TreeNode[1];
        nodes[0] = root;
        boolean isEmpty = false;

        while (!isEmpty){
            TreeNode[] childNodes = new TreeNode[2 * nodes.length];
            int        i          = 0;
            int        j          = nodes.length - 1;

            while (i <= j){
                if (nodes[i] == null&& nodes[j] == null){
                    i++;
                    j--;
                    continue;
                }

                if ((nodes[i] == null) || (nodes[j] == null) || (nodes[i].val != nodes[j].val)){
                    return false;
                }

                childNodes[2 * i]     = nodes[i].left;
                childNodes[2 * i + 1] = nodes[i].right;

                childNodes[2 * j]     = nodes[j].left;
                childNodes[2 * j + 1] = nodes[j].right;

                i++;
                j--;
            }

            nodes   = childNodes;
            isEmpty = true;
            for (TreeNode t : nodes){
                if (t != null){
                    isEmpty = false;
                    break;
                }
            }
        }

        return true;
    }

    private boolean recursive(TreeNode p, TreeNode q){
        //base
        if (p == null&& q == null){
            return true;
        }

        if ((p == null) || (q == null)){
            return false;
        }
        if (p.val != q.val){
            return false;
        }

        return recursive(p.left, q.right) && recursive(p.right, q.left);
    }
}
class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}
