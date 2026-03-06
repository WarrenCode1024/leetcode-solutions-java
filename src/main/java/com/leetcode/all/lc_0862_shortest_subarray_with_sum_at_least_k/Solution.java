package com.leetcode.all.lc_0862_shortest_subarray_with_sum_at_least_k;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author
 * @desc 862. 和至少为 K 的最短子数组
 * @date 2025/8/17 15:44
 */

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int res = n + 1;
        Deque<Integer> deque = new LinkedList<>();

        for (int j = 0; j < prefix.length; j++) {
            // 检查队首是否满足条件
            while (!deque.isEmpty() && prefix[j] - prefix[deque.peekFirst()] >= k) {
                res = Math.min(res, j - deque.pollFirst());
            }

            // 保持队列单调递增
            while (!deque.isEmpty() && prefix[j] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(j);
        }
        return res <= n ? res : -1;
    }
}
