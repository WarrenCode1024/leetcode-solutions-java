package com.leetcode.top100liked.lc_0279_perfect_squares;

public class Solution {
    public int numSquares(int n) {
        // dp[i] 表示凑齐整数 i 所需的最少完全平方数个数
        int[] dp = new int[n + 1];

        // 初始化 dp 数组，因为最多用 n 个 1 相加，所以初始化为 i 即可
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        // dp[0] 默认就是 0

        // 外层循环遍历每一个数字 i
        for (int i = 1; i <= n; i++) {
            // 内层循环遍历所有可能的完全平方数 j*j
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
