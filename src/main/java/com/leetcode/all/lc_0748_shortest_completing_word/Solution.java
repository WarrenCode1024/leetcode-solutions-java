package com.leetcode.all.lc_0748_shortest_completing_word;

/**
 * @author
 * @desc
 * @date 2025/8/13 22:58
 */

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 统计 licensePlate 中字母的频率
        int[] licenseCount = getCharCount(licensePlate.toLowerCase());

        String result = null;
        int minLength = Integer.MAX_VALUE;

        // 遍历 words 数组
        for (String word : words) {
            // 如果当前单词长度大于等于已找到的最短补全词，跳过
            if (result != null && word.length() >= minLength) {
                continue;
            }

            // 统计当前单词的字母频率
            int[] wordCount = getCharCount(word);

            // 检查是否为补全词
            if (isCompletingWord(licenseCount, wordCount)) {
                // 更新结果和最短长度
                result = word;
                minLength = word.length();
            }
        }

        return result;
    }

    // 统计字符串中字母的频率（忽略非字母字符）
    private int[] getCharCount(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                count[c - 'a']++;
            }
        }
        return count;
    }

    // 检查 word 是否包含 licensePlate 中所有字母（频率足够）
    private boolean isCompletingWord(int[] licenseCount, int[] wordCount) {
        for (int i = 0; i < 26; i++) {
            if (licenseCount[i] > wordCount[i]) {
                return false;
            }
        }
        return true;
    }
}

//public class Solution {
//    public String shortestCompletingWord(String licensePlate, String[] words) {
//        String lower = licensePlate.toLowerCase();      // 将大写字母转换为小写
//        char[] chars = lower.toCharArray();      // 转换为字符数组
//        int[] reflection = new int[26];
//        int[] index = new int[words.length];
//
//
//        for (int i = 0; i < chars.length; i++) {    // 统计 licensePlate中小写字母的个数
//            if (chars[i] >= 'a' && chars[i] <= 'z') {
//                reflection[chars[i] - 'a']++;
//            }
//        }
//
//        // 遍历 words
//        for (int i = 0; i < words.length; i++) {
//
//            char[] word = words[i].toCharArray();
//            index[i] = word.length;     // 记录符合条件 word 的字符串长度
//            int[] match = new int[26];
//
//            for (int j = 0; j < word.length; j++) {
//                if (word[j] >= 'a' && word[j] <= 'z') {
//                    match[word[j] - 'a']++;
//                }
//            }
//
//            // 判断是否符合条件
//            for (int j = 0; j < 26; j++) {
//                if (reflection[j]!= 0) {
//                    match[j] = match[j] - reflection[j];
//                }
//                if (match[j] < 0) {
//                    index[i] = -1;
//                    break;
//                }
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        int pos = 0;
//        for (int i = 0; i < words.length; i++) {
//            if(index[i] != -1 && index[i] < min){
//                min = index[i];
//                pos = i;
//            }
//        }
//        return words[pos];
//    }
//
//}
