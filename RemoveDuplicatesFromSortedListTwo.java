// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.
//
public class RemoveDuplicatesFromSortedListTwo{
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode runner = head;
        ListNode tail = dummy;

        while(runner != null){
            if(runner.next == null || runner.val != runner.next.val){
                //append runner to tail
                ListNode next = runner.next;

                tail.next = runner;
                tail = tail.next;
                tail.next = null;

                runner = next;
            }else{
                //duplicates
                ListNode newRunner = runner.next;
                while(newRunner != null && newRunner.val == runner.val){
                    newRunner = newRunner.next;
                }
                runner = newRunner;
            }
        }

        return dummy.next;
   }

   public static void main(String[] args){
       RemoveDuplicatesFromSortedListTwo r  = new RemoveDuplicatesFromSortedListTwo();
       ListNode n1 = new ListNode(1);
       ListNode n2 = new ListNode(1);
       ListNode n3 = new ListNode(2);
       ListNode n4 = new ListNode(3);

       n1.next = n2;
       n2.next = n3;
       n3.next = n4;

       ListNode head = r.deleteDuplicates(n1);
       while(head != null){
           System.out.println(head.val);
           head = head.next;
       }
   }
}

class ListNode {
    int      val;
    ListNode next;
    ListNode(int x){ val = x; }
}
