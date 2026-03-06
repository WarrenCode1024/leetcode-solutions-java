package com.leetcode.top100liked.lc_0053_maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        if(n == 0) return 0;

        // dp[i] 表示以 nums[i] 结尾的最大子数组和
        int[] dp = new int[n];

        // 初始化
        dp[0] = nums[0];
        int maxSum = dp[0];

        for(int i = 1; i<n; i++){
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}

//思路
//定义 currentSum 表示以当前元素结尾的最大子数组和。
//定义 maxSum 表示全局最大的子数组和。
//对于每个元素 nums[i]，我们有两个选择：
//将其加入之前的子数组：currentSum + nums[i]
//从当前元素重新开始：nums[i]
//取两者较大值：currentSum = Math.max(nums[i], currentSum + nums[i])
//更新全局最大值 maxSum。

//class Solution {
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        // 初始化：当前和与最大和都设为第一个元素
//        int currentSum = nums[0];
//        int maxSum = nums[0];
//
//        // 从第二个元素开始遍历
//        for (int i = 1; i < nums.length; i++) {
//            // 核心状态转移方程：
//            // 如果前面的和是负数，加上它只会变小，不如直接从当前元素开始
//            // 如果前面的和是正数，加上它会变大，就继续累加
//            currentSum = Math.max(nums[i], currentSum + nums[i]);
//
//            // 更新全局最大值
//            maxSum = Math.max(maxSum, currentSum);
//        }
//
//        return maxSum;
//    }
//}
