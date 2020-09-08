package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static class DotComGame {
        // declare ArrayList to hold in locations of cells
        ArrayList<Integer> locationCells;

        // assign it a random value from 0 to
        public void setLocationCells(ArrayList<Integer> locs) {
            locationCells = locs;
        }

        public String checkUserGuess(String checkGuess) {
            int guess = Integer.parseInt(checkGuess);
            int index = locationCells.indexOf(guess);
            String result = "miss";

            if (locationCells.contains(guess)) {
                result = "hit";
                locationCells.remove(index);
            }

            if (locationCells.isEmpty())
                result = "kill";

            return result;
        }

    }

    // game is 5*5 with 3 .com the size of 2 cells

    public static void main(String[] args) {
        System.out.println("Welcome! Your objective is to sink the .com in the least number of tries!");
        System.out.println("It's 2 cells big and placed somewhere on a 5-digit grid (from 1 to 5)");

        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();

        // create a dot com
        DotComGame dot = new DotComGame();

        // assign it a random location on the greed
        ArrayList<Integer> locations = new ArrayList<>();
        Random rnd = new Random();
        int rndNum = rnd.nextInt(3) + 1;
        locations.add(rndNum);
        locations.add(rndNum + 1);
        dot.setLocationCells(locations);

        // while loop for user to sink a ship
        boolean isAlive = true;

        while (isAlive) {
            String userGuess = helper.getUserInput("Enter a number: ");
            String result = dot.checkUserGuess(userGuess);
            System.out.println("-> " + result);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("It took you " + numOfGuesses + " guesses");
            }
        }

/*        // run this guess through a method and return the result
        String result = dot.checkUserGuess(userGuess);

        // print out a number of guesses it took user to sink the dot com
        String testResult = "failed";
        if (result.equals("hit")) {
            testResult = "passed";
        }

        System.out.println(testResult);*/
    }

}
