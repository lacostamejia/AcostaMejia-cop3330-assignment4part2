package ucf.assignment;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

//List

import java.util.ArrayList;

public class List {

    public String List_Name;
    //Here we are going to create an array list to store the items inside this list

    //Constructor for the name Initialization
    public List(String List_Name) {

        this.List_Name = List_Name;
    }

    public String getList_Name() {

        return List_Name;
    }

    public void setList_Name(String list_Name) {

        List_Name = list_Name;
    }


    public void Modify_List_Name(String Modified_List_Name){
        //Here we are going to modify the name of the list
        List_Name = Modified_List_Name;
    }

    public void Search(){
        //Here we are going to be using this method to search for a particular
        //item on a list.
    }

    public void Create_List(){
        //Here we are going to be creating a new list.
    }


    public void DeleteList(){
        this.List_Name = null;
        //We have to delete all the information of the list with this code
    }

    public void SaveList(){

        //Here we are planning to save the list

    }
    public void LoadList(){

        //Here we are going to be using it as a setter since we are going to load a list to operate with

    }
    public void Save_All_Lists(){
        //Here we are going to save multiple lists that we are operating with

    }
    public void Load_Multiple_Lists(){

        //Here we are going to load multiple lists that we are going to operate with them

    }

    public void Display_List_Items(){
        //Here we are going to display the completed items of the list
    }

    public void Display_Completed_Items(){
        //Here we are going to display the completed items of the list

    }
    public void Display_Incomplete_Items(){
        //Here we are going to display the incomplete items of the list.

    }
    @Override
    public String toString(){
        return this.getList_Name();
    }

}
