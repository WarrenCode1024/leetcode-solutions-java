package com.leetcode.all.lc_0122_bset_time_to_buy_and_sell_stock_II;


public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // 从第 2 天开始遍历（索引 1），对比前一天
        for (int i = 1; i < prices.length; i++) {
            // 如果今天的价格比昨天高，就加上这段差价
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}

//public class Solution {
//
//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0) {return 0;}
//        int minPrice = prices[0];
//        int maxProfit = 0;
//
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] >= minPrice) {
//                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
//                minPrice = prices[i];
//            }else{
//                minPrice = prices[i];
//            }
//
//        }
//        return maxProfit;
//    }
//}
