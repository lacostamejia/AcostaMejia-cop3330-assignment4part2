package ucf.assignment;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

//List

public class List {

    public String List_Name;
    //Here we are going to create an array list to store the items inside this list

    //Constructor for the name Initialization
    public List(String List_name) {
        this.List_Name = List_name;
    }

    public String getList_Name() {

        return List_Name;
    }
    public void Create_NewList(String List_name){
        this.List_Name = List_name;
    }

    public String setList_Name(String list_Name) {
        List_Name = list_Name;
        return  List_Name;
    }
    public void RemoveList(){
        List_Name = null;
    }


    public void Modify_List_Name(String Modified_List_Name){
        //Here we are going to modify the name of the list
        List_Name = Modified_List_Name;
    }


    public String  DeleteList(){
        this.List_Name = null;
        return List_Name;
        //We have to delete all the information of the list with this code
    }

    public String SaveList(){
        return List_Name;
        //Here we are planning to save the list

    }
    public String LoadList(String name){
        this.List_Name = name;
        return  List_Name;
        //Here we are going to be using it as a setter since we are going to load a list to operate with

    }
    public void Save_All_Lists(){
        //Here we are going to save multiple lists that we are operating with

    }
    public void Load_Multiple_Lists(){

        //Here we are going to load multiple lists that we are going to operate with them

    }

    public String Display_List_Items(){
        return List_Name;
        //Here we are going to display the completed items of the list
    }

    @Override
    public String toString(){
        return this.getList_Name();
    }

}
