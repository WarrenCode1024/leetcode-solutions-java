package com.leetcode.top100liked.lc_0055_jump_game;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) return true; // 边界情况，虽然题目通常保证非空

        int maxReach = 0; // 当前能到达的最远下标

        for (int i = 0; i < n; i++) {
            // 如果当前下标超过了能到达的最远距离，说明无法继续前进
            if (i > maxReach) {
                return false;
            }

            // 更新最远能到达的距离
            // 当前位置 i 加上能跳的步数 nums[i]
            maxReach = Math.max(maxReach, i + nums[i]);

            // 优化：如果最远距离已经能覆盖终点，提前返回
            if (maxReach >= n - 1) {
                return true;
            }
        }

        return true;
    }
}
