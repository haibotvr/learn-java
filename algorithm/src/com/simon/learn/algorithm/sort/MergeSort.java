package com.simon.learn.algorithm.sort;

/**
 * @author simon.wei
 */
public class MergeSort {

    /**
     * 归并排序
     * 如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
     * @param arr
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            //对左边数组排序
            mergeSort(arr, left, mid);
            //对右边数组排序
            mergeSort(arr, mid + 1, right);
            //合并2边数组
            merge(arr, left, mid, right);
        }

    }

    public static void merge(int[] arr, int left, int mid, int right) {
        //定义临时数组大小
        int[] temp = new int[right - left + 1];
        //新数组索引
        int i = 0;
        //需要合并的2个数组起点
        int j = left;
        int k = mid + 1;
        //把较小的数先移动到新的数组中
        while(j <= mid && k <= right) {
            if(arr[j] < arr[k]) {
                temp[i++] = arr[j++];
            }else {
                temp[i++] = arr[k++];
            }
        }
        //把左边剩余的数移入数组
        while(j <= mid) {
            temp[i++] = arr[j++];
        }
        //把右边剩余的数移入数组
        while(k <= right) {
            temp[i++] = arr[k++];
        }
        //将临时数组的数据覆盖到arr
        for(int l = 0; l < temp.length; l++) {
            arr[l + left] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 9, 8, 1, 6, 3, 5, 7};
        mergeSort(array, 0, array.length - 1);
        ArrayUtil.log(array);
    }
}
