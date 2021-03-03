package com.simon.learn;

/**
 * @author simon.wei
 */
public class BinarySearchRotateSortArrayFindMin {

    public static void main(String[] args) {
        int[] num = new int[]{6,7,8,2,3,4,5};
        int min = new BinarySearchRotateSortArrayFindMin().getMin(num);
        System.out.println(min);
    }

    public int getMin(int[] num) {
        if(num == null || num.length == 0) {
            return -1;
        }
        // 0
        int start = 0;
        // 3
        int end = num.length - 1;
        int mid;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if(num[mid] > num[start]) {
                if(num[end] < num[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                end = mid;
            }
        }
        return Math.min(num[start], num[end]);
    }
}
