package com.simon.learn.submissions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author simon.wei
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> list = new ArrayList<>();
        dfs(nums, result, list, 0);
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> list, int position) {
        result.add(new ArrayList<>(list));
        for(int i = position; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, result, list, ++position);
            list.remove(list.size() - 1);
        }
    }

}
