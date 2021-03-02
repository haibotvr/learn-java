package com.simon.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author simon.wei
 */
public class LRUCache {

    private class CacheNode {

        public CacheNode prev;

        public CacheNode next;

        public int key;

        public int value;

        public CacheNode(int key, int value) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private Map<Integer, CacheNode> valueMap = new HashMap<>();

    private CacheNode head = new CacheNode(-1, -1);

    private CacheNode tail = new CacheNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!valueMap.containsKey(key)) {
            return -1;
        }
        CacheNode current = valueMap.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        return current.value;
    }

    private void moveToTail(CacheNode current) {
        current.prev = tail.prev;
        current.next = tail;
        tail.prev.next = current;
        tail.prev = current;
    }

    public void put(int key, int value) {
        if(get(key) != -1) {
            valueMap.get(key).value = value;
            return;
        }
        if(valueMap.size() == capacity) {
            valueMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        CacheNode node = new CacheNode(key, value);
        moveToTail(node);
        valueMap.put(key, node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        cache.get(5);
        cache.get(2);
        System.out.println();

    }
}
