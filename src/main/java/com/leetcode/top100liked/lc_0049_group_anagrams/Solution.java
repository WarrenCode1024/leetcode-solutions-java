package com.leetcode.top100liked.lc_0049_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @FileName: Solution.java
 * @Author: Warren Wei
 * @Date: 2025/10/21
 * @LeetCode: 49 字母异位词分组 (Group Anagrams)
 * @Link: https://leetcode.com/problems/group-anagrams/
 * @Description:
 * 给定一个字符串数组 strs，将其中字母异位词分组返回。
 * 字母异位词指由相同字母重新排列组成的单词，例如 "eat" 与 "tea"。
 *
 * 解题思路：
 * 1. 使用 HashMap，将排序后的字符串作为 key；
 * 2. 遍历每个字符串，将其按字母排序后的结果作为 key 存入 HashMap；
 * 3. 将原字符串加入对应 key 的列表中；
 * 4. 遍历结束后，将 HashMap 中的所有列表作为结果返回。
 *
 * 时间复杂度：O(n * k log k)，n 为字符串数量，k 为字符串平均长度
 * 空间复杂度：O(n * k)
 *
 *
 * @Version: 1.0
 */

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs){
        // 创建 HashMap，key 为排序后的字符串，value 为该类异位词列表
        HashMap<String, List<String>> map = new HashMap<>();

        // 遍历每个字符串
        for(String s: strs){
            // 将字符串转为字符数组
            char[] chars = s.toCharArray();

            // 对字符数组排序
            Arrays.sort(chars);

            // 将排序后的字符数组重新转为字符串，作为 HashMap 的 key
            String key = new String(chars);

//            if (!map.containsKey(key)) {   // 判断 key 是否存在
//                map.put(key, new ArrayList<>());  // 如果不存在，则初始化一个空列表
//            }

            // 如果 key 不存在，则初始化一个空列表
            map.putIfAbsent(key, new ArrayList<>());

            // 将原字符串加入对应的列表中
            map.get(key).add(s);
        }

        // 将 HashMap 中的所有值（列表）组成结果返回
        return new ArrayList<>(map.values());
    }
}

