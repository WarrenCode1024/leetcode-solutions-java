package com.leetcode.top100liked.lc_0076_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * LeetCode 76. 最小覆盖子串
     *
     * @param s 原始字符串
     * @param t 目标字符串
     * @return 最小覆盖子串
     */
    public String minWindow(String s, String t) {
        // 1. 存储 t 中字符及其需求的数量
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // 2. 窗口数据
        Map<Character, Integer> windowMap = new HashMap<>();

        // 3. 匹配计数器
        // targetCount: t 中不重复字符的种类数 (即 targetMap 的大小)
        int targetCount = targetMap.size();
        // valid: 窗口中已满足目标数量的 t 字符的种类数
        int valid = 0;

        // 4. 滑动窗口指针
        int left = 0;
        int right = 0;

        // 5. 最小覆盖子串的结果变量
        int minLen = Integer.MAX_VALUE;
        int start = 0; // 记录最小覆盖子串的起始索引

        // right 指针扩张窗口
        while (right < s.length()) {
            char c = s.charAt(right);
            right++; // 移动右指针

            // 更新窗口数据
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

                // 检查是否满足匹配条件：窗口中该字符数量 == 目标数量
                if (windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                    valid++;
                }
            }

            // left 指针收缩窗口：当 valid == targetCount 时，窗口满足覆盖条件
            while (valid == targetCount) {
                // 找到一个有效的覆盖子串 S[left..right-1]

                // **a. 更新最小覆盖子串结果**
                // 当前窗口长度为 right - left
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left; // 记录起始位置
                }

                // **b. 准备收缩窗口**
                char d = s.charAt(left);
                left++; // 移动左指针

                // 更新窗口数据
                if (targetMap.containsKey(d)) {
                    // 检查是否打破匹配条件：窗口中该字符数量 < 目标数量
                    if (windowMap.get(d).intValue() == targetMap.get(d).intValue()) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }

        // 6. 返回结果
        // 如果 minLen 仍然是初始值，说明没有找到覆盖子串，返回空字符串
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}