package testing;

import org.junit.Assert;
import org.junit.Test;
import serialization.Book;
import serialization.GsonMapping;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static serialization.Main.createBooks;

public class GsonMappingTest {

    private ArrayList<Book> books = createBooks();

    @Test
    public void convertToJSON() throws Exception {
        assertNotEquals(books, GsonMapping.convertToJSON(books));
    }

    @Test
    public void convertFromJSON() throws Exception {
        assertNotEquals(GsonMapping.convertToJSON(books), GsonMapping.convertFromJSON(GsonMapping.convertToJSON(books)));
    }

}