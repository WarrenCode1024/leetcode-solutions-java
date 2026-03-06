package com.leetcode.all.lc_0152_maximum_product_subarray;

/**
 * LeetCode 152. 乘积最大子数组
 * 链接：https://leetcode.cn/problems/maximum-product-subarray/
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
    public int maxProduct(int[] nums) {
       int n = nums.length;
       int curMax = nums[0];
       int curMin = nums[0];
       int res = nums[0];
       for (int i = 1; i < n; i++) {
           int tempMax = curMax;
           int tempMin = curMin;
           curMax = Math.max(Math.max(tempMax * nums[i], tempMin * nums[i]),nums[i]);
           curMin = Math.min(Math.min(tempMax * nums[i], tempMin * nums[i]),nums[i]);

           res = Math.max(res,curMax);
       }
       return res;
    }
}
