package com.leetcode.topinterview150.lc_0036_valid_sudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {

        // 定义三个二维数组用于记录
        // 第一维表示：第几行 / 第几列 / 第几个宫 (0-8)
        // 第二维表示：数字 1-9 (映射为 0-8)
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char c = board[i][j];

                // 如果是空白格，跳过
                if (c == '.') {
                    continue;
                }

                // 将字符 '1'-'9' 转换为索引 0-8
                int numIndex = c - '1';

                // 计算当前单元格所属的九宫格索引
                int boxIndex = (i / 3) * 3 + (j / 3);

                // 检查该数字是否已经在当前行、列或宫中出现过
                if (rows[i][numIndex] || cols[j][numIndex] || boxes[boxIndex][numIndex]) {
                    return false;
                }

                // 标记该数字已出现
                rows[i][numIndex] = true;
                cols[j][numIndex] = true;
                boxes[boxIndex][numIndex] = true;
            }
        }
        return true;
    }
}
