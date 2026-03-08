package com.leetcode.top100liked.lc_0002_add_two_numbers;


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个虚拟头节点
        ListNode dummy = new ListNode(0);
        // 当前处理的节点
        ListNode cur = dummy;
        int carry = 0;  // 存储进位

        // 遍历两个链表
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;    // 初始化sum为进位

            // 如果l1不为空，取l1的当前值
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // 如果l2不为空，取l2的当前值
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // 更新进位
            carry = sum / 10;

            // 创建一个新的节点，存储当前位的值
            cur.next = new ListNode(sum % 10);

            // 移动指针到新的节点
            cur = cur.next;
        }

        // 返回虚拟头节点的下一个节点，即结果链表的头
        return dummy.next;
    }
}
