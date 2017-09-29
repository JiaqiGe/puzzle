//
// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
// Follow up:
// Could you do both operations in O(1) time complexity?
//
// Example:
//
// LRUCache cache = new LRUCache( 2 /* capacity */ );
//
// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
import java.util.*;

class ListNode {
    int      val;
    ListNode next;
    ListNode previous;

    public ListNode(int val){
        this.val = val;
    }
}

public class LRUCache {
    Map<Integer, ListNode> listMap;
    Map<Integer, Integer>  pairMap;
    ListNode               head;
    ListNode               tail;
    int capacity;

    public LRUCache(int capacity){
        this.pairMap  = new HashMap<>();
        this.listMap  = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key){
        // check if exists:
        //  no : return -1
        //  yes: move the corresponding node to the tail and return the val
        if (!pairMap.containsKey(key)){
            return -1;
        }

        ListNode node = listMap.get(key);
        // move node to the tail
        moveToTail(node);
        return pairMap.get(key);
    }

    public void put(int key, int value){
        if (pairMap.containsKey(key)){
            // move node to tail
            ListNode node = listMap.get(key);
            moveToTail(node);
        }else{
            if (pairMap.size() >= capacity){
                // remove key = head.val from two maps
                pairMap.remove(this.head.val);
                listMap.remove(this.head.val);
                // remove head from list
                removeHead();
            }

            pairMap.put(key, value);
            ListNode node = new ListNode(key);
            listMap.put(key, node);
            addToTail(node);
        }
    }

    private void removeHead(){
        this.head = this.head.next;
    }

    private void addToTail(ListNode node){
        if (this.head == null&& this.tail == null){
            this.head = node;
            this.tail = node;
            return;
        }

        tail.next     = node;
        node.previous = tail;

        tail = node;
    }

    private void moveToTail(ListNode node){
        if (this.head == null&& this.tail == null){
            this.head = node;
            this.tail = node;
        }

        if (node == this.head){
            this.head = this.head.next;

            this.tail.next = node;

            node.previous = this.tail;
            node.next     = null;

            this.tail = node;
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        LRUCache.print(cache.get(1)); // returns 1
        cache.put(3, 3);              // evicts key 2
        LRUCache.print(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4);              // evicts key 1
        LRUCache.print(cache.get(1)); // returns -1 (not found)
        LRUCache.print(cache.get(3)); // returns 3
        LRUCache.print(cache.get(4)); // returns 4
    }

    public static void print(int i){
        System.out.println(i);
    }
}
