// Sort a linked list in O(n log n) time using constant space complexity.

public class SortList {
    public ListNode sortList(ListNode head){
        // merge sort
        if ((head == null) || (head.next == null)){
            return head;
        }

        // divide
        ListNode head2 = split(head);

        ListNode p1 =  sortList(head);
        ListNode p2 = sortList(head2);

        // merge
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while(p1 != null && p2 != null){
          if(p1.val <= p2.val){
              ListNode next = p1.next;
              tail.next = p1;
              tail = tail.next;
              tail.next = null;
          }else{
            ListNode next = p2.next;
            tail.next = p2;
            tail = tail.next;
            tail.next = null;
          }
        }

        if(p1 != null){
          tail.next = p1;
        }else if(p2 != null){
          tail.next = p2;
        }

        return dummyHead.next;
    }

    private ListNode split(ListNode head){
        if ((head == null) || (head.next == null)){
            return head;
        }

        if(head.next.next == null){
          ListNode head2 = head.next;
          head.next = null;
          return head2;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if ((fast == null) || (fast.next == null)){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }
}
