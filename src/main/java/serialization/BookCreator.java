package serialization;

import static serialization.Metrics.*;

/**
 * This class provides a functionality to create new Book object.
 */
public class BookCreator {

    public Book initializeBook(String bookTitle, String bookGenre, String bookAuthorName, int yearOfPublication, AuthorInfo authorInfo, int ISBNkey, String ISBNnumber) {
        long startTime = System.currentTimeMillis();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Book book = new Book();

        book.setTitle(bookTitle);
        book.setGenre(bookGenre);
        book.setAuthorName(bookAuthorName);
        book.setYear(yearOfPublication);
        book.setAuthorInfo(authorInfo);
        book.setISBNnumber(ISBNkey, ISBNnumber);

        printMethodName(methodName);
        gatherPerformance();
        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of method %s() is %d %s\n", methodName, elapsedTime, "ms\n");
        return book;
    }


}
