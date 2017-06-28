// Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

public class RemoveDuplicatesFromSortedList{
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode runner = head.next;
        ListNode tail = head;
        head.next = null;

        while(runner != null){
            if(runner.val != tail.val){
                ListNode next = runner.next;
                tail.next = runner;
                tail = tail.next;
                tail.next = null;
                runner = next;
            }else{
                runner = runner.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedList r  = new RemoveDuplicatesFromSortedList();
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
