package com.leetcode.all.lc_2348_number_of_zero_filled_subarrays;

/**
 * LeetCode 2348. 全 0 子数组的数目
 * 链接：https://leetcode.cn/problems/number-of-zero-filled-subarrays/
 *
 * @param nums 输入数组
 * @return 全 0 子数组总数
 *
 * 思路：
 * - 遍历数组统计连续 0 的长度
 * - 遇到 0 累加 count
 * - 遇到非 0 重置 count
 */

public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                ans += count;
            }else {
                count = 0;
            }
        }
        return ans;
    }
}

