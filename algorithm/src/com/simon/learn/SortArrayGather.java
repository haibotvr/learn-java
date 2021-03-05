package com.simon.learn;

import java.util.Arrays;
import java.util.Random;

/**
 * @author simon.wei
 */
public class SortArrayGather {

    public static void main(String[] args) {
        int[] array = new int[10000];
        Random random = new Random();
        long time_bubble_start = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(1000);
            }
            bubbleSort(array);
        }
        long time_bubble_end = System.currentTimeMillis();
        System.out.println(time_bubble_end - time_bubble_start);

        long time_insert_start = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(1000);
            }
            insertSort(array);
        }
        long time_insert_end = System.currentTimeMillis();
        System.out.println(time_insert_end - time_insert_start);


        long time_select_start = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(1000);
            }
            selectSort(array);
        }
        long time_select_end = System.currentTimeMillis();
        System.out.println(time_select_end - time_select_start);

    }

    public static void bubbleSort(int[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        int insertion;
        for (int i = 1; i < len; i++) {
            insertion = array[i];
            int j = i;
            while (j > 0 && insertion < array[j - 1] ) {
                array[j] = array[j - 1];
                array[j - 1] = insertion;
                j--;
            }
        }
    }

    public static void selectSort(int[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        int pos;
        for (int i = 0; i < len; i++) {
            pos = i;
            for (int j = i + 1; j < len; j++) {
                if(array[pos] > array[j]) {
                    pos = j;
                }
            }
            if(pos != i) {
                int temp = array[i];
                array[i] = array[pos];
                array[pos] = temp;
            }
        }
    }
}
