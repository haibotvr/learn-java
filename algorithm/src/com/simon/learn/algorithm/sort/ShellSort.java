package com.simon.learn.algorithm.sort;

/**
 * @author simon.wei
 */
public class ShellSort {

    static void shellSort(int[] arr){
        int j,temp;
        int x = 0;
        for (int r = arr.length/2; r>=1; r /= 2){
            for(int i = r; i < arr.length; i++){
                temp = arr[i];
                j = i - r;
                while (j >= 0 && temp < arr[j]){
                    arr[j + r] = arr[j];
                    j -= r;
                }
                arr[j + r] = temp;
                for (int cen : arr) {
                    System.out.print(cen + " ");
                }
                System.out.println("\n");
            }
            x++;
            System.out.println("第" + x + "步排序结果:");
            for(int h = 0; h < arr.length; h++){
                System.out.print(" " + arr[h]);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{118, 102, 31, 179, 155, 50, 81, 5};
        shellSort(arr);
    }

}
