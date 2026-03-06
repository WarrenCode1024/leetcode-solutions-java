package com.leetcode.all.lc_1323_maximum_69_number;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author
 * @desc 1323. 6 和 9 组成的最大数字
 * @date 2025/8/18 13:46
 */

public class Solution {
    public int maximum69Number (int num) {

        int temp = num;
        int index = -1;
        int pos = 0;

        while (temp>0){
            if(temp % 10 == 6){
                index = pos; // 记录最后一个6的位置（因为循环是从低位往高位）
            }
            temp = temp / 10;
            pos++;
        }
        if(index == -1) return num;
        return num + 3 * (int)Math.pow(10, index); // 把6变9，多了3

    }
}
