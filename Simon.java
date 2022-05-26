/**
 *  Names:
 *      - Cole Anthony
 *      - Natalie Harrison
 *      - Bryson Harllee
 *      - Austin Whittaker
 *
 *
 *  Class: CSC-331 --003
 *
 *
 *  Date: 11/23/2021
 *
 *
 */




package com.example.simon;

import java.lang.Math;
import java.util.ArrayList;

/*
 * In this Class Simon we work with all of the inner parts of the Simon Game. It creates an
 * array of colors and what sequence they are in. From this array it will check to make sure
 * that what the user chooses is either correct or incorrect. If the user's choice is incorrect
 * it will end the game. This also has variables that track the amount of turns that have been played.
 *
 */
public class Simon{
    private int currentIndex;
    private final int startingTurns = 3;                       // Start with 3 initial colors for the first round.
    private ArrayList<String> sequence;
    private final String[] COLORS = {"g", "r", "y", "b"};
    private boolean gameOn;

    /*
     * This Constructor creates the SimonSays Object and sets the index to 0. It will create an array
     * for the sequence and will initially start the GameOn to false.
     *
     */
    public Simon(){
        currentIndex = 0;
        sequence = new ArrayList<String>();
        setGameOn(false);
    }

    /*
     * Starts the game by generating randomly selected colors to the game and turning GameOn to true
     *
     */
    public void start(){
        sequence.clear();
        generateRandomSequence();
        setGameOn(true);
        currentIndex = 0;
    }
    /**
     * This method generates a random sequence that is as long as the variable STARTTURNS
     * and will add random colors from g, r, y, and b to the ArrayList.
     */
    private void generateRandomSequence(){
        for(int i = 0; i < startingTurns; i++){
            sequence.add(randomColor());
        }
    }
    /**
     * This will check to see if the userInput for the color is correct or not
     * If it is, the game will continue, and if it's the last one in the sequence,
     * it will add a new random color to the sequence. If it is wrong, the game will end.
     * @param color user input for the color they guess in accordance to the sequence
     * @return true or false depending on if color is correct or not.
     */
    public boolean checkSequence(String color){
        if((sequence.get(currentIndex)).equals(color)){
            if(currentIndex == (sequence.size()-1)){
                addToSequence();
                currentIndex =0;
                return true;
            }
            currentIndex++;
            return true;
        }
        else{
            endGame();
            return false;
        }
    }
    /**
     * This mutator method ends the game. It sets the game to false,
     * currentIndex back to zero, and the ArrayList will clear.
     */
    public void endGame(){
        currentIndex = 0;
        sequence.clear();
        setGameOn(false);
    }

    /*
     * Will add a random color (r, g, y, b) to the array
     */
    public void addToSequence(){
        sequence.add(randomColor());
    }

    /*
     * Will return a random color (g, r, y, b) to the array
     */
    private String randomColor(){
        return COLORS[(int) (Math.random()*4)];
    }

    /*
     * returns the currentIndex
     *
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /*
     * setter method for the currentIndex.
     *
     */
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    /*
     *getter method for the ArrayList
     */
    public ArrayList<String> getSequence() {
        return sequence;
    }
    /*
     * set the sequence to a specific Array of colors.
     */

    public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }

    /*
     *returns whether the game is on or not
     *
     */
    public boolean isGameOn() {
        return gameOn;
    }

    /*
     * Sets the gameOn variable to a boolean
     */
    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

}
