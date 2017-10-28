package serialization;

import java.util.HashMap;

public class Book {

    private String title;
    private String genre;
    private String authorName;
    private int yearOfPublication;
    private AuthorInfo authorInfo;
    private HashMap<Integer, String> ISBNnumber = new HashMap<>();

    public Book() {}

    public Book(String title, String genre, String authorName, int yearOfPublication, AuthorInfo authorInfo, int ISBNkey, String ISBNnumber) {
        this.title = title;
        this.genre = genre;
        this.authorName = authorName;
        this.yearOfPublication = yearOfPublication;
        this.authorInfo = authorInfo;
        this.ISBNnumber.put(ISBNkey, ISBNnumber);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYear() {
        return yearOfPublication;
    }

    public void setYear(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public AuthorInfo getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(AuthorInfo authorInfo) {
        this.authorInfo = authorInfo;
    }

    public HashMap<Integer, String> getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(int ISBNkey, String ISBNnumber) {
        this.ISBNnumber.put(ISBNkey, ISBNnumber);
    }
}
