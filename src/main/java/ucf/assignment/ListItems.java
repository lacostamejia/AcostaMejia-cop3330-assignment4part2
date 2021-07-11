package ucf.assignment;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

import java.time.LocalDate;

public class ListItems {
    private String name;
    private LocalDate date;
    private String description_item;
    private boolean status;

    //Constructor for the name Initialization
    public ListItems(String name, LocalDate due_date, String description_item, boolean status) {
        this.name = name;
        this.date = due_date;
        this.description_item = description_item;
        this.status = status = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDue_date() {
        return date;
    }

    public void setDue_date(LocalDate due_date) {

        this.date = due_date;
    }
    public boolean getStatus(){
        return status;
    }
    public void setStatus(Boolean status){
        this.status = status;
    }

    public void modify_Due_date(LocalDate Modified_due_date){

        date = Modified_due_date;
    }

    public String getDescription_item() {

        return description_item;
    }

    public void setDescription_item(String description_item) {

        this.description_item = description_item;
    }
    public void Delete_Item(){ //Deleting all the values of the Item (setting them to null)
        this.name = null;
        this.description_item = null;
        this.status = false;
        this.date = null;
    }

    @Override
    //Printing on the list view with a format
    public String toString(){
        return this.getName() + " " + "Due: " + this.getDue_date() + " " + this.getDescription_item();
    }

}
