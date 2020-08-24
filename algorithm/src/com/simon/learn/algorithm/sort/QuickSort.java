package com.simon.learn.algorithm.sort;

/**
 * @author simon.wei
 */
public class QuickSort {

    //数组下标i, j的元素互相交换位置
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int partitionIt(int[] array, int left, int right) {
        //为什么 j加一个1，而i没有加1,是因为下面的循环判断是从--j和++i开始的.
        //而基准元素选的array[left],即第一个元素，所以左游标从第二个元素开始比较
        int i = left;
        int j = right + 1;
        //pivot 为选取的基准元素（头元素）
        int pivot = array[left];
        while (true) {
            while(i<right && array[++i] < pivot){}
            while(j > 0 && array[--j] > pivot){}
            //左右游标相遇时候停止， 所以跳出外部while循环
            if(i >= j) {
                break;
            }else {
                //左右游标未相遇时停止, 交换各自所指元素，循环继续
                swap(array, i, j);
            }

        }
        //基准元素和游标相遇时所指元素交换，为最后一次交换
        swap(array, left, j);
        //一趟排序完成，返回基准元素位置(注意这里基准元素已经交换位置了)
        return j;
    }

    private static void recQuickSort(int[] array, int left, int right){
        if(right <= left){
            //终止递归
            return;
        }else{

            int partition = partitionIt(array, left, right);
            //对上一轮排序(切分)时，基准元素左边的子数组进行递归
            recQuickSort(array, left, partition - 1);
            //对上一轮排序(切分)时，基准元素右边的子数组进行递归
            recQuickSort(array, partition + 1, right);
        }
    }

    public static void sort(int[] array){
        recQuickSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(array);
        ArrayUtil.log(array);
    }

}
