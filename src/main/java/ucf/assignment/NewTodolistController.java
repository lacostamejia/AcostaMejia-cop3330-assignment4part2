package ucf.assignment;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewTodolistController {

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
    public void Create_List(ActionEvent actionEvent) {

        String name_list = NameListInput.getText();
        //Checking if the name inputted is empty.
        if(name_list.isEmpty()){
            alert.setTitle("Error!");
            alert.setContentText("Error! The name of the item is empty");
            alert.showAndWait();
        }
        System.out.println(name_list);
        //Here we are going to be creating a new list with the name inputted.
        //We have to check if the name is empty or NULL
        //We have to use the class List and call it as a blue print, in order to access to the information of this class
    }
    @FXML
    public void Close_New_todo_list(ActionEvent actionEvent) {
        //Here we are going to close this window.
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }
    @FXML
    public void Add_item_new_todo_list(ActionEvent actionEvent) {

        String description = Description_Item.getText(); //Here we are getting the description
        String name_item = Name_Item.getText(); //Here we are getting the name of the item

        String due_date = Due_Date.getAccessibleText(); //Check this
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

        //Here we are going to be adding items to the new list created.
        //We have to check if there is an item with the same name imputed.
        //If the name, due date or description is empty or NULL.
        //We are going to set the status of the item at first as incomplete.
        //We have to access to the ListItems class
    }
}
