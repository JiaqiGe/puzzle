// Given a linked list, swap every two adjacent nodes and return its head.
//
// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.
//
// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
//
// Subscribe to see which companies asked this question.

class ListNode {
   int      val;
   ListNode next;
   ListNode(int x)
   {
      val = x;
   }
}

public class SwapPairs {
   public ListNode swapPairs(ListNode head)
   {
      if (head == null)
      {
         return null;
      }
      ListNode dummy1 = new ListNode(0);
      ListNode dummy2 = new ListNode(0);

      ListNode t1 = dummy1;
      ListNode t2 = dummy2;

      ListNode runner = head;
      while (runner != null)
      {
         if (runner.next == null)
         {
            t1.next = runner;
            t1      = t1.next;
            break;
         }
         else
         {
            ListNode n      = runner.next.next;
            ListNode addTo1 = runner;
            ListNode addTo2 = runner.next;

            t1.next = addTo1;
            t1      = t1.next;
            t1.next = null;

            t2.next = addTo2;
            t2      = t2.next;
            t2.next = null;

            runner = n;
         }
      }
      ListNode r1 = dummy1.next;
      ListNode r2 = dummy2.next;

      ListNode dummy = new ListNode(0);
      ListNode tail  = dummy;
      while (r1 != null&& r2 != null)
      {
         ListNode n1 = r1.next;
         ListNode n2 = r2.next;

         tail.next = r2;
         tail      = tail.next;
         tail.next = null;

         tail.next = r1;
         tail      = tail.next;
         tail.next = null;

         r1 = n1;
         r2 = n2;
      }
      if (r1 != null)
      {
         tail.next = r1;
         tail      = tail.next;
         tail.next = null;
      }
      return dummy.next;
   }

   public static void main(String[] args)
   {
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(2);
      ListNode n3 = new ListNode(3);
      ListNode n4 = new ListNode(4);

      n1.next = n2;
      n2.next = n3;
      n3.next = n4;

      SwapPairs s = new SwapPairs();
      ListNode  h = s.swapPairs(n2);
      while (h != null)
      {
         System.out.println(h.val);
         h = h.next;
      }
   }
}
