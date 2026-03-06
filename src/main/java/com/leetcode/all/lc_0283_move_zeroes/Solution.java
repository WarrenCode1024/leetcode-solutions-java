package com.leetcode.all.lc_0283_move_zeroes;

/**
 * @author
 * @desc 283. 移动零
 * @date 2025/8/14 16:48
 */

public class Solution {
    // 双指针覆盖法
    // public void moveZeroes(int[] nums) {

    //     int pos = 0;
    //     // 指向下一个非零应该放的位置
    //     for (int num : nums) {
    //         if (num != 0) {
    //             nums[pos++] = num;
    //         }
    //     }
    //     // 将剩下的位置全部置 0
    //     while (pos < nums.length) {
    //         nums[pos++] = 0;
    //     }
    // }

    // 双指针交换法
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}