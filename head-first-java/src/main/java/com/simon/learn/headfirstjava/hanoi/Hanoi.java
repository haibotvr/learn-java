package com.simon.learn.headfirstjava.hanoi;

public class Hanoi {

    private int number;



    /**
     *
     * @param n 盘子的数目
     * @param origin 源座
     * @param assist 辅助座
     * @param destination 目的座
     */
    public void hanoi(int n, char origin, char assist, char destination){
        if(n == 1){
            move(n, origin, destination);
        }else{
            move(n - 1, origin, destination);
            hanoi(n - 1, origin, destination, assist);
            hanoi(n - 1, assist, origin, destination);
        }
    }

    private void move(int n, char origin, char destination){
        number ++;
        System.out.println("Direction:" + number + " from " + origin + " to " + destination);
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3, 'A', 'B', 'C');
    }


}
