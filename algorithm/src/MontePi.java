import java.util.Scanner;

/**
 * @author simon.wei
 */
public class MontePi {

    static double montePI(int n){
        double pi;
        double x,y;
        int sum = 0;
        for(int i = 0; i < n; i++){
            x = Math.random();
            y = Math.random();
            if(x*x + y*y <= 1){
                sum++;
            }
        }
        pi = 4.0 * sum /n;
        return pi;
    }

    public static void main(String[] args) {
        System.out.println("请输入点的数量:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(montePI(n));
    }
}
