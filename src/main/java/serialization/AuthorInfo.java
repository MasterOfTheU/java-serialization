package serialization;

/**
 * This class provides a brief information about book author.
 */
public class AuthorInfo {
    private String fullName;
    private String placeOfBirth;
    private int yearOfBirth;

    public AuthorInfo() {}

    public AuthorInfo(String fullName, String placeOfBirth,int yearOfBirth) {
        this.fullName = fullName;
        this.placeOfBirth = placeOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

}