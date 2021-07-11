package ucf.assignment;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewTodolistController {



    ObservableList<List> lists = FXCollections.observableArrayList(); //Saving all the lists

   private Alert alert = new Alert(Alert.AlertType.ERROR); //Here we are creating an alert to be used in any error interaction
    @FXML
    public TextField Name_Item;
    @FXML
    public DatePicker Due_Date;
    @FXML
    private TextField Description_Item;
    @FXML
    private TextField NameListInput;
    @FXML
    private Button BtnCreateList;


    //Here we are going to have variables created for the name of the list, the new list, the information
    //We are going to pass as parameters. //The status of the item  is incomplete at first, we have to save this.

    @FXML
    public void Create_List(ActionEvent actionEvent) throws IOException {
         String name_list = NameListInput.getText();

       //  FXMLLoader loader = new FXMLLoader(getClass().getResource("Todolist.fxml"));
        // Parent root = loader.load();
       //  TodolistController controller = loader.getController();

        //Checking if the name inputted is empty.
        if(name_list.isEmpty()){
            alert.setTitle("Error!");
            alert.setContentText("Error! The name of the item is empty");
            alert.showAndWait();
        }
        else if(lists.contains(name_list)){ //Check this
            alert.setTitle("Error!");
            alert.setContentText("Error! The name of the item is already taken");
            alert.showAndWait();
        }
        else{ //Working
            lists.addAll(new List(name_list));
            NameListInput.clear(); //Putting back to empty this space
        }

    }
    @FXML
    public void Close_New_todo_list(ActionEvent actionEvent) throws IOException { //Working
        //Here we are going to close this window.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Todolist.fxml"));
        Parent root = loader.load();
        TodolistController controller = loader.getController();
        controller.ReceiveListinformation(lists);
        /*
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("To-do List");
        stage.show();


         */
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();

    }
   /*
    @FXML
    public void Add_item_new_todo_list(ActionEvent actionEvent) {

        String description = Description_Item.getText(); //Here we are getting the description
        String name_item = Name_Item.getText(); //Here we are getting the name of the item

        LocalDate due_date = Due_Date.getValue(); //Check this
        System.out.println(due_date);


         if(description.isEmpty() || name_item.isEmpty()){ //Checking if they are empty
            alert.setTitle("Error!");
            alert.setContentText("Error! The description/name of the item is empty");
            alert.showAndWait();

        }
        //Here we are checking the length of the description, in order to give an error or not
        else if(description.length() < 1 || description.length() > 256){
            alert.setTitle("Error!");
            alert.setContentText("Error! Check the description; the length should be from 1 to 256 characters; the description inputted has " + description.length() + " characters");
            alert.showAndWait();
        }
        else{


         }
*/
}
