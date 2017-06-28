// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
// You should preserve the original relative order of the nodes in each of the two partitions.
//
// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.
public class PartitionList{
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }

        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);

        ListNode tail1 = d1;
        ListNode tail2 = d2;

        ListNode runner = head;

        while(runner != null){
            int val = runner.val;
            ListNode next = runner.next;
            if(val < x){
                //add current to the end of d1
                tail1.next = runner;
                tail1 = tail1.next;
                tail1.next = null;
            }else{
                // add to the end of d2
                tail2.next = runner;
                tail2 = tail2.next;
                tail2.next = null;
            }

            runner = next;
        }

        //merge d1 and d2
        tail1.next = d2.next;
        d2.next = null;

        return d1.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        PartitionList p = new PartitionList();
        ListNode head = p.partition(n1, 3);

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
