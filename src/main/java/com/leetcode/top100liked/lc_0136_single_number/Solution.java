package com.leetcode.top100liked.lc_0136_single_number;

public class Solution {

    public int singleNumber(int[] nums) {
        int single = 0;
        // 把数组中的所有元素全部异或一遍
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
