/**
 * Names:
 *     - Bryson Harlee
 *     - Austin Whittaker
 *     - Cole Anthony
 *     - Natalie Harrison
 *
 * Class: CSC-331--003
 *
 * Date: 11/23/2021
 *
 */


package com.example.simon;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

import java.util.ArrayList;


/**
 * In this program we have the controller that can handle interactions with the game simon.
 * This includes a handle button event when the user clicks on the start button to begin
 * the game. Also, after the game has started there is a user input method that is capable of
 * handling mouse events. An example is when the user is to click on the colored rectangles
 * to repeat the sequence present to them to progress the game. As the user advances through
 * the game the level at which the user is at will increase by one.
 *
 */

/*
    Here we start our new simon game as well as the new sequence/array of colors.
 */

public class HelloController  {
    private Simon ss = new Simon();
    //creates ArrayList from SimonSays object
    private ArrayList<String> sequence = ss.getSequence();

    @FXML
    private Arc greenBox;

    @FXML
    private Arc redBox;

    @FXML
    private Arc yellowBox;

    @FXML
    private Arc blueBox;

    @FXML
    private TextField levelText;

    @FXML
    private Button startButton;

    /**
     * This method activates once the user has clicked on the Start button within the game.
     */

    @FXML
    private void handleButtonAction(ActionEvent e) {
        if (e.getSource() == startButton) {
            ss.start();
            displayColors(ss.getSequence());
        }
    }

    /*
        Alerts the user once they have made an incorrect choice that the game is over.
     */
    private void alertGameOver() {

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Simon Says Game Alert");
        alert.setHeaderText("Game Over");
        alert.setContentText("Would you like to play again? \nPress the Start button to start a new game.");
        alert.show();

    }

    /*
        In userInput this checks to make sure that the color the user clicks on is the correct choice when comparing
        to the array of colors chosen by the random generator. This also implements feedback to the user
        once they click a color by fading out the rectangle for a short amount of time. If the choice is
        incorrect it will alert game over.
     */

    @FXML
    private void userInput(MouseEvent e){

        if(ss.isGameOn()){


            if(e.getSource()==greenBox){

                FadeTransition greenbx = new FadeTransition(Duration.millis(100), greenBox);
                greenbx.setAutoReverse(true);
                greenbx.setFromValue(1.0);
                greenbx.setToValue(0.0);
                greenbx.setCycleCount(2);
                greenbx.play();


                if(!ss.checkSequence("g")){
                    alertGameOver();
                }
            }
            if(e.getSource()==redBox){

                FadeTransition redbx = new FadeTransition(Duration.millis(100), redBox);
                redbx.setAutoReverse(true);
                redbx.setFromValue(1.0);
                redbx.setToValue(0.1);
                redbx.setCycleCount(2);
                redbx.play();
                if(!ss.checkSequence("r")){
                    alertGameOver();
                }
            }
            if(e.getSource()==yellowBox){

                FadeTransition yellowbx = new FadeTransition(Duration.millis(100), yellowBox);
                yellowbx.setAutoReverse(true);
                yellowbx.setFromValue(1.0);
                yellowbx.setToValue(0.1);
                yellowbx.setCycleCount(2);
                yellowbx.play();
                if(!ss.checkSequence("y")){
                    alertGameOver();
                }
            }
            if(e.getSource()==blueBox){

                FadeTransition bluebx = new FadeTransition(Duration.millis(100), blueBox);
                bluebx.setAutoReverse(true);
                bluebx.setFromValue(1.0);
                bluebx.setToValue(0.1);
                bluebx.setCycleCount(2);
                bluebx.play();
                if(!ss.checkSequence("b")){
                    alertGameOver();
                }
            }
            if(ss.getCurrentIndex() == 0){
                displayColors(ss.getSequence());
            }
        }
    }

/*
    In displayColors we obtain the sequence of colors already within our array. From here we
    call on SequentalTransition so that the colors are displayed in the correct order as they
    being produced every time. As the user progresses to higher levels the game will become
    increasing faster for the user. The use of FadeTransition gives the user the visual of the
    colors being chosen "In real time". Once this method is finished it will then wait for the
    user's input.
 */

    private void displayColors(ArrayList<String> sequence) {

        SequentialTransition s = new SequentialTransition();
        s.setCycleCount(1);
        s.setAutoReverse(false);



        levelText.setText("");
        levelText.setText(String.valueOf(sequence.size()-2));



        int timer = 600;
        if (sequence.size() >=8 && sequence.size()<10){
            timer = 500;
        }
        else if(sequence.size() >= 10 && sequence.size()<12){
            timer = 400;
        }
        else if (sequence.size() >=12 && sequence.size()<14){
            timer = 300;
        }
        else if (sequence.size() >= 14 && sequence.size()<16){
            timer = 200;
        }
        else if(sequence.size() >= 16){
            timer = 100;
        }

        for(int i = 0; i < sequence.size(); i++){
            switch(sequence.get(i)){
                case "g":
                    FadeTransition greenft = new FadeTransition(Duration.millis(timer), greenBox);
                    greenft.setAutoReverse(true);
                    greenft.setFromValue(1.0);
                    greenft.setToValue(0.1);
                    greenft.setCycleCount(2);
                    s.getChildren().add(greenft);

                    break;
                case "r":
                    FadeTransition redft = new FadeTransition(Duration.millis(timer), redBox);
                    redft.setAutoReverse(true);
                    redft.setFromValue(1.0);
                    redft.setToValue(0.1);
                    redft.setCycleCount(2);
                    s.getChildren().add(redft);
                    break;
                case "y":
                    FadeTransition yellowft = new FadeTransition(Duration.millis(timer), yellowBox);
                    yellowft.setAutoReverse(true);
                    yellowft.setFromValue(1.0);
                    yellowft.setToValue(0.1);
                    yellowft.setCycleCount(2);
                    s.getChildren().add(yellowft);
                    break;
                case "b":
                    FadeTransition blueft = new FadeTransition(Duration.millis(timer), blueBox);
                    blueft.setAutoReverse(true);
                    blueft.setFromValue(1.0);
                    blueft.setToValue(0.1);
                    blueft.setCycleCount(2);
                    s.getChildren().add(blueft);
                    break;
            }

        }
        s.play();
    }

}