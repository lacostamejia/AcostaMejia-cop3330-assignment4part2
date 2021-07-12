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
import javafx.stage.Stage;

import java.io.IOException;

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
            Dialog("The list '" + name_list + "' was created successfully!");
        }

    }
    @FXML
    public void Close_New_todo_list(ActionEvent actionEvent) throws IOException { //Working
        //Sending information to the main controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Todolist.fxml"));
        Parent root = loader.load();
        TodolistController controller = loader.getController();
        controller.ReceiveListinformation(lists);

        //Closing window
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();

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

