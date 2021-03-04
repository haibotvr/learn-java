package com.simon.learn.test;

import java.util.Random;

/**
 * @author simon.wei
 */
public class NumClient {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            int start = random.nextInt(1000000);
            int end = random.nextInt(1000000);
            if(start > end) {
                int temp = start;
                start = end;
                end = temp;
            }
            int mid_1 = (end + start)/2;
            int mid_2 = start + (end - start) / 2;
            if(mid_1 != mid_2) {
                System.out.println("start=" + start + ",end=" + end);
            }
        }
    }
}
