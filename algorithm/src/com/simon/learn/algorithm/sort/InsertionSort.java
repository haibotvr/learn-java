package com.simon.learn.algorithm.sort;

/**
 * @author simon.wei
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 1, 3, 2};
        insertionSort(arr);
    }


    /**
     * 插入排序
     * @param arr 待排序数组
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        if(n <= 1) {
            return;
        }
        for(int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for(; j >=0; j--) {
                if(arr[j] > value) {
                    arr[j + 1] = arr[j];
                    System.out.println("第[" + i + "," + j + "]次排序");
                    log(arr);
                    continue;
                }
                System.out.println("第[" + i + "," + j + "]次排序");
                log(arr);
                break;
            }
            arr[j+1] = value;
            System.out.println("第[" + i + "]次排序结果");
            log(arr);
        }

    }

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
