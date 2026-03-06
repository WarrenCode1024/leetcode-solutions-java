package com.leetcode.all.lc_0560_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @desc 560. 和为 K 的子数组
 * @date 2025/8/16 10:49
 */

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 保存前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和为 0 出现 1 次
        map.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            // 更新当前前缀和出现次数
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
