package com.leetcode.all.lc_0011_container_with_most_water;

/**
 * @author
 * @desc 11. 盛最多水的容器
 * @date 2025/8/14 20:17
 */


public class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
