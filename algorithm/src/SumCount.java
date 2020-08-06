/**
 * @author simon.wei
 */
public class SumCount {

    public static void main(String[] args) {

        for(int i = 1; i < 10000; i++){
            int count = 11 * i;
            if((count - 2)%3 == 0
                    && (count - 4)%5 == 0
                    && (count - 6)%7 == 0
                    && (count - 8)%9 == 0){
                System.out.println(count);
            }
        }
    }
}
