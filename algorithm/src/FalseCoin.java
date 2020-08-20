import java.util.Scanner;

/**
 * @author simon.wei
 */
public class FalseCoin {

    static final int max_num = 30;

    static int falseCoin(int[] coin, int low, int high){
        int i, sum1, sum2;
        int result = 0;
        sum1 = sum2 = 0;
        if(low + 1 == high){
            if(coin[low] < coin[high]){
                result = low + 1;
                return result;
            }else{
                result = high + 1;
                return result;
            }
        }
        //偶数个
        if((high - low + 1) % 2 == 0){
            for(i = low; i <= low + (high - low) / 2; i++){
                sum1 = sum1 + coin[i];
            }
            for(i = low + (high - low) / 2 + 1; i <= high; i++){
                sum2 = sum2 + coin[i];
            }
            if(sum1 > sum2){
                result = falseCoin(coin, low + (high - low) / 2 + 1, high);
            }else{
                result = falseCoin(coin, low, low + (high - low) / 2);
            }
        }else{//奇数个
            for(i = low; i <= low + (high - low) / 2 - 1; i++){
                sum1 = sum1 + coin[i];
            }
            for(i = low + (high - low) / 2 + 1; i <= high; i++){
                sum2 = sum2 + coin[i];
            }
            if(sum1 > sum2){
                result = falseCoin(coin, low + (high - low) / 2 + 1, high);
            }
            if(sum1 < sum2){
                result = falseCoin(coin, low, low + (high - low) / 2 - 1);
            }
            if(sum1 == sum2){
                result = low + (high - low) / 2 + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] coin = new int[max_num];
        System.out.println("请输入银币总个数:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print("请输入银币的重量:");
        for(int i = 0; i < n; i++){
            coin[i] = input.nextInt();
        }
        System.out.println("第" + falseCoin(coin, 0, n - 1) + "个银币是假的");
    }

}
