// Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
// return 1->4->3->2->5->NULL.
//
// Note:
// Given m, n satisfy the following condition:
// 1 <= m <= n <= length of list.

public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int m, int n){
        if (head == null){
            return null;
        }

        if(m == n){
          return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int count = 0;
        ListNode runner = dummyHead;

        while(count < m - 1){
          runner = runner.next;
          count ++;
        }

        ListNode tail1 = runner;
        runner = runner.next;
        count ++;
        tail1.next = null;

        ListNode tail2 = runner;
        ListNode head2 = null;

        while(count <= n){
          ListNode next = runner.next;
          runner.next = head2;
          head2 = runner;
          runner = next;
          count++;
        }

        ListNode head3 = runner;

        tail1.next = head2;
        tail2.next = head3;

        return dummyHead.next;
    }
}
class ListNode {
    int      val;
    ListNode next;
    ListNode(int x){ val = x; }
}
