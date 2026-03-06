package com.leetcode.top100liked.lc_0042_trapping_rain_water;

/**
 * @FileName: Solution.java
 * @Author: Warren Wei
 * @Date: 2025/11/3
 * @LeetCode: Hard 0043 接雨水 (Trapping Rain Water)
 * @Link: https://leetcode.com/problems/trapping-rain-water/
 * @Description:
 *
 * 时间复杂度：
 * 空间复杂度：
 * @Version: 1.0
 */
public class Solution {
    /**
     * 使用双指针法求解接雨水问题。
     * 空间复杂度 O(1)，最优解。
     * @param height 表示柱子高度的数组
     * @return 能接到的雨水总量
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0; // 左指针
        int right = height.length - 1; // 右指针
        int leftMax = 0; // left 指针左侧的最大高度
        int rightMax = 0; // right 指针右侧的最大高度
        int water = 0; // 总水量

        while (left < right) {
            // 更新左右两侧的最大高度
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 核心：比较 leftMax 和 rightMax
            if (leftMax < rightMax) {
                // leftMax 较小，说明 left 位置的瓶颈在左边
                // 此时 rightMax 更大，保证了右边有墙，所以可以计算 left 位置的水量
                water += leftMax - height[left];
                left++; // 移动左指针
            } else {
                // rightMax 较小或相等，说明 right 位置的瓶颈在右边
                water += rightMax - height[right];
                right--; // 移动右指针
            }
        }

        return water;
    }
}

