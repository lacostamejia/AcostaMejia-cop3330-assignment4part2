package ucf.assignment;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

public class ListItems {
    private String name;
    private String due_date;
    private String description_item;
    private boolean status;

    //Constructor for the name Initialization
    public ListItems(String name, String due_date, String description_item, boolean status) {
        this.name = name;
        this.due_date = due_date;
        this.description_item = description_item;
        this.status = status = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public void modify_Due_date(String Modified_due_date){
        due_date = Modified_due_date;
    }

    public String getDescription_item() {

        return description_item;
    }

    public void setDescription_item(String description_item) {

        this.description_item = description_item;
    }

    public void modify_Description_Item(){
        //Here we are going to modify the description of the item
        //by searching the item we would like to modify
    }

    public void Delete_Item(String name){
        //Here we are going to delete the item
    }
    public void Add_New_Item(){
        //This is going to be used to add a new item and using the attributes above.
    }

}
