package ucf.assignment;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class NewTodoListItemController {


    ObservableList<ListItems> items = FXCollections.observableArrayList();
    private Alert alert = new Alert(Alert.AlertType.ERROR); //Here we are creating an alert to be used in any error interaction

    @FXML
    public DatePicker New_due_date;
    @FXML
    public TextField New_description;
    
    //Here we are going to receive as parameter the list and the items_list for that exact to-do list.

    @FXML
    public void CloseNewItem_Window(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Todolist.fxml"));
        Parent root = loader.load();
        TodolistController controller = loader.getController();
        controller.ReceiveItemInformation(items);

        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
        //Closing Window
    }
    @FXML
    public void AddNewItem(ActionEvent actionEvent) { //Check this part for the new due date invalid

        String new_description_item = New_description.getText();
        String new_due_date = New_due_date.toString();

        //Checking if the name or description is empty
         if(new_description_item.isEmpty()){
            alert.setTitle("Error!");
            alert.setContentText("Error! The description of the item is empty");
            alert.showAndWait();
        }
        else if(new_due_date.isEmpty()){
            alert.setTitle("Error!");
            alert.setContentText("Error! The due date selection is empty!");
            alert.showAndWait();
        }
        //Check if the due_date is invalid.
        //Do one more else if for the due_date checking

        //Checking if the description is more than 256 characters or less than 1 character long
        else if(new_description_item.length() < 1|| new_description_item.length() > 256){
            alert.setTitle("Error!");
            alert.setContentText("Error! Check the description; the length should be from 1 to 256 characters; the description inputted has " + new_description_item.length() + " characters");
            alert.showAndWait();
        }
        items.add(new ListItems(New_due_date.getValue(),new_description_item,false));
        Dialog("The task was created successfully!");
        New_description.clear();


    }
    public void Dialog(String x){ //This is a function to call a dialog!
        //Creating a dialog
        Dialog<String> dialog = new Dialog<String>();
        //Setting the title
        dialog.setTitle("!NEW Changes!");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialog.setContentText(x);
        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait(); //Showing the dialog
    }
}
