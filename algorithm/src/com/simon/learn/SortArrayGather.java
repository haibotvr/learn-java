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


        long time_quick_start = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(1000);
            }
            quickSort(array);
        }
        long time_quick_end = System.currentTimeMillis();
        System.out.println(time_quick_end - time_quick_start);

        long time_merge_start = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(1000);
            }
            mergeSort(array);
        }
        long time_merge_end = System.currentTimeMillis();
        System.out.println(time_merge_end - time_merge_start);


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

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if(start >= end) {
            return;
        }
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if(left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        sort(array, start, right);
        sort(array, left, end);
    }

    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSortImpl(array, 0, array.length - 1, temp);
    }

    private static void mergeSortImpl(int[] array, int start, int end, int[] temp) {
        if(start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSortImpl(array, start, mid, temp);
        mergeSortImpl(array, mid + 1, end, temp);
        merge(array, start, mid, end, temp);
    }

    private static void merge(int[] array, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if(array[left] < array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = array[left++];
        }
        while (right <= end) {
            temp[index++] = array[right++];
        }
        for (index = start; index <= end; index++) {
            array[index] = temp[index];
        }
    }
}
