package com.leetcode.top100liked.lc_0021_merge_two_sorted_lists;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 创建一个虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 迭代合并两个有序链表
        while (list1 != null && list2 != null) {
            // 选择较小的节点
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            // 移动当前指针
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;

        return dummy.next;
    }
}
