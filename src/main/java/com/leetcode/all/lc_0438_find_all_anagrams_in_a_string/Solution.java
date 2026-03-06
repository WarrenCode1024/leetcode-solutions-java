package com.leetcode.all.lc_0438_find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @desc 438. 找到字符串中所有字母异位词
 * @date 2025/8/16 10:15
 */


public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] countP = new int[26];
        int[] countS = new int[26];

        // 统计 p 的频率
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }

        int window = p.length();
        // 初始化第一个窗口
        for (int i = 0; i < window; i++) {
            countS[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(countP, countS)) {
            res.add(0);
        }

        // 滑动窗口
        for (int i = window; i < s.length(); i++) {
            // 加入新字符
            countS[s.charAt(i) - 'a']++;
            // 移除旧字符
            countS[s.charAt(i - window) - 'a']--;

            if (Arrays.equals(countP, countS)) {
                res.add(i - window + 1);
            }
        }

        return res;

    }
}
