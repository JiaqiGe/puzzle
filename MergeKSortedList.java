
  // Definition for singly-linked list.
import java.util.*;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
          return null;
        }

        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
          public int compare(ListNode n1, ListNode n2){
            return n1.val - n2.val;
          }
        });

        for(ListNode node : lists){
          q.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!q.isEmpty()){
          ListNode n = q.poll();
          //append node n to tail
          ListNode next = n.next;
          tail.next = n;
          tail = tail.next;
          tail.next = null;

          if(next != null){
            q.offer(next);
          }
        }

        return dummy.next;
    }

    public static void main(String[] args){
      ListNode a1 = new ListNode(1);
      ListNode a2 = new ListNode(2);
      ListNode a3 = new ListNode(5);

      ListNode b1 = new ListNode(3);
      ListNode b2 = new ListNode(4);

      a1.next = a2;
      a2.next = a3;

      // b1.next = b2;

      ListNode[] lists = new ListNode[2];
      lists[0] = a1;
      lists[1] = b1;

      MergeKSortedList m = new MergeKSortedList();
      ListNode h = m.mergeKLists(lists);

      while(h != null){
        System.out.println(h.val);
        h = h.next;
      }



    }
}
