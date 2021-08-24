package com.simon.learn.tree;

/**
 * @author simon.wei
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return maxTree(root) != -1;
    }

    private int maxTree(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = maxTree(node.left);
        int right = maxTree(node.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(right, left) + 1;
        }
    }
}
