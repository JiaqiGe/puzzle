// Given a singly linked list L: L0?L1?…?Ln-1?Ln,
// reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
//
// You must do this in-place without altering the nodes' values.
//
// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.
class ListNode {
    int      val;
    ListNode next;
    ListNode(int x){
        val  = x;
        next = null;
    }
}

public class ReorderList {
    public void reorderList(ListNode head){
        if (head == null || head.next == null || head.next.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
          slow = slow.next;
          fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverse(head2);
        head = merge(head, head2);
    }

    private ListNode merge(ListNode h1, ListNode h2){
      if(h1 == null || h2 == null){
        return null;
      }

      ListNode dummyHead = new ListNode(0);
      ListNode tail  = dummyHead;
      ListNode r1 = h1;
      ListNode r2 = h2;

      while(r1 != null && r2 != null){
        ListNode n1 = r1.next;
        ListNode n2 = r2.next;

        r1.next = null;
        r2.next = null;

        tail.next = r1;
        tail = tail.next;

        tail.next = r2;
        tail = tail.next;

        r1 = n1;
        r2 = n2;
      }

      if(r1 != null){
        tail.next = r1;
      }else if(r2 != null){
        tail.next = r2;
      }

      return dummyHead.next;
    }

    private ListNode reverse(ListNode head){
      if(head == null){
        return null;
      }

      ListNode head2 = head;
      ListNode runner = head.next;
      head2.next = null;

      while(runner != null){
          ListNode next = runner.next;
          runner.next = head2;
          head2 = runner;
          runner = next;
      }

      return head2;
    }
}
