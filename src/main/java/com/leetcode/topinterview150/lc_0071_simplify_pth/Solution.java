package com.leetcode.topinterview150.lc_0071_simplify_pth;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String simplifyPath(String path) {
        // 使用双端队列作为栈
        Deque<String> stack = new ArrayDeque<>();

        // 按 "/" 分割路径
        // split("/") 会将连续的 "/" 转化为空字符串，也会处理开头的 "/" 产生的空字符串
        String[] components = path.split("/");

        for (String dir : components) {
            // 情况 1: 空字符串 (由 "//" 产生) 或 "." (当前目录) -> 忽略
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }

            // 情况 2: ".." (上级目录) -> 出栈
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast(); // 弹出栈顶
                }
                // 如果栈为空，说明已经在根目录，忽略 ".."
            }
            // 情况 3: 有效目录名 -> 入栈
            else {
                stack.offerLast(dir);
            }
        }

        // 构建结果字符串
        StringBuilder result = new StringBuilder();

        // 如果栈为空，说明是根目录
        if (stack.isEmpty()) {
            return "/";
        }

        // 遍历栈中的元素（从底到顶），拼接路径
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.toString();
    }
}