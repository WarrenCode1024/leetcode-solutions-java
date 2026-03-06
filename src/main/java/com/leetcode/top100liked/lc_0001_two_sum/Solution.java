package com.leetcode.top100liked.lc_0001_two_sum;

import java.util.HashMap;

/**
 * @FileName: Solution.java
 * @Author: Warren Wei
 * @Date: 2025/10/21
 * @LeetCode: 0001 两数之和 (Two sum)
 * @Link: https://leetcode.com/problems/two-sum/
 * @Description:
 *
 * 使用哈希表实现 O(n) 解法。
 * 每次遍历时判断 (target - nums[i]) 是否已存在于哈希表中。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @Version: 1.0
 */

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // 获取数组的长度
        int n = nums.length;

        // 创建一个哈希表（键为数值，值为该数值对应的索引）
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍历数组中的每一个元素
        for (int i = 0; i < n; i++) {
            // 计算当前数对应的“目标差值”
            // 如果 target = 9，当前数是 2，那么我们需要找 9 - 2 = 7
            int complement = target - nums[i];

            // 判断哈希表中是否已经存在这个“目标差值”
            if (map.containsKey(complement)) {
                // 如果存在，说明我们找到了两个数的和等于 target
                // 返回这两个数的下标（哈希表中记录的索引 和 当前索引）
                return new int[]{map.get(complement), i};
            }

            // 如果没有找到，就把当前数值和它的索引存入哈希表
            map.put(nums[i], i);
        }

        // 如果遍历结束还没有找到符合条件的两个数，返回空数组
        return new int[]{};
    }
}

