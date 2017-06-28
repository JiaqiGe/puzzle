// Given a list, rotate the list to the right by k places, where k is non-negative.
//
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

public class RotateList {
    public ListNode rotateRight(ListNode head, int k){
        if(head == null){
            return head;
        }

        ListNode runner = head;
        int count = 0;
        while(runner != null){
            count ++;
            runner = runner.next;
        }

        k = k % count;

        if( k == 0){
            return head;
        }

        runner = head;

        for(int i = 1; i < count - k; i++){
            runner = runner.next;
        }

        ListNode newHead = runner.next;
        runner.next = null;

        runner = newHead;

        while(runner.next != null){
            runner = runner.next;
        }

        runner.next = head;

        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k){
        if(head == null){
            return head;
        }

        ListNode runner = head;
        int count = 1;

        while(runner.next != null){
            count ++;
            runner = runner.next;
        }

        runner.next = head;
        runner = head;
        k = count - k % count;
        for(int i = 1; i < k; i++){
            runner = runner.next;
        }

        ListNode newHead = runner.next;
        runner.next = null;

        return newHead;

    }
}


class ListNode {
    int      val;
    ListNode next;
    ListNode(int x){ val = x; }
}
