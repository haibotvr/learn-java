package com.simon.learn.algorithm.sort;

/**
 * @author simon.wei
 */
public class ArrayUtil {

    public static void log(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if(i != arr.length - 1) {
                builder.append(",");
            }
        }
        System.out.println(builder.toString());
    }

}
