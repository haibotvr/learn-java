package com.simon.learn.subliststring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author simon.wei
 */
public class Solution {

    public static void main(String[] args) {
        String str = "abcabca";
        lengthOfLongestSubstring(str);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s == "") {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int point = 0;
        for(int i = 0; i < s.length(); i++) {
            while(point < s.length() && !set.contains(s.charAt(point))) {
                set.add(s.charAt(point++));
                max = Math.max(max, point - i);
            }
            set.remove(s.charAt(i));
        }
        return max;
    }
}
