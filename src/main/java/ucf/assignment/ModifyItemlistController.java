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

public class ModifyItemlistController {

    private Alert alert = new Alert(Alert.AlertType.ERROR); //Here we are creating an alert to be used in any error interaction

    @FXML
    public DatePicker Modified_Due_Date;
    @FXML
    public TextField Modified_Description_Inputted;
    //Here we have to receive as parameter, the list and the items_list for that list, and specifying the item that we want to
    //modify.

    @FXML
    public void Save_Modified_Item(ActionEvent actionEvent) {

        String new_description_inputted = Modified_Description_Inputted.getText();

        if(new_description_inputted.isEmpty()){
            alert.setTitle("Error!");
            alert.setContentText("Error! The description is empty");
            alert.showAndWait();
        }
        else if(new_description_inputted.length() < 1 || new_description_inputted.length() > 256){
            alert.setTitle("Error!");
            alert.setContentText("Error! The description is empty");
            alert.showAndWait();
        }
        /*Here we are going to first check if at least the description
        or the due date was changed, in order to be saved.
        Then we are going to update the list by changing the item that we selected.
        //We are going to save back again to the List class and ListItems with their attributes.
        */
    }

    @FXML
    public void Close_ModifiedItem_Window(ActionEvent actionEvent) {
        //Here we are just closing this window that was opened with the button
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }
}
