package com.simon.learn.headfirstjava.fire;

import java.util.Scanner;

public class GameHelper {

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter a number: ");
        String result = scanner.nextLine();
        return result;
    }

}
