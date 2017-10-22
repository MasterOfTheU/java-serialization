package serialization;

import com.google.gson.Gson;

import java.util.ArrayList;

import static serialization.Metrics.gatherPerformance;
import static serialization.Metrics.printMethodName;

/**
 * This class provides serialization / deserialization of books collection using Google GSON library.
 */
public class GsonMapping {
    public static ArrayList<String> convertToJSON(ArrayList<Book> books) {
        long startTime = System.currentTimeMillis();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        System.out.println("GOOGLE GSON SERIALIZATION");
        ArrayList<String> jsonStrings = new ArrayList();
        Gson gson = new Gson();

        books.forEach(book -> {
            String jsonString = gson.toJson(book);
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

        System.out.println("GOOGLE GSON DESERIALIZATION");
        /**New array to store converted values.*/
        ArrayList<Book> convertedStrings = new ArrayList();
        Gson gson = new Gson();

        jsonStrings.forEach(jsonString -> {
            Book newBook = gson.fromJson(jsonString, Book.class);
            convertedStrings.add(newBook);
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
