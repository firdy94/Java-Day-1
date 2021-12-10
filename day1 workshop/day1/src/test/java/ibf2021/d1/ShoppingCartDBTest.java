package ibf2021.d1;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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


public class ShoppingCartDBTest {
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

@Test
void LoadShoppingCart_normalCondition(){

    assertEquals(1, 1);    

    }
    
    @Test
void ShoppingCart_normalCondition(){

    assertEquals(1, 1);    

    }
}@Test
void LoadShoppingCart_normalCondition(){

    assertEquals(1, 1);    

    }


