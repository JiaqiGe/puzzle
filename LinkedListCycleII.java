// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
// Note: Do not modify the linked list.
//
// Follow up:
// Can you solve it without using extra space?


public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head){
      if(head == null || head.next == null){
        return null;
      }

      ListNode fast = head;
      ListNode slow = head;

      while(true){
        if(fast == null || fast.next == null || slow == null || slow.next == null){
          return null;
        }

        fast = fast.next.next;
        slow = slow.next;

        if(fast == slow){
          break;
        }
      }

      slow = head;
      while(slow != fast){
        slow = slow.next;
        fast = fast.next;
      }
      return slow;
    }
}
