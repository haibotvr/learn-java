package com.simon.learn.headfirstjava.fire;

import java.util.Scanner;

public class SimpleDotComGame {

    public static void main(String[] args) {

        //declare a variable to hold the number of user guesses, named numOfGuesses
        int numOfGuesses = 0;
        //compute a random number between o and 4 that will be the starting location cell position
        int startLocation = (int)(Math.random() * 5);
        GameHelper helper = new GameHelper();
        SimpleDotCom dot = new SimpleDotCom();
        dot.setLocationCells(new int[]{startLocation, startLocation + 1, startLocation + 2});
        //while the dot com it still alive
        boolean alive = true;
        while (alive){
            //get user input from the command line
            String line = helper.getUserInput();
            System.out.println("enter a number " + line);
            numOfGuesses++;
            String result = dot.checkYourself(line);
            if("kill".equals(result)){
                alive = false;
            }
        }
        System.out.println("You took " + numOfGuesses + " guesses");

    }

}
