package com.leetcode.all.lc_0015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @FileName: Solution.java
 * @Author: Warren Wei
 * @Date: 2025/10/21
 * @LeetCode: 0015 三数之和 (3 sum)
 * @Link: https://leetcode.com/problems/3sum/
 * @Description:
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c，
 * 使得 a + b + c = 0？找出所有满足条件且不重复的三元组。
 *
 * 解题思路：
 * 1. 对数组排序，便于去重与双指针搜索；
 * 2. 遍历每个 nums[i] 作为三元组第一个元素；
 * 3. 使用左右指针寻找剩余两个元素，使三数之和为 0；
 * 4. 跳过重复元素，保证每个三元组唯一。
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)（不含结果列表占用空间）
 *
 * @Version: 1.0
 */


class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        // 用于存储最终结果的二维列表
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // 先对数组进行排序，便于后续使用双指针去重和寻找组合
        Arrays.sort(nums);

        // 遍历数组，每个 nums[i] 作为三元组的第一个元素
        for (int i = 0; i < n - 2; i++) {

            // 如果当前元素和前一个元素相同，跳过，避免重复三元组
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 左右指针初始化
            int left = i + 1;
            int right = n - 1;

            // 双指针查找两数，使三数之和为 0
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到符合条件的三元组，加入结果列表
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的 left 元素
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // 跳过重复的 right 元素
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // 移动指针，寻找新的组合
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 如果和小于 0，左指针右移，使 sum 变大
                    left++;
                } else {
                    // 如果和大于 0，右指针左移，使 sum 变小
                    right--;
                }
            }
        }

        // 返回所有符合条件的三元组
        return res;
    }
}
