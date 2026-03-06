package com.leetcode.all.lc_0239_sliding_window_maximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author
 * @desc 239. 滑动窗口最大值
 * @date 2025/8/16 17:02
 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k == 0) return new int[0];

        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();  // 存下标


        for (int i = 0; i < n; i++) {
            // 移除不在窗口的元素下标
            while(!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 保持队列单调递减，移除比当前元素小的
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // 记录窗口最大值（从第 k-1 开始）
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
