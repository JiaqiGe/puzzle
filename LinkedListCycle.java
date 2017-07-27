// Given a linked list, determine if it has a cycle in it.
//
// Follow up:
// Can you solve it without using extra space?
//

class ListNode {
    int      val;
    ListNode next;
    ListNode(int x){
        val  = x;
        next = null;
    }
}


public class LinkedListCycle {
    public boolean hasCycle(ListNode head){
      if(head == null || head.next == null){
        return false;
      }

      ListNode fast = head;
      ListNode slow = head;

      while(fast != null && slow != null && fast.next != null && slow.next != null){
        fast = fast.next.next;
        slow = slow.next;

        if(fast == slow){
          return true;
        }
      }

      return false;
    }
}