package com.leetcode.top100liked.lc_0146_lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // 定义双向链表节点
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(){
        }

        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int size;

    // 伪头结点和伪尾结点
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        // 初始化双向链表
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 如果 key 存在，先通过哈希表定位，再将该节点移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            // 如果 key 不存在，创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);

            // 添加进哈希表
            cache.put(key, newNode);

            // 添加到双向链表头部
            addToHead(newNode);

            size++;

            // 如果超出容量，删除双向链表尾部节点
            if (size > capacity) {
                // 删除尾部节点
                DLinkedNode tailNode = removeTail();
                // 从哈希表中删除
                cache.remove(tailNode.key);
                size--;
            }
        }else {
            // 如果 key 存在，更新 value，并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // --- 辅助函数：操作双向链表 ---

    // 在头部添加节点
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将节点移动到头部 (先删除，再添加到头部)
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除尾部节点并返回
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
