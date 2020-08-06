import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @author simon.wei
 */
public class Heap {

    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(0, 0);
        heap.add(45);
        heap.add(36);
        heap.add(18);
        heap.add(53);
        heap.add(72);
        heap.add(30);
        heap.add(48);
        heap.add(93);
        heap.add(15);
        heap.add(35);
        adjust(heap);
    }


    public static void adjust(List<Integer> heap){

        for(int i = heap.size() / 2; i > 0; i--){
            adjust(heap, i, heap.size() - 1);
        }
        System.out.println("=================================================");
        System.out.println("调整后的初始堆：");
        print(heap);

    }

    public static void adjust(List<Integer> heap, int i, int n){

        int child;
        for (; i <= n / 2; ){
            child = i * 2;
            if(child + 1 <= n && heap.get(child) < heap.get(child + 1)){
                child += 1;
            }
            if(heap.get(i) < heap.get(child)){
                swap(heap, i, child);
            }else{
                break;
            }
        }

    }

    public static void swap(List<Integer> heap, int a, int b){

        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);

    }

}
