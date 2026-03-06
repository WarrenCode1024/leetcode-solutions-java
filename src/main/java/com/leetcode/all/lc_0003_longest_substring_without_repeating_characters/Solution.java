package com.leetcode.all.lc_0003_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @desc 3. 无重复字符的最长子串
 * @date 2025/8/15 17:44
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;   // 滑动窗口左边界

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // 更新左边界，防止回退
                 left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);  // 记录字符最后出现的位置
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
