package com.simon.learn.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {
        TreeNode node_7 = new TreeNode(4, null, null);
        TreeNode node_6 = new TreeNode(4, null, null);
        TreeNode node_5 = new TreeNode(3, null, null);
        TreeNode node_4 = new TreeNode(3, node_6, node_7);
        TreeNode node_3 = new TreeNode(2, null, null);
        TreeNode node_2 = new TreeNode(2, node_4, node_5);
        TreeNode node_1 = new TreeNode(1, node_2, node_3);
        Solution solution = new Solution();
        boolean balanced = solution.isBalanced(node_1);
        System.out.println(balanced);

        PriorityQueue<Integer> queue = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        queue.add(1);

    }
}
