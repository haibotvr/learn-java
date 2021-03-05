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
     *
     * 插入排序也包含两种操作，一种是元素的比较，一种是元素的移动。
     * 当我们需要将一个数据 a 插入到已排序区间时，
     * 需要拿 a 与已排序区间的元素依次比较大小，
     * 找到合适的插入位置。
     * 找到插入点之后，我们还需要将插入点之后的元素顺序往后移动一位，
     * 这样才能腾出位置给元素 a 插入。
     *
     * 时间复杂度O(n2)
     * 是稳定排序
     * 是原地排序
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
                    ArrayUtil.log(arr);
                    continue;
                }
                System.out.println("第[" + i + "," + j + "]次排序");
                ArrayUtil.log(arr);
                break;
            }
            arr[j+1] = value;
            System.out.println("第[" + i + "]次排序结果");
            ArrayUtil.log(arr);
        }

    }
}
