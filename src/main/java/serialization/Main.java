package serialization;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.*;

import static serialization.Metrics.*;

public class Main {

    public static void main(String[] args) throws JsonMappingException, JsonGenerationException {

        ArrayList<Book> books = createBooks();
        convertWithJackson(books);
        convertWithOrgJSON(books);
        convertWithGoogleGSON(books);
    }

    //region BooksInfo
    public static ArrayList<Book> createBooks() {
        long startTime = System.currentTimeMillis();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        ArrayList<Book> books = new ArrayList<>();
        BookCreator bc = new BookCreator();
        books.add(bc.initializeBook("War and Peace", "Novel", "Leo Tolstoy", 1867));
        books.add(bc.initializeBook("Harry Potter and the Philosopher's Stone", "Fantasy", "J. K. Rowling", 1997));
        /**The demonstrative usage of constructor without parameters*/
        books.add(new Book());
        printBooksInfo(books);

        printMethodName(methodName);
        gatherPerformance();
        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of method %s() is %d %s\n", methodName, elapsedTime, "ms\n");

        return books;
    }

    public static void printBooksInfo(ArrayList<Book> books) {
        books.forEach(book -> {
            System.out.printf("BOOK TITLE: %s\n", book.getTitle());
            System.out.printf("BOOK GENRE: %s\n", book.getGenre());
            System.out.printf("AUTHOR NAME: %s\n", book.getAuthorName());
            System.out.printf("YEAR OF PUBLISHING: %d\n", book.getYear());
            System.out.println();
        });
    }

    //endregion

    //region Converting

    /**
     * @param books is an array generated with method createBooks().
     * @see Main#createBooks()
     * @throws JsonMappingException
     * @throws JsonGenerationException
     */

    private static void convertWithJackson(ArrayList<Book> books) throws JsonMappingException, JsonGenerationException {
        ArrayList<String> jsonStrings = JacksonMapping.convertToJSON(books);
        ArrayList<Book> convertedBooks = JacksonMapping.convertFromJSON(jsonStrings);
        printBooksInfo(convertedBooks);
    }

    private static void convertWithOrgJSON(ArrayList<Book> books) {
        ArrayList<String> jsonStrings = OrgJSONMapping.convertToJSON(books);
        ArrayList<Book> convertedBooks = OrgJSONMapping.convertFromJSON(jsonStrings);
        printBooksInfo(convertedBooks);
    }

    private static void convertWithGoogleGSON(ArrayList<Book> books) {
        ArrayList<String> jsonStrings = GsonMapping.convertToJSON(books);
        ArrayList<Book> convertedBooks = GsonMapping.convertFromJSON(jsonStrings);
        printBooksInfo(convertedBooks);
    }
    //endregion
}
