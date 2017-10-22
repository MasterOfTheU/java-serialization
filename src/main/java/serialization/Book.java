package serialization;

public class Book {

    private String title;
    private String genre;
    private String authorName;
    private int year;

    public Book() {
        this.title = "Unknown";
        this.genre = "Unknown";
        this.authorName = "Unknown";
        this.year = 0;
    }

    public Book(String title, String genre, String authorName, int year) {
        this.title = title;
        this.genre = genre;
        this.authorName = authorName;
        this.year = year;
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
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
