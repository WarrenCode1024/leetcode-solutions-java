package com.leetcode.all.lc_0273_h_index;

/**
 * LeetCode 274. H 指数 Normal
 * 链接: https://leetcode.cn/problems/h-index
 *
 * @date 2025/8/20 13:14
 */

public class Solution {
    // 解法 1
    public int hIndex(int[] citations) {
        // 冒泡排序，从大到小
//        for (int i = 0; i < citations.length - 1; i++) {
//            for (int j = 0; j < citations.length - 1 - i; j++) {
//                if (citations[j] < citations[j + 1]) { // 改成 ">" 就是升序
//                    int temp = citations[j];
//                    citations[j] = citations[j + 1];
//                    citations[j + 1] = temp;
//                }
//            }
//        }
        // 插入排序，从大到小
        for (int i = 1; i < citations.length; i++) {
            int key = citations[i];
            int j = i - 1;
            while (j >= 0 && citations[j] < key) {
                citations[j + 1] = citations[j];
                j--;
            }
            citations[j + 1] = key;
        }

        int ans = 0;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < i + 1) {
                break;
            }
            ans++;
        }
        return ans;
    }

    // 解法 2
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];
        for (int i = 0; i < n; i++) {
            if(citations[i] >= n)
                count[n]++;
            else
                count[citations[i]]++;
        }
        int ans = 0;
        for (int i = n; i >= 0; i--) {
            ans += count[i];

            if (ans >= i) {
                return i;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex2(new int[]{3, 0, 6, 1, 5}));
    }
}
