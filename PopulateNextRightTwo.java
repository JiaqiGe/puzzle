// Follow up for problem "Populating Next Right Pointers in Each Node".
//
// What if the given tree could be any binary tree? Would your previous solution still work?
//
// Note:
//
// You may only use constant extra space.
// For example,
// Given the following binary tree,
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL


// Follow up for problem "Populating Next Right Pointers in Each Node".
//
// What if the given tree could be any binary tree? Would your previous solution still work?
//
// Note:
//
// You may only use constant extra space.
// For example,
// Given the following binary tree,
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL


public class PopulateNextRightTwo {
    TreeLinkNode parent   = null;
    TreeLinkNode mostLeft = null;

    public void connect(TreeLinkNode root){
        if (root == null){
            return;
        }

        parent   = root;
        mostLeft = root.left != null ? root.left : root.right;

        while (parent != null&& mostLeft != null){
            TreeLinkNode runner = mostLeft;

            while (runner != null){
                while (parent != null){
                    if (runner == parent.left){
                        if (parent.right != null){
                            runner.next = parent.right;
                            break;
                        } else {
                            parent = parent.next;
                        }
                    } else if (runner == parent.right){
                        parent = parent.next;
                    } else {
                        if (parent.left != null){
                            runner.next = parent.left;
                            break;
                        } else if (parent.right != null){
                            runner.next = parent.right;
                            break;
                        } else {
                            parent = parent.next;
                        }
                    }
                }
                // update runner;
                runner = runner.next;
            }
            // update parent and mostLeft
            while (mostLeft != null&& mostLeft.left == null&& mostLeft.right == null){
                mostLeft = mostLeft.next;
            }
            if (mostLeft == null){
                return;
            }
            parent   = mostLeft;
            mostLeft = mostLeft.left != null ? mostLeft.left : mostLeft.right;
        }
    }

    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(1);

        root.left  = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);

        PopulateNextRightTwo p = new PopulateNextRightTwo();
        p.connect(root);
    }
}

class TreeLinkNode {
    int          val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x){
        val = x;
    }
}
