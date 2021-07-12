package ucf.assignment;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ListItemsTest {
    //Here are the variables and settings used to check the tests.
    String date = "2021-11-30";
    String datechanged = "2021-07-30";
    LocalDate localDate = LocalDate.parse(date); //We are parsing the string read of the due date to be a localdate so we can operate it.
    LocalDate localDateChanged = LocalDate.parse(datechanged);
    ListItems x = new ListItems(localDate,"Family Born",false);

    @Test
    void getDue_date() {
        //Here we are checking if we are getting the correct due date.
        assertEquals(localDate,x.getDue_date());
    }

    @Test
    void setDue_date() {
        //Here we are checking if we are setting the correct due date.
        assertEquals(localDateChanged,x.setDue_date(localDateChanged));
    }

    @Test
    void getStatus() {
        //Here we are checking if we are getting the correct status item.
        assertEquals(false,x.getStatus());

    }
    @Test
    void setStatus() {
        //Here we are checking if the item status is being settled correctly.
        assertEquals(true,x.setStatus(true));
    }

    @Test
    void modify_Due_date() {
        //Here we are checking if the item due date is being modified correctly.
        assertEquals(localDateChanged,x.modify_Due_date(localDateChanged));
    }

    @Test
    void modify_description() {
        //Here we are checking if the item description is being modified correctly.
        assertEquals("hola",x.modify_description("hola"));
    }

    @Test
    void getDescription_item() {
        //Here we are checking if we are getting the correct description of the item
        assertEquals("Family Born",x.getDescription_item());
    }

    @Test
    void setDescription_item() {
        //Here we are checking if the item description was settled correctly.
        assertEquals("hola",x.setDescription_item("hola"));
    }

    @Test
    void delete_Item() {
        //Here we are setting deleting all the values and checking if they are null which is empty.
        x.Delete_Item();
        assertEquals(null, x.getDescription_item());
        assertEquals(null, x.getDue_date());
        assertEquals(false, x.getStatus());
    }

    @Test
    void display_Completed_Items() {
        //Here we are setting the value to true, in order to be tested
        x.setStatus(true);
        assertEquals(true, x.getStatus());
    }

    @Test
    void display_Incomplete_Items() {
        //Here we are setting the value to false, in order to be tested
        x.setStatus(false);
        assertEquals(false, x.getStatus());
    }
}