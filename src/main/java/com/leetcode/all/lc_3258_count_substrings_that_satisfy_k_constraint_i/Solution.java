package com.leetcode.all.lc_3258_count_substrings_that_satisfy_k_constraint_i;

/**
 * LeetCode 3258. 统计满足 K 约束的子字符串数量 I
 * 链接：https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/
 *
 * @param
 * @return
 *
 * 思路：
 * -
 * -
 * -
 */

public class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int cnt0 = 0;
        int cnt1 = 0;
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                cnt0++;
            }
            if (s.charAt(right) == '1') {
                cnt1++;
            }
            while (cnt0 > k && cnt1 > k){
                if(s.charAt(left) == '0') cnt0--;
                if(s.charAt(left) == '1') cnt1--;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
