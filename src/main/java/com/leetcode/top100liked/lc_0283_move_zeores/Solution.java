package com.leetcode.top100liked.lc_0283_move_zeores;

/**
 * @FileName: Solution.java
 * @Author: Warren Wei
 * @Date: 2025/11/3
 * @LeetCode: Easy 0283 移动零 (Move Zeros)
 * @Link: https://leetcode.com/problems//
 * @Description:
 * 时间复杂度：
 * 空间复杂度：
 * @Version: 1.0
 */

public class Solution {
    /**
     * 将数组中的所有零移动到末尾，保持非零元素的相对顺序。
     * 使用双指针（快慢指针）方法，通过交换操作，只需一次遍历。
     * @param nums 给定的整数数组
     */
    public void moveZeroes(int[] nums) {
        // 边界检查
        if (nums == null || nums.length <= 1) {
            return;
        }

        int slow = 0; // 慢指针

        // 遍历数组
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // 将非零元素与 slow 位置的元素交换
                // 这样可以把非零元素“推”到前面，同时把可能的零“推”到后面
                // 注意：当 slow == fast 时，交换是多余的，可以跳过
                if (slow != fast) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
                // 无论是否交换，slow 都需要前进
                slow++;
            }
        }
        // 循环结束后，slow 之后的元素自然就是零了
    }

    // --- 测试代码 ---
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("原数组: " + java.util.Arrays.toString(nums1));
        solution.moveZeroes(nums1);
        System.out.println("移动后: " + java.util.Arrays.toString(nums1)); // 期望: [1, 3, 12, 0, 0]
        System.out.println();

        // 测试用例2
        int[] nums2 = {0};
        System.out.println("原数组: " + java.util.Arrays.toString(nums2));
        solution.moveZeroes(nums2);
        System.out.println("移动后: " + java.util.Arrays.toString(nums2)); // 期望: [0]
        System.out.println();

        // 测试用例3
        int[] nums3 = {1, 0, 2, 0, 3, 0, 4};
        System.out.println("原数组: " + java.util.Arrays.toString(nums3));
        solution.moveZeroes(nums3);
        System.out.println("移动后: " + java.util.Arrays.toString(nums3)); // 期望: [1, 2, 3, 4, 0, 0, 0]
    }
}
