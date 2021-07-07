package ucf.assignment;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewTodoListItemController {

    @FXML
    public AnchorPane New_due_date;
    @FXML
    public TextField New_item_name;
    @FXML
    public TextField New_description;
    
    //Here we are going to receive as parameter the list and the items_list for that exact to-do list.

    @FXML
    public void CloseNewItem_Window(ActionEvent actionEvent) {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
        //Closing Window
    }
    @FXML
    public void AddNewItem(ActionEvent actionEvent) {
             /* Here we are going to save and add back to the current list the new item with its
        description, due date, and name.
        We have to check if there is a item already created with the same name,
        we have to check if the item, description or due date is null or empty.
        We have to access to the ListItems class, in order to create new items with all the information there
        Then we have to attach this item to the List
         */
    }
}
