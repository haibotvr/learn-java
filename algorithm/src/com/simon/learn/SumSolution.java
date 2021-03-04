package com.simon.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author simon.wei
 */
public class SumSolution {

    public static void main(String[] args) {

        int[] num = {1, 3, 4, 7, 11, 13, 15};

//        int[] ints = new SumSolution().twoSum(num, 14);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
//
//        num = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int i = new SumSolution().twoSumPair(num, 14);
//        System.out.println(i);

        num = new int[]{-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> lists = new SumSolution().threeSum(num, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }

    }

    public List<List<Integer>> threeSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(num == null || num.length == 0) {
            return null;
        }
        //排序
        Arrays.sort(num);
        int len = num.length;
        for (int i = 0; i < len - 2; i++) {
            if(i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                if(num[i] + num[start] + num[end] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[start]);
                    list.add(num[end]);
                    result.add(list);
                    start++;
                    end--;
                    while (start < end && num[start] == num[start + 1]) {
                        start++;
                    }
                    while (start < end && num[end] == num[end - 1]) {
                        end--;
                    }
                } else if (num[i] + num[start] + num[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }

    public int[] twoSum(int[] num, int target) {
        if(num == null || num.length == 0) {
            return null;
        }
        int start = 0;
        int end = num.length - 1;
        int[] result = {-1, -1};
        while (start < end) {
            if(num[start] + num[end] < target) {
                start++;
            } else if (num[start] + num[end] > target) {
                end--;
            } else {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
        }
        return result;
    }

    public int twoSumPair(int[] num, int target) {
        if(num == null || num.length == 0) {
            return 0;
        }
        int start = 0;
        int end = num.length - 1;
        int count = 0;
        while (start < end) {
            if(num[start] + num[end] < target) {
                start++;
            } else if (num[start] + num[end] > target) {
                end--;
            } else {
                start++;
                end--;
                count++;
            }
        }
        return count;
    }
}
