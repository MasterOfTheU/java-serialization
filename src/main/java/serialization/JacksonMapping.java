package serialization;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

import static serialization.Metrics.gatherPerformance;
import static serialization.Metrics.printMethodName;

/**
 * This class provides serialization / deserialization of books collection using Jackson library.
 */
public class JacksonMapping {

    public static ArrayList<String> convertToJSON(ArrayList<Book> books) throws JsonGenerationException, JsonMappingException {
        long startTime = System.currentTimeMillis();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        System.out.println("JACKSON SERIALIZATION");
        ArrayList<String> jsonStrings = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();

        books.forEach(book -> {
            try {
                String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
                jsonStrings.add(jsonString);
                System.out.printf("BOOK #%d\n", books.indexOf(book)+1);
                System.out.println(jsonString);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

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

        System.out.println("JACKSON DESERIALIZATION");
        /**New array to store converted values.*/
        ArrayList<Book> convertedStrings = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();
        jsonStrings.forEach(jsonString -> {
            Book newBook = null;
            try {
                newBook = mapper.readValue(jsonString, Book.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
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