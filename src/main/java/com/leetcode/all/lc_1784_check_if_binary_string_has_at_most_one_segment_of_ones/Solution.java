package com.leetcode.all.lc_1784_check_if_binary_string_has_at_most_one_segment_of_ones;

public class Solution {
//    public boolean checkOnesSegment(String s) {
//        if (s == null || s.length() == 0) return false;
//        if (s.length() == 1) return true;
//
//        boolean zeroFlag = false;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == '1' && zeroFlag == false) {
//                continue;
//            } else if (s.charAt(i) == '1' && zeroFlag == true) {
//                return false;
//            }else if(s.charAt(i) == '0'){
//                zeroFlag = true;
//            }
//        }
//        return true;
//    }

    public boolean checkOnesSegment(String s) {
        boolean zeroSeen = false;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '0') {
                zeroSeen = true;
            } else {
                if (zeroSeen) {
                    return false;
                }
            }
        }
        return true;
    }
}
