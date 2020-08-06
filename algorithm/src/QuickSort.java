/**
 * @author simon.wei
 */
public class QuickSort {

    static void quickSort(int[] arr, int left, int right){
        int f, t;
        int ltemp, rtemp;
        ltemp = left;
        rtemp = right;
        f = arr[(left + right) / 2];
        while (ltemp < right){
            while (arr[ltemp] < f){
                ++ltemp;
            }
            while (arr[rtemp] > f){
                --rtemp;
            }
            if(ltemp <= rtemp){
                t = arr[ltemp];
                arr[ltemp] = arr[rtemp];
            }
        }
    }

}
