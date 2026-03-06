package com.leetcode.all.lc_0053_maximum_subarray;

/**
 * LeetCode 53. 最大子数组和
 * 链接：https://leetcode.cn/problems/maximum-subarray/
 *
 * @param
 * @return
 *
 * 思路：
 * -
 * -
 * -
 */

public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = nums[0];
        int len = nums.length;

        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }
}
