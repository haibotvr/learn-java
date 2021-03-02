package com.simon.learn;

import java.util.Stack;

/**
 * @author simon.wei
 */
public class BracketsValid {

    /**
     *  ()     true
     *  ()[]{} true
     *  (]     false
     *  ([)]   false
     */
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            }
            if(aChar == ')') {
                if(stack.empty() || stack.pop() != '(') {
                    return false;
                }
            }
            if(aChar == ']') {
                if(stack.empty() || stack.pop() != '[') {
                    return false;
                }
            }
            if(aChar == '}') {
                if(stack.empty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]"));
    }
}
