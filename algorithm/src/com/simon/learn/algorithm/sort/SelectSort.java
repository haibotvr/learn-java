package com.simon.learn.algorithm.sort;

/**
 * @author simon.wei
 */
public class SelectSort {

    /**
     * 选择排序
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
     * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     *
     * @param arr 待排序数组
     */
    public static void selectSort(int[] arr){
        int index;
        int temp;
        for (int i = 0; i < arr.length - 1; i++){
            index = i;
            //寻找最小元素下标index
            for (int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            //将最小元素放入已排区间末尾
            if(index != i){
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 8, 5, 7};
        selectSort(arr);
        ArrayUtil.log(arr);
    }

}
