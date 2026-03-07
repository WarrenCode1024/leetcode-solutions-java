package com.leetcode.topinterview150.lc_0006_zigzag_conversion;

public class Solution {
    public String convert(String s, int numRows) {
        // 特殊情况：如果只有 1 行，或者行数大于等于字符串长度，直接返回原串
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // 1. 创建 numRows 个 StringBuilder
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false; // 初始方向，其实第一步肯定是向下，但为了逻辑统一，我们在边界翻转

        // 2. 遍历字符串
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // 如果在第一行或最后一行，改变方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // 根据方向更新当前行号
            currentRow += goingDown ? 1 : -1;
        }

        // 3. 拼接所有行
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
