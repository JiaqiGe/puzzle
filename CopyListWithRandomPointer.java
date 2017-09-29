// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
// Return a deep copy of the list.
import java.util.*;

class RandomListNode {
    int            label;
    RandomListNode next, random;
    RandomListNode(int x){ this.label = x; }
};


public class CopyListWithRadomPointer {
    public RandomListNode copyRandomList(RandomListNode head){
        if (head == null){
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode runner = head;
        while(runner != null){
          RandomListNode copy = new RandomListNode(runner.label);
          map.put(runner, copy);

          runner = runner.next;
        }

        runner = head;
        while(runner != null){
          RandomListNode copy = map.get(runner);

          if(runner.next != null){
            copy.next = map.get(runner.next);
          }
          if(runner.random != null){
            copy.random = map.get(runner.random);
          }

          runner = runner.next;
        }

        return map.get(head);
    }
}
