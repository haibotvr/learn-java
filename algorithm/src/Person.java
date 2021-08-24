/**
 * @author simon.wei
 */
public class Person {

    private String name = "simon";

    private int age;

    private final double salary = 100;

    private static String address;

    private final static String hobby = "Programming";

    private static Object object = new Object();

    private static int days = 1;

    public void say() {
        System.out.println("person say ......");
    }

    public static int calc(int param1, int param2) {
        param1 = 3;
        int result = param1 + param2;
        Object obj = new Object();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(days);
    }
}
