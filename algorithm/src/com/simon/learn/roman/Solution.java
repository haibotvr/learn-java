package com.simon.learn.roman;

/**
 * @author simon.wei
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int iv = solution.romanToInt("IV");
        System.out.println(iv);
    }

    public int romanToInt(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            result += getValue(s.charAt(i));
        }
        return result;
    }

    public int getValue(Character c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            default: return 0;
        }
    }
}
