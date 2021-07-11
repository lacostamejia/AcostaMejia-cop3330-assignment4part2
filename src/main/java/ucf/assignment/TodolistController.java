package ucf.assignment;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.View;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

//Here is the controller that contains all the functions of the FXML

//Add pseudocode for each action event!

public class TodolistController implements  Initializable{

    @FXML
    public CheckBox checkBoxCompleted_Items;
    public CheckBox checkBoxIncomplete_Items;

    private Alert alert = new Alert(Alert.AlertType.ERROR); //Here we are creating an alert to be used in any error interaction

    @FXML
    public ListView<List> ViewList; //Here is the display for the list
    //final static ObservableList<List> lists = FXCollections.observableArrayList(new List("hola")); //Saving all the lists
    final static ObservableList<List> lists = FXCollections.observableArrayList(new List("hola")); //Saving all the lists

    @FXML
    public ListView<ListItems> ViewItems; //Here is the display for the items
    final static ObservableList<ListItems> items = FXCollections.observableArrayList();



    @FXML
    public Label Iten_name_selected;
    public Label Due_date_label;
    public Label Status_Item;
    public Label Description_label;
    public RadioButton rdButtonCompleted;

    //We have to call the classes of List and List_Items
    //In order to operate with all the information

    String name_item;
    String description_item;
    String Due_date_item;
    Boolean status;

    @FXML
    public void New_List(ActionEvent actionEvent) {
        //Here we are going to open a window to create a list.
        //Working!!
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewTodolist.fxml"));
            Parent root = (Parent) loader.load();
          //NewTodolistController controller = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add a new To-do List");
            stage.show();
            /*
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTodolist.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("New List");
            stage.setScene(new Scene(root1));
            stage.show();
            */


        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Working

    //We can check on how to create transform a JSON file to an observable list array;
    //we can load it into a new list here, and then add it to all the lists array, and display it back again with lists.addall(x) , viewlist.setItemslists).
    @FXML
    public void Load_List(ActionEvent actionEvent) {
/*
        ArrayList<String> list = new ArrayList<String>();
        JSONArray jsonArray = (JSONArray)jsonObject;
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i=0;i<len;i++){
                list.add(jsonArray.get(i).toString());
            }
        }
        */
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
    public void Show_Items_Of_List(MouseEvent mouseEvent) {
        /* Here we are going to click a To-do list of the list
        and we are going to display all the elements of this list on the list next to this one.

        We have to check if the Show_completed_Items or Show_Incompleted_Items is marked; in order to filter
        the items of that list.

         */
    }

    public void Show_Item_Information(MouseEvent event) {

        int index =  ViewItems.getSelectionModel().getSelectedIndex();
        Iten_name_selected.setText(items.get(index).getName());
        Description_label.setText(items.get(index).getDescription_item());
        Due_date_label.setText(items.get(index).getDue_date().toString());
        //If true
        if(items.get(index).getStatus()){
            Status_Item.setText("Completed!");
            Status_Item.setTextFill(Color.web("#00FF00", 1.0));
        }
        else{
            Status_Item.setText("Incomplete!");
            Status_Item.setTextFill(Color.web("#ff0000", 1.0));
        }
    }
        //Here when we select the corresponding Item, we are going to show the information of this item
        //Such as status, Name, Due date, and description.
        //Here we are going to use the ListItem class to show all this information

    @FXML
    public void New_Item(ActionEvent actionEvent) throws IOException {
        //Working!!
        if(lists.isEmpty()){
            alert.setTitle("Error!");
            alert.setContentText("Error! There isn't any list to add an item. Please, create a list first.");
            alert.showAndWait();
        }
        else if(ViewList.getSelectionModel().getSelectedItem() == null){
            alert.setTitle("Error!");
            alert.setContentText("Error! You have to select a list first.");
            alert.showAndWait();
        }
        else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NewTodolistItem.fxml"));
                Parent root = (Parent) loader.load();
                //NewTodolistController controller = loader.getController();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Add an Item to the list");
                // if(Show_List();)
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    } //Working

    @FXML
    public void Delete_Item(ActionEvent actionEvent) {

        if(items.isEmpty()){
            alert.setTitle("Error!");
            alert.setContentText("Error! There isn't any item to be deleted.");
            alert.showAndWait();
        }
        else if(ViewItems.getSelectionModel().getSelectedItem() == null){ //It is not selected.
            alert.setTitle("Error!");
            alert.setContentText("Error! You have to select an item first.");
            alert.showAndWait();
        }
        int index = ViewItems.getSelectionModel().getSelectedIndex(); //Here we are getting the index of the list that was selected; in order to delete this one from the array too
        ViewItems.getSelectionModel().getSelectedItem().Delete_Item(); //Here we are calling the method from the list class that is going to set tu null the name
        Dialog("The item '" + items.get(index).getName() + "' was deleted!"); //Showing a dialog box message.
        items.remove(index); //Here we are removing it from the array list.
    }// Working but check again for mistakes.

    @FXML
    public void Save_List(ActionEvent actionEvent) {
        ////We have to call the list class
        //We are going to use the method declared on this list class to save the list
    }

    @FXML
    public void Item_Is_Completed(ActionEvent actionEvent) {

        int index  = ViewItems.getSelectionModel().getSelectedIndex();

        if(ViewItems.getSelectionModel().getSelectedItem() == null){ //Nothing selected
            alert.setTitle("Error!");
            alert.setContentText("Error! There isn't any item selected.");
            alert.showAndWait();
            rdButtonCompleted.setSelected(false);
        }
        else if (rdButtonCompleted.isSelected()) {
            //Checking if was completed, then change back to incomplete the task
            if(items.get(index).getStatus() == true){
                items.get(index).setStatus(false);
                Status_Item.setText("Incomplete!");
                Status_Item.setTextFill(Color.web("#ff0000", 1.0)); //To show on green the status immediately.
                Dialog("The item '" + items.get(index).getName() + "' was changed to a status of 'incomplete'"); //Showing a dialog box message.

            }
            else { //Setting the status to true is false
                items.get(index).setStatus(true);
                Status_Item.setText("Completed!");
                Status_Item.setTextFill(Color.web("#00FF00", 1.0)); //To show on green the status immediately.
                Dialog("The item '" + items.get(index).getName() + "' was changed to a status of 'completed'"); //Showing a dialog box message.
            }
        }

        rdButtonCompleted.setSelected(false);

        // ViewItems.getSelectionModel().clearSelection();
    } //Working
        //Here we are going to check the status of the item; if is incomplete and we pressed the button; then we are going
        //to change back the status of the item. Otherwise, if is complete and we pressed again the button completed;
        //we are going to set back to incomplete the status of the item.
        //We have to use the ListItems class to show the information of the item.

    @FXML
    public void Show_Completed_Items(ActionEvent actionEvent) { //Working

        if(checkBoxCompleted_Items.isSelected() && ViewList.getSelectionModel().getSelectedItem() == null) //Checking if is selected the box but not list selected
            {
                alert.setTitle("Error!");
                alert.setContentText("Error! You have to select a list first.");
                alert.showAndWait();
                checkBoxCompleted_Items.setSelected(false);
            }
        else if(checkBoxCompleted_Items.isSelected()){

            if(checkBoxIncomplete_Items.isSelected()){ //Checking if the incomplete items is selected; so we are going to deselected.
                checkBoxIncomplete_Items.setSelected(false);
            }
            final ObservableList<ListItems> items_completed = FXCollections.observableArrayList();
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getStatus() == true) //Checking if this item is completed.
                {
                    items_completed.add(items.get(i)); //We are saving all this to display
                }
            }
            Dialog("Showing the completed items");
            ViewItems.setItems(items_completed);

        }
        else{ //If is not marked; then show all the items.
            Dialog("Showing  all items");
            ViewItems.setItems(items);
        }
        //Here we are going to filter and just show the items that are completed in the list.
        //Also, we are going to check if the Show_Incompleted_Items is marked, in order to disable that option
        //and enable this new option of filtering Show_Completed_Items.
        //We have to use the List and ListItems class to show all the information about these ones
    } //Working check for bugs

    @FXML
    public void Show_Incomplete_Items(ActionEvent actionEvent) { //Working check this part for bugs
        //Here we are going to filter and just show the items that are incompleted in the list.
        //Also, we are going to check if the Show_completed_Items is marked, in order to disable that option
        //and enable this new option of filtering Show_Completed_Items.
        //We have to use the List and ListItems classes to show all the information about these ones.

        if(checkBoxIncomplete_Items.isSelected() && ViewList.getSelectionModel().getSelectedItem() == null) //Checking if is selected the box but not list selected
        {
            alert.setTitle("Error!");
            alert.setContentText("Error! You have to select a list first.");
            alert.showAndWait();
            checkBoxIncomplete_Items.setSelected(false);
        }
        else if(checkBoxIncomplete_Items.isSelected()) {

            if (checkBoxCompleted_Items.isSelected()) {
                checkBoxCompleted_Items.setSelected(false);
            }
            final ObservableList<ListItems> items_incomplete = FXCollections.observableArrayList();
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getStatus() == false) //Checking if this item is completed.
                {
                    items_incomplete.add(items.get(i)); //We are saving all this to display
                }
            }
            Dialog("Showing the incomplete items");
            ViewItems.setItems(items_incomplete);
        }

        else{ //If is not marked; then show all the items.
            Dialog("Showing  all items");
            ViewItems.setItems(items);
        }


    } //Working check for bugs

    @FXML
    public void Load_Multiple_Lists(ActionEvent actionEvent) {
        /*
        Here we are going to load multiple lists into the list view which is the Lists.
        //We are going to add them and load them with the List class
         */
    }

    @FXML
    public void Delete_List(ActionEvent actionEvent) { //Working

        if(lists.isEmpty()){
            alert.setTitle("Error!");
            alert.setContentText("Error! There isn't any list to be deleted.");
            alert.showAndWait();
        }
        else if(ViewList.getSelectionModel().getSelectedItem() == null){ //It is not selected.
            alert.setTitle("Error!");
            alert.setContentText("Error! You have to select a list first.");
            alert.showAndWait();
        }
        int index = ViewList.getSelectionModel().getSelectedIndex(); //Here we are getting the index of the list that was selected; in order to delete this one from the array too
        Dialog("The list " + lists.get(index).getList_Name() + " was deleted!"); //Show dialog box with information
        ViewList.getSelectionModel().getSelectedItem().DeleteList(); //Here we are calling the method from the list class that is going to set tu null the name
        lists.remove(index); //Here we are removing it from the array list.

    } //Working

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
    } //Work on this

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       ViewList.setItems(lists);
       ViewItems.setItems(items);

       // System.out.println(lists);


    }

    //Check this part to associate each item with the list created.
    public void ReceiveListinformation(ObservableList <List> x){ //Here is a function to do a communication between scenes which will receive the information from another class with all the lists created.
        lists.addAll(x);
        ViewList.setItems(lists);
    }
    public void ReceiveItemInformation(ObservableList <ListItems> x){ //Here is a function to do a communication between scenes which will receive the information from another class with all the items created.
        items.addAll(x);
        ViewItems.setItems(items);
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
