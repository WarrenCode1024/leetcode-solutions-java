package com.leetcode.top100liked.lc_0056_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {

        // 边界条件处理
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 1. 核心步骤：按照区间的左端点（起始位置）进行升序
        // 使用 Lambda 表达式：Integer.compare 防止减法溢出
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 用一个动态列表来存放综合合并后的区间
        List<int[]> merged = new ArrayList<>();

        // 2. 遍历所有区间
        for (int[] interval : intervals) {
            // 如果列表为空，或者当前区间的左端点大于结果集中最后一个区间的右端点，说明不重叠
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                // 否则说明有重叠，合并区间：更新结果集中最后一个区间的右端点为两者的最大值
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // 3. 将 List 转换为题目要求的二维数组返回
        return merged.toArray(new int[merged.size()][]);
    }
}
