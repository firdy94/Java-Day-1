package ibf2021.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Unit test for simple App.
 */
public class ShoppingListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

@BeforeEach
public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
}

@AfterEach
public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
}


    
    @Test public void shoppingListAddItem_normalCondition()
    {
        ShoppingList myList = new ShoppingList();
        myList.addItem("Apple");

        assertEquals("Apple added to your cart", outContent.toString().trim());

    }

    @Test public void shoppingListAddItem_duplicateCondition()
    {
        List<String> itemList = new ArrayList<>();
        itemList.add("Apple");
        ShoppingList myList = new ShoppingList(itemList);
        myList.addItem("Apple");

        assertEquals("You have Apple in your cart", outContent.toString().trim());

    }
    @Test public void shoppingListRemoveItem_normalCondition()
    {
        List<String> itemList = new ArrayList<>();
        itemList.add("Apple");
        ShoppingList myList = new ShoppingList(itemList);
        myList.removeItem(0);

        assertEquals("Apple removed from your cart", outContent.toString().trim());

    }
    @Test public void shoppingListRemoveItem_negativeCondition()
    {
        List<String> itemList = new ArrayList<>();
        ShoppingList myList = new ShoppingList(itemList);
        myList.removeItem(1);

        assertEquals("Incorrect item index", outContent.toString().trim());

    }
    
    @Test public void shoppingListGetItem_normalCondition()
    {   
        List<String> itemList = new ArrayList<>();
        itemList.add("Apple");
        ShoppingList myList = new ShoppingList(itemList);
        myList.getItem();

        assertEquals("1. Apple", outContent.toString().trim());

    }
    @Test public void shoppingListGetItem_negativeCondition()
    {   
        ShoppingList myList = new ShoppingList();
        myList.getItem();

        assertEquals("Your cart is empty", outContent.toString().trim());

    }
    @Test public void ShoppingListCheckInput_loginCondition(){
        ShoppingList myList = new ShoppingList();
        InputStream sysInBackup = System.in; 
        ByteArrayInputStream in = new ByteArrayInputStream("login Firdaus".getBytes());
        System.setIn(in);
        myList.checkInput();
        System.setIn(sysInBackup);
        assertEquals("login", myList.getInput());
        assertEquals("firdaus", myList.getInputList()[1]);

    }
    @Test public void ShoppingListCheckInput_addCondition(){
        ShoppingList myList = new ShoppingList();
        InputStream sysInBackup = System.in; 
        ByteArrayInputStream in = new ByteArrayInputStream("add apple".getBytes());
        System.setIn(in);
        myList.checkInput();
        System.setIn(sysInBackup);
        assertEquals("add", myList.getInput());
        assertEquals("apple", myList.getInputList()[1]);
    }

        



    
}
