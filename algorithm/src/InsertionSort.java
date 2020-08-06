/**
 * @author simon.wei
 */
public class InsertionSort {

    static void insertionSort(int[] arr){
        int j,temp;
        for(int i = 0; i < arr.length; i++){
            temp = arr[i];
            j = i - 1;
            while (j >= 0 && temp < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{118, 101, 105, 127, 112};
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
