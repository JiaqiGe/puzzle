// implement of red black tree


public class RedBlackTree {
    RedBlackTree parent;
    RedBlackTree left;
    RedBlackTree right;

    char color;
    int  val;

    public RedBlackTree(int val, char color){
        // constructor
        this.val   = val;
        this.color = color;
    }

    public RedBlackTree insert(int val){
        RedBlackTree node = new RedBlackTree(val, 'r');

        // insert as bst
        insertToBST(this, node);

        // fix red-black tree
        RedBlackTree runner = node.parent;

        while(runner != null){
          recolor(runner);
        }
    }

    private void recolor(RedBlackTree node){
      if(node.color == 'r'){
        if(node.left != null){
          node.left.color = 'b';
        }

        if(node.right != null){
          node.right.color = 'b';
        }
      }
      return;
    }

    // TODO: node.left != null
    private void rightRotate(RedBlackTree node){
        RedBlackTree x = node;
        RedBlackTree y = node.left;

        RedBlackTree yRight  = y.right;
        RedBlackTree xParent = x.parent;

        y.right  = x;
        x.parent = y;

        x.left = yRight;
        if (yRight != null){
            yRight.parent = x;
        }
        y.parent = xParent;
        return;
    }

    // TODO: node.right != null
    private void leftRotate(RedBlackTree node){
      RedBlackTree x = node;
      RedBlackTree y = node.right;

      RedBlackTree xParent = x.parent;
      RedBlackTree yLeft = y.left;

      y.left = x;
      x.parent = y;

      x.right = yLeft;
      if(yLeft != null){
        yLeft.parent = x;
      }
      y.parent = xParent;

      return;
    }

    private void insertToBST(RedBlackTree root, RedBlackTree node){
        if (root.left == null && root.right == null){
            if (node.val < root.val){
                root.left   = node;
                node.parent = root;
            }else if (node.val > root.val){
                root.right  = node;
                node.parent = root;
            }
            return;
        }

        if (node.val < root.val){
            if (root.left != null){
                insertToBST(root.left, node);
            }else{
                root.left   = node;
                node.parent = root;
                return;
            }
        }else if (node.val > root.val){
            if (root.right != null){
                insertToBST(root.right, node);
            }else{
                root.right  = node;
                node.parent = root;
                return;
            }
        }
    }
}
