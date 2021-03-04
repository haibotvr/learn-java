package com.simon.learn;

import java.util.Arrays;

/**
 * @author simon.wei
 */
public class TriangleNumber {

    public static void main(String[] args) {

        int[] num = {2,2,3,4};
        int total = new TriangleNumber().getTotal(num);
        System.out.println(total);
    }

    public int getTotal(int[] num) {
        if(num == null || num.length <= 2) {
            return 0;
        }
        Arrays.sort(num);
        int total = 0;
        int len = num.length;
        for (int i = len - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if(num[start] + num[end] > num[i]) {
                    total += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        return total;
    }
}
