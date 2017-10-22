package testing;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.Test;
import serialization.Book;
import serialization.JacksonMapping;


import java.util.ArrayList;

import static org.junit.Assert.*;
import static serialization.Main.*;


public class JacksonMappingTest {

    private ArrayList<Book> books = createBooks();

    @Test
    public void convertToJSON()  throws JsonGenerationException, JsonMappingException {
        assertNotEquals(books, JacksonMapping.convertToJSON(books));
    }

    @Test
    public void convertFromJSON() throws JsonGenerationException, JsonMappingException {
        assertNotEquals(JacksonMapping.convertToJSON(books), JacksonMapping.convertFromJSON(JacksonMapping.convertToJSON(books)));
    }

}