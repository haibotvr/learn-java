package com.simon.learn.arrays;

/**
 * @author simon.wei
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {5,7,7,8,8,10};
        solution.search(arr, 6);
    }
    public int search(int[] nums, int target) {
        if(nums == null) {
            return 0;
        }
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int length = nums.length;
        int beforeIndex = getBefore(0, length, nums, target);
        int afterIndex = getAfter(0, length, nums, target);
        return afterIndex - beforeIndex + 1;
    }

    public int getBefore(int begin, int end, int[] nums, int target) {
        while (begin <= end) {
            int midIndex = (end + begin) / 2;
            if(midIndex == 0) {
                return 1;
            }
            int midValue = nums[midIndex];
            if(target == midValue && target > nums[midIndex - 1]) {
                return midIndex;
            } else if(target <= midValue) {
                end = midIndex;
            } else {
                begin = midIndex;
            }
        }
        return begin;
    }

    public int getAfter(int begin, int end, int[] nums, int target) {
        while (begin <= end) {
            int midIndex = (end + begin) / 2;
            if(midIndex == 0) {
                return 0;
            }
            int midValue = nums[midIndex];
            if(target == midValue && target < nums[midIndex + 1]) {
                return midIndex;
            } else if(target >= midValue) {
                begin = midIndex;
            } else {
                end = midIndex;
            }
        }
        return begin;
    }
}
