package com.simon.learn.string;

/**
 * @author simon.wei
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseWords("a good   example");
    }

    public String reverseWords(String s) {
        if(s == null || s.trim().length() == 0) {
            return "";
        }
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            if(words[i].equals("")) {
                continue;
            }
            result.append(words[i] + " ");
        }
        return result.toString().trim();
    }

    public String reverseWords2(String s) {
        if(s == null || s.trim().length() == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        String[] words = s.split(" ");
        for(int i = 0; i < words.length; i++) {
            ans.append(" " + reverseWord(words[i]));
        }
        return ans.toString().trim();
    }

    public String reverseWord(String word) {
        String result = "";
        for(int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        return result;
    }

}
