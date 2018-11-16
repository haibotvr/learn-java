package com.simon.learn.headfirstjava.fire;

public class SimpleDotComTestDrive {

    public static void main(String[] args) {

        SimpleDotCom dotCom = new SimpleDotCom();

        int[] locations = {2, 3, 4};

        dotCom.setLocationCells(locations);

        String userGuess = "3";

        String result = dotCom.checkYourself(userGuess);

        String testResult = "failed";

        if(result.equals("hit")){
            testResult = "passed";
        }

        System.out.println(testResult);

    }

}
