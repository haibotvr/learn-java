package com.simon.learn.headfirstjava.fire;

import java.util.ArrayList;

public class SimpleDotComTestDrive {

    public static void main(String[] args) {

        SimpleDotCom dotCom = new SimpleDotCom();

        ArrayList<String> list = new ArrayList<>();

        list.add(1 + "");
        list.add(2 + "");
        list.add(3 + "");

        dotCom.setLocationCells(list);

        String userGuess = "3";

        String result = dotCom.checkYourself(userGuess);

        String testResult = "failed";

        if(result.equals("hit")){
            testResult = "passed";
        }

        System.out.println(testResult);

    }

}
