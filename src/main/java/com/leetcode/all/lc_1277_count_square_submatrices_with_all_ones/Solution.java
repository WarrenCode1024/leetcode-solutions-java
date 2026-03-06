package com.leetcode.all.lc_1277_count_square_submatrices_with_all_ones;

public class Solution {
    /**
     * 统计全为 1 的正方形子矩阵的数量
     * 使用动态规划方法
     *
     * 解题思路：
     * 1. dp[i][j] 表示以 (i,j) 为右下角的正方形的最大边长
     * 2. 如果 matrix[i][j] == 1，则 dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
     * 3. 累加所有 dp[i][j] 的值即为答案
     *
     * @param matrix 输入的二维矩阵，只包含 0 和 1
     * @return 全为 1 的正方形子矩阵的数量
     */
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // dp[i][j] 表示以 (i,j) 为右下角的最大正方形的边长
        int[][] dp = new int[rows][cols];
        int totalSquares = 0;

        // 初始化第一行
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
            totalSquares += dp[0][j];
        }

        // 初始化第一列（跳过 [0,0] 已经处理过）
        for (int i = 1; i < rows; i++) {
            dp[i][0] = matrix[i][0];
            totalSquares += dp[i][0];
        }

        // 填充其余位置
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    // 当前位置为1时，正方形边长取决于三个相邻位置的最小值+1
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
                totalSquares += dp[i][j];
            }
        }

        return totalSquares;
    }

    // 测试方法
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例1
        int[][] matrix1 = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        System.out.println("输入矩阵1:");
        printMatrix(matrix1);
        System.out.println("输出: " + solution.countSquares(matrix1));
        System.out.println("解释: 有10个1x1正方形，4个2x2正方形，1个3x3正方形，共15个");
        System.out.println();

        // 测试用例2
        int[][] matrix2 = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        System.out.println("输入矩阵2:");
        printMatrix(matrix2);
        System.out.println("输出: " + solution.countSquares(matrix2));
        System.out.println("解释: 有6个1x1正方形，1个2x2正方形，共7个");
        System.out.println();

        // 测试用例3: 全为0的矩阵
        int[][] matrix3 = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        System.out.println("输入矩阵3 (全为0):");
        printMatrix(matrix3);
        System.out.println("输出: " + solution.countSquares(matrix3));
        System.out.println();

        // 测试用例4: 全为1的矩阵
        int[][] matrix4 = {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };
        System.out.println("输入矩阵4 (全为1):");
        printMatrix(matrix4);
        System.out.println("输出: " + solution.countSquares(matrix4));
        System.out.println("解释: 有9个1x1正方形，4个2x2正方形，1个3x3正方形，共14个");
    }

    // 辅助方法：打印矩阵
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}