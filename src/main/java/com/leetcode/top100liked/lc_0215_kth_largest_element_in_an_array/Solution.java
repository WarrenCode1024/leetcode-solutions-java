package com.leetcode.top100liked.lc_0215_kth_largest_element_in_an_array;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {

        // 创建最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            // 如果堆的大小超过 k，移除最小的元素（堆顶）
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 堆顶即为第 k 大的元素
        return minHeap.peek();

    }
}
