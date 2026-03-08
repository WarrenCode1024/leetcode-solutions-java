package com.leetcode.top100liked.lc_0142_linked_list_cycle_ii;


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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;  // 链表为空或者只有一个节点没有环
        }

        ListNode slow = head;
        ListNode fast = head;

        // 步骤 1: 快慢指针相遇，判断是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;           // 慢指针走一步
            fast = fast.next.next;      // 快指针走两步

            if (slow == fast) {         // 如果相遇，说明有环
                // 步骤 2: 找环的入口
                ListNode pointer = head;
                while (pointer != slow) {
                    pointer = pointer.next;
                    slow = slow.next;
                }
                return pointer;  // 两者相遇的地方就是环的入口节点
            }
        }

        return null;  // 没有环，返回 null
    }
}