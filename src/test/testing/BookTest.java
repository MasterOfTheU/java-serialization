package testing;

import org.junit.Test;
import serialization.Book;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Class <b>BookTest</b> tests getter and setter methods from class Book.
 */
public class BookTest {
    @Test
    public void getTitle() throws NoSuchFieldException, IllegalAccessException{
        final Book book = new Book();
        Field field =  book.getClass().getDeclaredField("title");
        field.setAccessible(true);
        field.set(book, "Terra");
        final String actualResult = book.getTitle();
        assertEquals("Terra", actualResult);
    }

    @Test
    public void setTitle() throws NoSuchFieldException, IllegalAccessException {
        final Book book = new Book();
        book.setTitle("Anna Karenina");
        Field field = book.getClass().getDeclaredField("title");
        field.setAccessible(true);
        assertEquals(field.get(book), "Anna Karenina");
    }

    @Test
    public void getGenre() throws NoSuchFieldException, IllegalAccessException {
        final Book book = new Book();
        Field field =  book.getClass().getDeclaredField("genre");
        field.setAccessible(true);
        field.set(book, "Fantasy");
        final String actualResult = book.getGenre();
        assertEquals("Fantasy", actualResult);
    }

    @Test
    public void setGenre() throws NoSuchFieldException, IllegalAccessException {
        final Book book = new Book();
        book.setGenre("Novel");
        Field field = book.getClass().getDeclaredField("genre");
        field.setAccessible(true);
        assertEquals(field.get(book), "Novel");
    }

    @Test
    public void getAuthorName() throws NoSuchFieldException, IllegalAccessException {
        final Book book = new Book();
        Field field =  book.getClass().getDeclaredField("authorName");
        field.setAccessible(true);
        field.set(book, "J.K.Rowling");
        final String actualResult = book.getAuthorName();
        assertEquals("J.K.Rowling", actualResult);
    }

    @Test
    public void setAuthorName() throws NoSuchFieldException, IllegalAccessException {
        final Book book = new Book();
        book.setAuthorName("John Ronald Reuel Tolkien");
        Field field = book.getClass().getDeclaredField("authorName");
        field.setAccessible(true);
        assertEquals(field.get(book), "John Ronald Reuel Tolkien");
    }

    @Test
    public void getYear() throws NoSuchFieldException, IllegalAccessException {
        final Book book = new Book();
        book.setYear(1580);
        Field field = book.getClass().getDeclaredField("year");
        field.setAccessible(true);
        assertEquals(field.get(book), 1580);
    }

    @Test
    public void setYear() throws NoSuchFieldException, IllegalAccessException {
        final Book book = new Book();
        book.setYear(1990);
        Field field = book.getClass().getDeclaredField("year");
        field.setAccessible(true);
        assertEquals(field.get(book), 1990);
    }

}