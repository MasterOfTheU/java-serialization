package testing;

import org.junit.Test;
import serialization.AuthorInfo;
import serialization.BookCreator;

import static junit.framework.TestCase.assertNotNull;

public class BookCreatorTest {
    @Test
    public void initializeBook() {
        BookCreator bc = new BookCreator();
        AuthorInfo authorTestInfo = new AuthorInfo("Test Full Name", "Test City", 1111);
        assertNotNull(bc.initializeBook("Test", "Genre", "Anon", 1111, authorTestInfo, 1, "map string value"));
    }

}