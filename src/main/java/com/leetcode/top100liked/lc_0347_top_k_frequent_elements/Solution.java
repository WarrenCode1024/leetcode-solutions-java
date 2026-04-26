package com.leetcode.top100liked.lc_0347_top_k_frequent_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // 1. 统计频率
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        // 2. 使用最小堆维护前 k 个高频元素
        // 比较器：按照频率从小到大排序 (o1 -> map.get(o1))
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (o1, o2) -> map.get(o1) - map.get(o2)
        );

        // 遍历所有不重复元素
        for(int num : map.keySet()){
            minHeap.offer(num);
            // 如果堆大小超过 k，移除频率最小的元素（堆顶）
            if (minHeap.size() > k) {
                minHeap.poll();

            }
        }

        // 3. 将堆中元素转为数组
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;

    }
}
