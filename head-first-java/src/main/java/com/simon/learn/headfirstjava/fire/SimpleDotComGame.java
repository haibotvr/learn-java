package com.simon.learn.headfirstjava.fire;

import java.util.ArrayList;

public class SimpleDotComGame {

    public static void main(String[] args) {

        //declare a variable to hold the number of user guesses, named numOfGuesses
        int numOfGuesses = 0;
        //compute a random number between o and 4 that will be the starting location cell position
        int startLocation = (int)(Math.random() * 5);
        GameHelper helper = new GameHelper();
        SimpleDotCom dot = new SimpleDotCom();
        ArrayList<String> list = new ArrayList<>();
        list.add(startLocation + "");
        list.add(startLocation + 1 + "");
        list.add(startLocation + 2 + "");
        dot.setLocationCells(list);
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
