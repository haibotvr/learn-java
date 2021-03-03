package com.simon.learn;

/**
 * @author simon.wei
 */
public class BinarySearchFindPeakElement {

    public static void main(String[] args) {
        int[] num = new int[]{1,2,1,3,5,6,4};
        int i = new BinarySearchFindPeakElement().peakElement(num);
        System.out.println(i);
    }

    public int peakElement(int[] num) {
        if(num == null || num.length == 0) {
            return -1;
        }
        // 0
        int start = 0;
        // 9
        int end = num.length - 1;
        int mid;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if(num[mid] < num[mid - 1]) {
                end = mid;
            } else if (num[mid] < num[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        return num[start] > num[end] ? start : end;
    }
}
