package com.leetcode.all.lc_0042_trapping_rain_water;

/**
 * @author
 * @desc 42. 接雨水
 * @date 2025/8/14 21:12
 */

public class Solution {
    //    public int trap(int[] height) {
//        int left = 0, right = height.length - 1;
//        int leftMax = 0, rightMax = 0;
//        int water = 0;
//
//        while (left <= right) {
//            leftMax = Math.max(leftMax, height[left]);
//            rightMax = Math.max(rightMax, height[right]);
//            if(leftMax < rightMax) {
//                water += leftMax - height[left];
//                left++;
//            }else {
//                water += rightMax - height[right];
//                right--;
//            }
//        }
//        return water;
//    }
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
           if(height[left] < height[right]) {
               if(height[left] >= leftMax) {
                   leftMax = height[left];
               }else {
                   water += leftMax - height[left];
               }
               left++;
           }else{
               if(height[right] >= rightMax) {
                   rightMax = height[right];
               }else {
                   water += rightMax - height[right];
               }
               right--;
           }
        }
        return water;
    }
}
