package com.leetcode.top100liked.lc_0141_linked_list_cycle;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;  // 空链表或只有一个节点，不可能有环
        }

        ListNode slow = head;
        ListNode fast = head;

        // 快慢指针同时向前走，快指针走两步，慢指针走一步
        while (fast != null && fast.next != null) {
            slow = slow.next;           // 慢指针走一步
            fast = fast.next.next;      // 快指针走两步

            if (slow == fast) {         // 如果相遇，说明有环
                return true;
            }
        }

        // 如果快指针到达 null，则链表没有环
        return false;
    }
}
