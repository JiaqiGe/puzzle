// Sort a linked list using insertion sort.
//

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}


public class ListInsertSort {
    public ListNode insertionSortList(ListNode head){
      if(head == null){
        return head;
      }

      ListNode dummyHead = new ListNode(Integer.MIN_VALUE);

      ListNode node = head;

      while(node != null){
        ListNode nextNode = node.next;
        // insert runner
        ListNode runner = dummyHead;
        while(true){
          if(runner == null){
            break;
          }

          if(runner.next != null && node.val >= runner.val && node.val <= runner.next.val){
              // insert node after runner
              ListNode next = runner.next;
              runner.next = node;
              node.next = next;
              break;
          }

          if(runner.next == null && runner.val <= node.val){
              // insert node to tail
              runner.next = node;
              node.next = null;
              break;
          }
          runner = runner.next;
        }

        node = nextNode;
      }

      return dummyHead.next;
    }
}
