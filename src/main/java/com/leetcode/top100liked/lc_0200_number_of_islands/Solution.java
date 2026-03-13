package com.leetcode.top100liked.lc_0200_number_of_islands;

public class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        // 1. 遍历每一个格子
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 2. 如果发现陆地
                if (grid[i][j] == '1') {
                    count++; // 岛屿数 +1
                    dfs(grid, i, j); // 3. 淹没整座岛屿
                }
            }
        }
        return count;
    }

    /**
     * DFS 辅助函数：将当前陆地及其相连的所有陆地标记为 '0'
     */
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 边界检查 & 终止条件：
        // 如果越界，或者当前格子是水('0')，则停止递归
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // 标记当前陆地为已访问（淹没）
        grid[r][c] = '0';

        // 递归搜索上下左右四个方向
        dfs(grid, r - 1, c); // 上
        dfs(grid, r + 1, c); // 下
        dfs(grid, r, c - 1); // 左
        dfs(grid, r, c + 1); // 右
    }
}
