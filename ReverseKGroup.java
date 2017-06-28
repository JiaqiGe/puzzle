// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
// You may not alter the values in the nodes, only nodes itself may be changed.
//
// Only constant memory is allowed.
//
// For example,
// Given this linked list: 1->2->3->4->5
//
// For k = 2, you should return: 2->1->4->3->5
//
// For k = 3, you should return: 3->2->1->4->5

class ListNode {
   int      val;
   ListNode next;
   ListNode(int x)
   {
      val = x;
   }
}

public class ReverseKGroup {
   public ListNode reverseKGroup(ListNode head, int k)
   {
      if (head == null) {
         return null;
      }

      ListNode[] heads = new ListNode[k];
      ListNode[] tails = new ListNode[k];

      for (int i = 0; i < heads.length; i++) {
         ListNode dummy = new ListNode(0);
         heads[i] = dummy;
         tails[i] = dummy;
      }

      ListNode runner = head;
      while (runner != null) {
         //append the first k node to lists
         int i = 0;
         while (i < k && runner != null) {
            ListNode next = runner.next;

            tails[i].next = runner;
            tails[i]      = runner;
            runner.next   = null;
            runner        = next;
            i++;
         }
      }

      for (int i = 0; i < heads.length; i++) {
         heads[i] = heads[i].next;
      }

      //revese each group
      ListNode d = new ListNode(0);
      ListNode t = d;

      while (true) {
         boolean isReversable = true;
         for (ListNode n : heads) {
            if (n == null) {
               isReversable = false;
               break;
            }
         }

         if (!isReversable) {
            break;
         }
         //append the head to t in reversed order
         for (int i = heads.length-1; i >= 0; i--) {
           ListNode cur = heads[i];
           ListNode next = cur.next;

           //add cur to t
           t.next = cur;
           t = t.next;
           t.next = null;

           heads[i] = next;
         }
      }

      //add the remaining in order
      for(int i = 0; i < heads.length; i++){
        if(heads[i] != null){
            //add heads[i] to t
            t.next = heads[i];
            t = t.next;
            t.next = null;
        }else{
            break;
        }
      }

      return d.next;
   }

   public static void main(String[] args){
       ListNode n1 = new ListNode(1);
       ListNode n2 = new ListNode(2);
       ListNode n3 = new ListNode(3);
       ListNode n4 = new ListNode(4);

       n1.next = n2;
       n2.next = n3;
       n3.next = n4;

       ReverseKGroup s = new ReverseKGroup();
       ListNode  h = s.reverseKGroup(n1,3);
       while (h != null)
       {
          System.out.println(h.val);
          h = h.next;
       }
   }
}
