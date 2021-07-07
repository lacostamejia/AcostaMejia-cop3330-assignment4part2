/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

package ucf.assignment;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

//Here is the main class where the application will start running

public class Todolist extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Todolist.fxml")); //Here we are loading all the app from FXML

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("To-Do Lists");
            primaryStage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
