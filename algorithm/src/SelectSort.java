/**
 * @author simon.wei
 */
public class SelectSort {

    static void selectSort(int[] arr){
        int index;
        int temp;
        for (int i = 0; i < arr.length - 1; i++){
            index = i;
            for (int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
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
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
