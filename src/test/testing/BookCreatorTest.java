package testing;

import org.junit.Assert;
import org.junit.Test;
import serialization.BookCreator;

public class BookCreatorTest {
    @Test
    public void initializeBook() {
        BookCreator bc = new BookCreator();
        Assert.assertNotNull(bc.initializeBook("Test", "Genre", "Anon", 1111));
    }

}