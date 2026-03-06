package com.leetcode.top100liked.lc_0160_intersection_of_two_linked_lists;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;


        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != pB) {
            if(pA == null){
                pA = headB;
            }else {
                pA = pA.next;
            }
            if(pB == null){
                pB = headA;
            }else{
                pB = pB.next;
            }
        }
        return pA;
    }
}
//
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) return null;
//
//        // 1. 计算长度
//        int lenA = getLength(headA);
//        int lenB = getLength(headB);
//
//        // 2. 对齐起点
//        ListNode pA = headA;
//        ListNode pB = headB;
//
//        if (lenA > lenB) {
//            for (int i = 0; i < lenA - lenB; i++) {
//                pA = pA.next;
//            }
//        } else {
//            for (int i = 0; i < lenB - lenA; i++) {
//                pB = pB.next;
//            }
//        }
//
//        // 3. 同步寻找交点
//        while (pA != pB) {
//            pA = pA.next;
//            pB = pB.next;
//        }
//
//        return pA;
//    }
//
//    private int getLength(ListNode head) {
//        int length = 0;
//        while (head != null) {
//            length++;
//            head = head.next;
//        }
//        return length;
//    }
//}
