package ucf.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

//Here is the controller that contains all the functions of the FXML

//Add pseudocode for each action event!

public class TodolistController {

    //We have to call the classes of List and List_Items
    //In order to operate with all the information

    @FXML
    public void New_List(ActionEvent actionEvent) {

        //Here we are going to open a window to create a list.
        //Working!!
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTodolist.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("New List");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void Load_List(ActionEvent actionEvent) {
        //Here we are going to load a list to program.
        ////We have to call the list class
    }
    @FXML
    public void Save_All_Lists(ActionEvent actionEvent) {
        /* Here we are going to save all the lists, if we make changes to all of them.
         //We have to call the list class
         * */
    }
    @FXML
    public void Show_List(MouseEvent mouseEvent) {
        /* Here we are going to click a To-do list of the list
        and we are going to display all the elements of this list on the list next to this one.

        We have to check if the Show_completed_Items or Show_Incompleted_Items is marked; in order to filter
        the items of that list.

         */
    }
    @FXML
    public void New_Item(ActionEvent actionEvent) throws IOException {
        //Working!!
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTodolistItem.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("New Item");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void Delete_Item(ActionEvent actionEvent) {
        //We have to call the Item class
        //We are going to clear this variable
    }
    @FXML
    public void Save_List(ActionEvent actionEvent) {
        ////We have to call the list class
        //We are going to use the method declared on this list class to save the list
    }
    @FXML
    public void Item_Is_Completed(ActionEvent actionEvent) {
        //Here we are going to check the status of the item; if is incomplete and we pressed the button; then we are going
        //to change back the status of the item. Otherwise, if is complete and we pressed again the button completed;
        //we are going to set back to incomplete the status of the item.
        //We have to use the ListItems class to show the information of the item.
    }
    @FXML
    public void Show_Completed_Items(ActionEvent actionEvent) {
        //Here we are going to filter and just show the items that are completed in the list.
        //Also, we are going to check if the Show_Incompleted_Items is marked, in order to disable that option
        //and enable this new option of filtering Show_Completed_Items.
        //We have to use the List and ListItems class to show all the information about these ones
    }
    @FXML
    public void Show_Incomplete_Items(ActionEvent actionEvent) {
        //Here we are going to filter and just show the items that are incompleted in the list.
        //Also, we are going to check if the Show_completed_Items is marked, in order to disable that option
        //and enable this new option of filtering Show_Completed_Items.
        //We have to use the List and ListItems classes to show all the information about these ones.
    }
    @FXML
    public void Load_Multiple_Lists(ActionEvent actionEvent) {
        /*
        Here we are going to load multiple lists into the list view which is the Lists.
        //We are going to add them and load them with the List class
         */
    }
    @FXML
    public void Delete_List(ActionEvent actionEvent) {
        //Here we are going to check in the show_list what was the list that was selected.
        //Then if this list is selected, and we press this button, we are going to delete all this list.
        //We are going to use the List class, and delete all the attributes that belong to the list
    }
    @FXML
    public void Edit_Name_List(ActionEvent actionEvent) {
        //Here we are going to check in the show_list what was the list that was selected.
        //Then if this list is selected, and we press this button, we are going to edi the name of this list.
        //Here we are going to use the List class.
    }
    @FXML
    public void Modify_Item(ActionEvent actionEvent) {
        //Here we are opening a new window that will be used to modify the description or the due date of this item.
        //For this new window and class, we have to pass as parameter the List, and Item_List, which we have to specify the item
        //of this item_list.
        //We have to check which item on the List_Items was selected, and click the button.
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyItemlist.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("New Item");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Show_Item_Information(MouseEvent mouseEvent) {
        //Here when we select the corresponding Item, we are going to show the information of this item
        //Such as status, Name, Due date, and description.
        //Here we are going to use the ListItem class to show all this information
    }
}
