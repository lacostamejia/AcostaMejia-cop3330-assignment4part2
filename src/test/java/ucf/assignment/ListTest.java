package ucf.assignment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Andres Acosta Mejia
 */

import static org.junit.jupiter.api.Assertions.*;

/*
    A user shall be able to display all of the existing items in a todo list -
    A user shall be able to display only the incompleted items in a todo list -
    A user shall be able to display only the completed items in a todo list -
    A user shall be able to save all of the items in a single todo list to external storage
    A user shall be able to save all of the items across all of the todo lists to external storage
    A user shall be able to load a single todo list that was previously saved to external storage
    A user shall be able to load multiple todo lists that were previous saved to external storage
 */

class ListTest {

    @Test
    @DisplayName("Create a new List")
    void Create_NewList() {
        //Here we are going to check if the new list is being created correctly
        //We can check if the name of the new list is NUll or empty
    }

    @Test
    @DisplayName("Remove or Delete a List")
    void Remove_List() {
        /*
        Here we are going to check if the list is being removed such as cleaning the internal variables of this one such as the items and the name of this.
         */
    }

    @Test
    @DisplayName("Modify List title correctly")
    void Modify_List_Name() {
        /*
        Here we are going to check if the name of the list being changed succesfully.
        A user shall be able to add a new item to an existing todo list
A user shall be able to remove an item from an existing todo list
         */
    }

    @Test
    @DisplayName("Complete Items display")
    public void Display_Completed_Items() {
        //Here we are going to display the completed items of the list

    }

    @Test
    @DisplayName("Incomplete Items Display correctly")
    public void Display_Incomplete_Items() {
        //Here we are going to display the incomplete items of the list.
    }

    @Test
    @DisplayName("All Items Display correctly")
    public void Display_List_Items() {
        //Here we are going to display the completed items of the list
    }

    @Test
    @DisplayName("All Items Display correctly")
    public void SaveList() {

        //Here we are planning to save the list

    }

    @Test
    @DisplayName("Load list correctly")
    public void LoadList() {

        //Here we are going to be using it as a setter since we are going to load a list to operate with

    }

    @Test
    @DisplayName("Save all lists correctly ")
    public void Save_All_Lists() {
        //Here we are going to save multiple lists that we are operating with

    }

    @Test
    @DisplayName("Load multiple lists correctly")
    public void Load_Multiple_Lists() {

        //Here we are going to load multiple lists that we are going to operate with them
    }
}