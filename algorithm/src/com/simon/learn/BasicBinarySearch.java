package com.simon.learn;

/**
 * @author simon.wei
 */
public class BasicBinarySearch {

    public static void main(String[] args) {
        int[] num = new int[]{1, 4, 9, 11, 15, 18, 21, 30, 35};
        int index = new BasicBinarySearch().getIndex(num, 35);
        System.out.println(index);
    }

    public int getIndex(int[] num, int target) {
        if(num == null || num.length == 0) {
            return -1;
        }
        // 0
        int start = 0;
        // 8
        int end = num.length - 1;
        int mid;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if(num[mid] == target) {
                return mid;
            } else if (num[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(num[start] == target) {
            return start;
        }
        if(num[end] == target) {
            return end;
        }
        return -1;
    }
}
