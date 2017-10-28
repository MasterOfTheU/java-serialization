package testing;

import org.junit.Test;
import serialization.AuthorInfo;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Class <b>AuthorInfoTest</b> tests getter and setter methods from class AuthorInfo.
 */
public class AuthorInfoTest {
    @Test
    public void getFullName() throws NoSuchFieldException, IllegalAccessException {
        final AuthorInfo authorInfo = new AuthorInfo();
        Field field = authorInfo.getClass().getDeclaredField("fullName");
        field.setAccessible(true);
        field.set(authorInfo, "Edgar Allan Poe");
        final String actualResult = authorInfo.getFullName();
        assertEquals("Edgar Allan Poe", actualResult);
    }

    @Test
    public void setFullName() throws NoSuchFieldException, IllegalAccessException {
        final AuthorInfo authorInfo = new AuthorInfo();
        authorInfo.setFullName("David Arquette");
        Field field = authorInfo.getClass().getDeclaredField("fullName");
        field.setAccessible(true);
        assertEquals("David Arquette", field.get(authorInfo));
    }

    @Test
    public void getPlaceOfBirth() throws NoSuchFieldException, IllegalAccessException {
        final AuthorInfo authorInfo = new AuthorInfo();
        Field field = authorInfo.getClass().getDeclaredField("placeOfBirth");
        field.setAccessible(true);
        field.set(authorInfo, "Bangkok, Thailand");
        final String actualResult = authorInfo.getPlaceOfBirth();
        assertEquals("Bangkok, Thailand", actualResult);
    }

    @Test
    public void setPlaceOfBirth() throws NoSuchFieldException, IllegalAccessException {
        final AuthorInfo authorInfo = new AuthorInfo();
        authorInfo.setPlaceOfBirth("Nairobi, Kenya");
        Field field = authorInfo.getClass().getDeclaredField("placeOfBirth");
        field.setAccessible(true);
        assertEquals("Nairobi, Kenya", field.get(authorInfo));
    }

    @Test
    public void getYearOfBirth() throws NoSuchFieldException, IllegalAccessException {
        final AuthorInfo authorInfo = new AuthorInfo();
        Field field = authorInfo.getClass().getDeclaredField("yearOfBirth");
        field.setAccessible(true);
        field.set(authorInfo, 1995);
        final int actualResult = authorInfo.getYearOfBirth();
        assertEquals(1995, actualResult);
    }

    @Test
    public void setYearOfBirth() throws NoSuchFieldException, IllegalAccessException {
        final AuthorInfo authorInfo = new AuthorInfo();
        authorInfo.setYearOfBirth(1887);
        Field field = authorInfo.getClass().getDeclaredField("yearOfBirth");
        field.setAccessible(true);
        assertEquals(1887, field.get(authorInfo));
    }

}