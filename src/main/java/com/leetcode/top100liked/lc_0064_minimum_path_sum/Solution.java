package com.leetcode.top100liked.lc_0064_minimum_path_sum;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        // 1. 初始化第一行（只能从左边往右走）
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // 2. 初始化第一列（只能从上面往下走）
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // 3. 填充其余的常规格子
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // 当前格子的数字 + 左边和上边的最小值
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // 右下角的格子就是最终的最小路径和
        return grid[rows - 1][cols - 1];
    }
}
