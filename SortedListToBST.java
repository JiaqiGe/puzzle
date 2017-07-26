// Convert Sorted List to Binary Search Tree
// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

public class SortedListToBST{
  public TreeNode sortedListToBST(ListNode head){
      //divide and conquer
      if(head == null){
        return null;
      }

      if(head.next == null){
        return new TreeNode(head.val);
      }

      // get the length of List
      int count = 0;
      ListNode runner = head;
      while(runner != null){
          runner = runner.next;
          count ++;
      }

      int mid = count / 2;

      if(mid == 0){
          TreeNode root = new TreeNode(head.val);
          root.left = null;
          root.right = sortedArrayToBST(head.next);
          return root;
      }

      count = 0;
      runner = head;
      while(count < mid - 1){
        count ++;
        runner = runner.next;
      }

      TreeNode root = new TreeNode(runner.next.val);
      TreeNode right = sortedArrayToBST(runner.next.next);
      runner.next = null;
      TreeNode left = sortedArrayToBST(head);

      root.left = left;
      root.right = right;
      return root;


  }
}

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
