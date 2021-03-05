package com.simon.learn.algorithm.sort;

import java.util.Arrays;

/**
 * @author simon.wei
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * 时间复杂度O(n2)
     * 是稳定排序
     * 是原地排序
     *
     */
    public static void bubbleSort(int[] arr){
        int temp;
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < arr.length - i; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 9, 8, 5};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }
}
