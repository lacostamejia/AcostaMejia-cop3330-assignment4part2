package ucf.assignment;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

import java.time.LocalDate;

public class ListItems {
    private LocalDate date;
    private String description_item;
    private boolean status;

    //Constructor for the name Initialization
    public ListItems(LocalDate due_date, String description_item, boolean status) {
        this.date = due_date;
        this.description_item = description_item;
        this.status = status;
    }

    public LocalDate getDue_date() {
        return date;
    }

    public LocalDate setDue_date(LocalDate due_date) {
        this.date = due_date;
        return  due_date;
    }
    public boolean getStatus(){
        return status;
    }
    public boolean setStatus(Boolean status){
        this.status = status;
        return status;
    }

    public LocalDate modify_Due_date(LocalDate Modified_due_date){

        date = Modified_due_date;
        return date;
    }
    public String modify_description(String description){
        this.description_item = description;
        return description_item;
    }

    public String getDescription_item() {

        return description_item;
    }

    public String setDescription_item(String description_item) {

        this.description_item = description_item;
        return description_item;
    }
    public void Delete_Item(){ //Deleting all the values of the Item (setting them to null)
        this.description_item = null;
        this.status = false;
        this.date = null;
    }

    public boolean Display_Completed_Items(){
        return status;

    }
    public boolean Display_Incomplete_Items(){
        //Here we are going to display the incomplete items of the list.
        return status;

    }

    @Override
    //Printing on the list view with a format
    public String toString(){
        return "Due: " + this.getDue_date() + " " + this.getDescription_item();
    }

}
