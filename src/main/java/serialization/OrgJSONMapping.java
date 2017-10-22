package serialization;

import org.json.JSONObject;

import java.util.ArrayList;

import static serialization.Metrics.gatherPerformance;
import static serialization.Metrics.printMethodName;

/**
 * This class provides serialization / deserialization of books collection using org.json library.
 */
public class OrgJSONMapping {

    public static ArrayList<String> convertToJSON(ArrayList<Book> books) {
        long startTime = System.currentTimeMillis();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        System.out.println("ORG.JSON SERIALIZATION");
        ArrayList<String> jsonStrings = new ArrayList();
        JSONObject obj = new JSONObject();

        books.forEach(book -> {
            obj.put("title", book.getTitle());
            obj.put("genre", book.getGenre());
            obj.put("authorName", book.getAuthorName());
            obj.put("year", book.getYear());
            String jsonString = obj.toString();
            jsonStrings.add(jsonString);
            System.out.printf("BOOK #%d\n", books.indexOf(book)+1);
            System.out.println(jsonString);
        });

        System.out.println();
        printMethodName(methodName);
        gatherPerformance();
        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of method %s() is %d %s\n", methodName, elapsedTime, "ms\n");

        return jsonStrings;
    }

    public static ArrayList<Book> convertFromJSON(ArrayList<String> jsonStrings) {
        long startTime = System.currentTimeMillis();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        System.out.println("ORG.JSON DESERIALIZATION");
        /**New array to store converted values.*/
        ArrayList<Book> convertedStrings = new ArrayList();
        jsonStrings.forEach(jsonString -> {
            JSONObject obj = new JSONObject(jsonString);
            String title = obj.getString("title");
            String genre = obj.getString("genre");
            String authorName = obj.getString("authorName");
            int year = obj.getInt("year");

            Book book = new Book(title, genre, authorName, year);
            convertedStrings.add(book);
        });

        System.out.println();
        printMethodName(methodName);
        gatherPerformance();
        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of method %s() is %d %s\n", methodName, elapsedTime, "ms\n");

        return convertedStrings;
    }

}
