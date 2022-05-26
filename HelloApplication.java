/**
 * Names:
 *      - Natalie Harrison
 *      - Bryson Harlee
 *      - Austin Whittaker
 *      - Cole Anthony
 *
 * Class: CSC-331 --003
 *
 *
 * Date: 11/23/2021
 *
 */

package com.example.simon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/*
 * This program is the Application to start the program Simon. It sets the stage for
 * the fxml file and displays its workings.
 *
 */

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("simon1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 673, 554);
        stage.setTitle("Simon!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}