package testing;

import org.junit.Test;
import serialization.Book;
import serialization.OrgJSONMapping;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static serialization.Main.createBooks;

public class OrgJSONMappingTest {

    private ArrayList<Book> books = createBooks();

    @Test
    public void convertToJSON() throws Exception {
        assertNotEquals(books, OrgJSONMapping.convertToJSON(books));
    }

    @Test
    public void convertFromJSON() throws Exception {
        assertNotEquals(OrgJSONMapping.convertToJSON(books), OrgJSONMapping.convertFromJSON(OrgJSONMapping.convertToJSON(books)));
    }

}