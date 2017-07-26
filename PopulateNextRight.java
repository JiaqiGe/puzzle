// Given a binary tree
//
//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
// Initially, all next pointers are set to NULL.
//
// Note:
//
// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
// For example,
// Given the following perfect binary tree,
//          1
//        /  \
//       2    3
//      / \  / \
//     4  5  6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL

import java.util.*;

public class PopulateNextRight {
    TreeLinkNode parent   = null;
    TreeLinkNode mostLeft = null;

    public void connect(TreeLinkNode root){
        if (root == null){
            return;
        }

        parent   = root;
        mostLeft = root.left;

        while (mostLeft != null){
            TreeLinkNode runner = mostLeft;
            while (!(runner == parent.right && parent.next == null)){
              if(runner == parent.left){
                runner.next = parent.right;
              }else if(runner == parent.right){
                  parent = parent.next;
                  runner.next = parent.left;
              }
              runner = runner.next;
            }
            parent = mostLeft;
            mostLeft = mostLeft.left;
        }
    }
}
