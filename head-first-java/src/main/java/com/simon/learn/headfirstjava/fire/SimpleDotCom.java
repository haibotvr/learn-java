package com.simon.learn.headfirstjava.fire;

import java.util.ArrayList;

public class SimpleDotCom {

    private ArrayList<String> locationCells;

    private int numOfHits = 0;

    //method String checkYourself(String userGuess)
    //get the userGuess as a String parameter
    //convert the userGuess to an int
    //repeat with each of the location cells int the int array
        //compare the userGuess to the location cell
        //if the userGuess matches
            //increment the number of hits
            //find out if it was the last location cell
            //if the number of hit is 3, return "kill" as the result
            //else it was not a kill, so return "hit"
            //end if
            //else the userGuess did not match, so return "miss"
        //end if
    //end repeat
    //end method

    public String checkYourself(String userGuess){

//        int guess = Integer.valueOf(userGuess).intValue();

        int index = locationCells.indexOf(userGuess);

        String result = "miss";

//        for (int locationCell : locationCells) {

//            if(locationCell == guess){
        if(index >= 0){
            locationCells.remove(userGuess);
            result = "hit";
            numOfHits++;
        }
//                break;
//            }

//        }

//        if(numOfHits >= locationCells.length){
        if(locationCells.isEmpty()){
            result = "kill";
        }
//        }

        System.out.println(result);

        return result;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }
}
