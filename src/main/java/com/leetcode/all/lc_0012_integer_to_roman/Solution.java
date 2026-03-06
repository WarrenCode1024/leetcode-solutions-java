package com.leetcode.all.lc_0012_integer_to_roman;

public class Solution {
    /**
     * 将整数转换为罗马数字
     * 使用贪心算法，从最大的罗马数字开始匹配
     *
     * 罗马数字规则：
     * I - 1, IV - 4, V - 5, IX - 9, X - 10
     * XL - 40, L - 50, XC - 90, C - 100
     * CD - 400, D - 500, CM - 900, M - 1000
     *
     * @param num 输入的整数 (1 <= num <= 3999)
     * @return 对应的罗马数字字符串
     */
    public String intToRoman(int num) {
        // 定义数值和对应罗马数字的映射，按从大到小顺序排列
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        // 从最大的数值开始匹配
        for (int i = 0; i < values.length; i++) {
            // 计算当前数值能包含多少个当前符号对应的数值
            int count = num / values[i];

            // 如果能匹配，则添加对应数量的符号
            if (count > 0) {
                // 重复添加符号
                for (int j = 0; j < count; j++) {
                    result.append(symbols[i]);
                }
                // 减去已处理的数值
                num -= count * values[i];
            }
        }

        return result.toString();
    }

    // 测试方法
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("3 -> " + solution.intToRoman(3));      // "III"
        System.out.println("4 -> " + solution.intToRoman(4));      // "IV"
        System.out.println("9 -> " + solution.intToRoman(9));      // "IX"
        System.out.println("58 -> " + solution.intToRoman(58));    // "LVIII"
        System.out.println("1994 -> " + solution.intToRoman(1994)); // "MCMXCIV"
        System.out.println("3999 -> " + solution.intToRoman(3999)); // "MMMCMXCIX"
        System.out.println("27 -> " + solution.intToRoman(27));    // "XXVII"
        System.out.println("444 -> " + solution.intToRoman(444));  // "CDXLIV"
        System.out.println("1000 -> " + solution.intToRoman(1000)); // "M"
    }
}