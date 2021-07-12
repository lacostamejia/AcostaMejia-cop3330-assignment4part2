package ucf.assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    List x = new List("New List");
    @Test
    void getList_Name() {
        Assertions.assertEquals("New List",x.getList_Name());
        //Here we are checking if has the same name
    }

    @Test
    void create_NewList() {
    }

    @Test
    void setList_Name() {
        Assertions.assertEquals("Hola",x.setList_Name("Hola"));
        //Here we are checking if is setting up the same name
    }

    @Test
    void removeList() {
        //assertTrue(x.RemoveList());
    }

    @Test
    void modify_List_Name() {
        //Here we are going to test the modify list name function by calling it and using assert equals in order to compare
    }

    @Test
    void deleteList() {
        assertEquals(null,x.DeleteList());
        //Here we are checking if is deleting properly so is null
    }

    @Test
    void saveList() {
        assertEquals(x.List_Name, x.SaveList());
        //Here we are checking if is saving with the same name
    }

    @Test
    void loadList() {
        assertEquals("Hola", x.LoadList("Hola"));
        //Here we are checking if is loading with the same name
    }

    @Test
    void save_All_Lists() {
    }

    @Test
    void load_Multiple_Lists() {
    }

    @Test
    void display_List_Items() {
        assertEquals(x.List_Name, x.Display_List_Items());
        //Here we are checking if is displaying the correct list with the same name
    }
}