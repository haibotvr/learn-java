package com.simon.learn;

/**
 * @author simon.wei
 */
public class BinarySearchRotateSortArray {

    public static void main(String[] args) {
        int[] num = new int[]{6, 7, 8, 1, 3, 4, 5};
        int index = new BinarySearchRotateSortArray().getIndex(num, 6);
        System.out.println(index);
    }

    public int getIndex(int[] num, int target) {
        if(num == null || num.length == 0) {
            return -1;
        }
        // 0
        int start = 0;
        // 6
        int end = num.length - 1;
        int mid;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if(num[mid] == target) {
                return mid;
            }
            if(num[mid] > num[start]) {
                if(num[mid] > target && target >= num[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if(num[mid] < target && num[end] >= target) {
                    start = mid;
                } else {
                    end = mid;
                }
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
