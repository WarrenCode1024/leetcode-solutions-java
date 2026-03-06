package com.leetcode.top100liked.lc_0073_set_matrix_zeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        // 1. 标记第一行和第一列原本是否有 0
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // 检查第一行
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // 检查第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // 2. 使用第一行和第一列作为标记数组
        // 遍历除第一行第一列之外的元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 标记对应的行首和列首
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. 根据标记将内部元素置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果该行首或该列首为 0，则当前元素置 0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. 最后处理第一行和第一列
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}