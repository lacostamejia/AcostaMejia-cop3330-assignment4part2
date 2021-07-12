package ucf.assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.*;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.StringTokenizer;


/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */


public class TodolistController implements  Initializable{

    @FXML
    public CheckBox checkBoxCompleted_Items;
    public CheckBox checkBoxIncomplete_Items;
    public AnchorPane MainWindow;
    public TextField description_changed;
    public DatePicker Date_picker_changed;

    private Alert alert = new Alert(Alert.AlertType.ERROR); //Here we are creating an alert to be used in any error interaction

    @FXML
    public ListView<List> ViewList; //Here is the display for the list
    final static ObservableList<List> lists = FXCollections.observableArrayList(); //Saving all the lists

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

    FileChooser fileChooser = new FileChooser();


    @FXML
    public void New_List(ActionEvent actionEvent) {
        //Here we are going to open a window to create a list.
        //Working!!
        try {
            //Here we are calling a loader for the FXML of the next window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewTodolist.fxml"));
            Parent root = (Parent) loader.load();

            //We have to set the scene and the title for then next window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add a new To-do List");
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Completed

    @FXML
    public void Load_List(ActionEvent actionEvent) {
        //Here we are getting the stage that we are currently using; therefore, we are going to create a new Window from it
        Window stage = MainWindow.getScene().getWindow();
        //JSONParser parser = new JSONParser();
        fileChooser.setTitle("Load To-do List");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text file", "*.txt"));

        try{
            //Opening dialog to load a to-do list
            File file = fileChooser.showOpenDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile()); //Save the chosen directory

            String name_list = file.getName(); //Name of the file inputted we are going to save it.
            lists.add(new List(name_list)); //Here we are adding this name to the list of lists created.

            FileReader f = new FileReader(file.getPath()); //Here we are creating a file reader to read the text file
            BufferedReader bf = new BufferedReader(f);

            String st = bf.readLine(); //We are setting the string to read each line

            while((st = bf.readLine()) != null){ //Until there is not any item in the list , we are going to be reading more

                StringTokenizer stn = new StringTokenizer(st);

                String due_date = stn.nextToken(); //The first item read is the due date
                String description = stn.nextToken(); //Then we read the description
                String status = stn.nextToken(); //Then we read the item
                System.out.println(status);

                boolean status_x = false; //We created this variable to set to true/false depending on the string of the status read.

                LocalDate localDate = LocalDate.parse(due_date); //We are parsing the string read of the due date to be a localdate so we can operate it.

                if(status.toLowerCase().equals("incomplete")){ //Checking if the status is incomplete
                     status_x = false; //Set the status to false
                }
                else if(status.toLowerCase().equals("completed")){ //Checking if the status is completed
                     status_x = true; //Set the status to true
                }
                else if(status.toLowerCase() != "incomplete" && status.toLowerCase() != "completed"){ //If there is not compeleted/incomplete then give an error message.
                    alert.setTitle("Error!");
                    alert.setContentText("Error! The field of status has to be true/false, check this.");
                    alert.showAndWait();
                }
                items.add(new ListItems(localDate, description, status_x)); //Finally we are adding the value
            }


        }catch (Exception ex){

        }
    }//Completed, check for description with spaces

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
        Description_label.setText(items.get(index).getDescription_item());
       Due_date_label.setText(items.get(index).getDue_date().toString());
        //If true
        if(items.get(index).getStatus() == true){
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
                stage.setTitle("Add an new task");
                // if(Show_List();)
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    } //Completed

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
        Dialog("The item was deleted!"); //Showing a dialog box message.
        items.remove(index); //Here we are removing it from the array list.
    }// Completed but check again for mistakes.

    @FXML
    public void Save_List(ActionEvent actionEvent) { //Working
        ////We have to call the list class
        //We are going to use the method declared on this list class to save the list
        if(lists.isEmpty()){
            alert.setTitle("Error!");
            alert.setContentText("Error! There is not a list to save, please create/load a list first.");
            alert.showAndWait();
        }
        //We have to select a list to save first
        else if(ViewList.getSelectionModel().getSelectedItem() == null){
            alert.setTitle("Error!");
            alert.setContentText("Error! Please select a list first.");
            alert.showAndWait();
        }

        //If the there is a list; then we can save items
        else{
            Window stage = MainWindow.getScene().getWindow();
            fileChooser.setTitle("Save To-do List");
            fileChooser.setInitialFileName(ViewList.getSelectionModel().getSelectedItem().SaveList());
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));

            try{
                File file = fileChooser.showSaveDialog(stage);
                fileChooser.setInitialDirectory(file.getParentFile()); //Save the chosen directory
                FileWriter W = new FileWriter(file); //Here we are going to write
             W.write("Due_Date		Description: 		Status:");
            //Now we are going to iterate to write each value to the text file desired.
            String status = null;
            for(int i = 0; i < items.size(); i++)
            {
                //If the status is true; we want to write complete and not boolean
               if(items.get(i).getStatus()){
                   status = "Completed";
               }
               //Is false so is Incomplete
               else{
                   status = "Incomplete";

               }
                W.write("\n" + items.get(i).getDue_date().toString() + "\t\t" + items.get(i).getDescription_item() + "\t\t" + status);
            }
            W.close(); //Closing write
            Dialog("The list was saved successfully on your computer! The name of the list is " + file.getName());

            }catch (Exception ex) {

            }
        }
    }

    @FXML
    public void Item_Is_Completed(ActionEvent actionEvent) {

        //Here we are getting the index of the element on the list of items that was selected
        int index  = ViewItems.getSelectionModel().getSelectedIndex();


        if(ViewItems.getSelectionModel().getSelectedItem() == null){ //Nothing selected // Show error
            alert.setTitle("Error!");
            alert.setContentText("Error! There isn't any item selected.");
            alert.showAndWait();
            rdButtonCompleted.setSelected(false); //Put back to false the radio button
        }
        else if (rdButtonCompleted.isSelected()) {
            //Checking if was completed, then change back to incomplete the task
            if(items.get(index).getStatus() == true){ //If the item is true; then we set to false
                items.get(index).setStatus(false);
                Status_Item.setText("Incomplete!"); //Change the text
                Status_Item.setTextFill(Color.web("#ff0000", 1.0)); //To show on red the status immediately.
                Dialog("The item was changed to a status of 'incomplete'"); //Showing a dialog box message of task completed.

            }
            else { //Setting the status to true if the item is false
                items.get(index).setStatus(true);
                Status_Item.setText("Completed!");
                Status_Item.setTextFill(Color.web("#00FF00", 1.0)); //To show on green the status immediately.
                Dialog("The item was changed to a status of 'completed'"); //Showing a dialog box message of task completed.
            }
        }

        rdButtonCompleted.setSelected(false); //Change back to not selected the radio button
    } //Completed

    @FXML
    public void Show_Completed_Items(ActionEvent actionEvent) { //Working

        if(checkBoxCompleted_Items.isSelected() && ViewList.getSelectionModel().getSelectedItem() == null) //Checking if is selected the box but not list selected
            {
                //Send error message
                alert.setTitle("Error!");
                alert.setContentText("Error! You have to select a list first.");
                alert.showAndWait();
                checkBoxCompleted_Items.setSelected(false);
            }
        else if(checkBoxCompleted_Items.isSelected()){

            if(checkBoxIncomplete_Items.isSelected()){ //Checking if the incomplete items is selected; so we are going to deselected the incomplete items box.
                checkBoxIncomplete_Items.setSelected(false);
            }
            final ObservableList<ListItems> items_completed = FXCollections.observableArrayList(); //Here we are creating another obersable lists in order to add the items that are completed.

            for (int i = 0; i < items.size(); i++) { //We are doing a for loop for all the items

                if (items.get(i).Display_Completed_Items() == true) //Checking if this item is completed.
                {
                    items_completed.add(items.get(i)); //We are saving all this to display
                }
            }
            Dialog("Showing the completed items"); //Showing a dialog box message of task completed.
            ViewItems.setItems(items_completed); //Show the items that are completed

        }
        else{ //If is not marked; then show all the items.
            Dialog("Showing  all items");//Showing a dialog box message of task .
            ViewItems.setItems(items);
        }
        //Here we are going to filter and just show the items that are completed in the list.
        //Also, we are going to check if the Show_Incompleted_Items is marked, in order to disable that option
        //and enable this new option of filtering Show_Completed_Items.

    } //Completed check for bugs

    @FXML
    public void Show_Incomplete_Items(ActionEvent actionEvent) { //Working check this part for bugs

        //Here we are going to filter and just show the items that are incomplete in the list.
        //Also, we are going to check if the Show_completed_Items is marked, in order to disable that option
        //and enable this new option of filtering Show_Completed_Items.

        if(checkBoxIncomplete_Items.isSelected() && ViewList.getSelectionModel().getSelectedItem() == null) //Checking if is selected the box but not list selected
        {
            //Send error message
            alert.setTitle("Error!");
            alert.setContentText("Error! You have to select a list first.");
            alert.showAndWait();
            checkBoxIncomplete_Items.setSelected(false); //Take back to false the check box as unchecked
        }
        else if(checkBoxIncomplete_Items.isSelected()) {

            if (checkBoxCompleted_Items.isSelected()) { //If the completed items check box is selected, we are going to unselect this one.
                checkBoxCompleted_Items.setSelected(false);
            }
            final ObservableList<ListItems> items_incomplete = FXCollections.observableArrayList(); //Creating another observables list to store all the items incomplete.

            for (int i = 0; i < items.size(); i++) { //Doing a for loop to add all the items incomplete into this new observables list
                if (items.get(i).Display_Incomplete_Items() == false) //Checking if this item is completed.
                {
                    items_incomplete.add(items.get(i)); //We are saving all this to display
                }
            }
            Dialog("Showing the incomplete items"); //Showing a dialog box message of task completed.
            ViewItems.setItems(items_incomplete); //Here we are showing the items that are incomplete.
        }
        else{ //If is not marked; then show all the items.
            Dialog("Showing  all items"); //Showing a dialog box message of task.
            ViewItems.setItems(items); //Showing all the items to the view list of items.
        }


    } //Completed check for bugs

    @FXML
    public void Load_Multiple_Lists(ActionEvent actionEvent) {
        /*
        Here we are going to load multiple lists into the list view which is the Lists.
        //We are going to add them and load them with the List class
         */
    }

    @FXML
    public void Delete_List(ActionEvent actionEvent) { //Working

        if(lists.isEmpty()){ //Show error if there isn't any list to delete
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

    } //Completed
    @FXML
    public void Delete_All_Items(ActionEvent event) {

        if(ViewList.getSelectionModel().getSelectedItem() == null){ //Checking if there isn't any list selected to delete all the items
            alert.setTitle("Error!"); //Show error message
            alert.setContentText("Error! Select an list to delete all items first");
            alert.showAndWait();
        }
        else{
            Dialog("The items of the list '" + ViewList.getSelectionModel().getSelectedItem() + "' were deleted successfully"); //Show message of task completed
            items.clear(); //Clear the items
        }
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


        //There isn't any item selected
        if(ViewItems.getSelectionModel().getSelectedItem() == null){
            alert.setTitle("Error!"); //Show error message
            alert.setContentText("Error! Select a task first to be modified");
            alert.showAndWait();
        }

        String description_modified = description_changed.getText(); //Get the text
        items.get(ViewItems.getSelectionModel().getSelectedIndex()).modify_Due_date(Date_picker_changed.getValue()); //Get the new date
        items.get(ViewItems.getSelectionModel().getSelectedIndex()).modify_description(description_changed.getText()); //Get the new description
        Dialog("The task was modified correctly!"); //Show that the task was completed successfully.
        Date_picker_changed.setValue(null); //Set back to null the values
        description_changed.clear();
    } //Completed

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       ViewList.setItems(lists);
       ViewItems.setItems(items);
       fileChooser.setInitialDirectory(new File("C:/Users/thelu/Desktop"));

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
