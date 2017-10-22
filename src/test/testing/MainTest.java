package testing;

import org.junit.*;
import org.junit.Assert;
import serialization.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class MainTest {

    @Test
    public void createBooks() {
        ArrayList<Book> books = Main.createBooks();
        for (Book b: books) {
            Assert.assertNotNull(b);
        }
    }

    /**
     * Check if the method prints out a valid value.
     */
    @Test
    public void printBooksInfo() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String actualResult = Main.createBooks().get(0).getTitle();
        String expected = "War and Peace";
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void printBooksInfoFailed() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String actualResult = Main.createBooks().get(0).getTitle() + "qwerty";
        String expected = "War and Peace";
        Assert.assertNotEquals(expected, actualResult);
    }
}
