package com.leetcode.top100liked.lc_0020_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValid(String s) {
        // 特殊情况：如果长度为奇数，肯定无法完全匹配
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }else if (c == '{') {
                stack.push('}');
            }else if (c == '[') {
                stack.push(']');
            }else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
