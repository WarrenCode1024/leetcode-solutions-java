package com.leetcode.top100liked.lc_1143_longest_common_subsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // dp[i][j] 代表 text1 前 i 个字符与 text2 前 j 个字符的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        // 嵌套遍历两个字符串
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 注意：dp 数组索引从 1 开始，对应的字符串字符索引要减 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 如果字符相等，找到一个公共字符，长度在左上方子问题基础上 +1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不相等，取「上方」或「左方」的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 右下角的值即为最终结果
        return dp[m][n];
    }
}