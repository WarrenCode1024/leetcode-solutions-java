package com.leetcode.top100liked.lc_0075_sort_colors;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;                   // 指向下一个存放 0 的位置
        int right = nums.length - 1;    // 指向下一个存放 2 的位置
        int curr = 0;                   // 当前遍历的指针

        while (curr <= right) {
            // 发现 0，换到左边
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                left++;
                curr++;
            }else if (nums[curr] == 2) {
                // 发现 2，换到右边
                swap(nums, curr, right);
                right--;
                // 注意：这里 curr 不需要 ++，因为换过来的新数还需要在下一轮继续判断
            }else{
                // 发现 1，保持不动，继续往前走
                curr++;
            }
        }
    }

    // 辅助交互函数
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
