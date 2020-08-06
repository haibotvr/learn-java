/**
 * @author simon.wei
 */
public class Fibonacci {

    public static int fibonacci(int n){
        int t1,t2;
        if(n ==1 || n == 2){
            return 1;
        }else{
            t1 = fibonacci(n - 1);
            t2 = fibonacci(n - 2);
            return t1 + t2;
        }
    }

    public static void main(String[] args) {
        int result = fibonacci(12);
        System.out.println(result);
    }

}
