package serialization;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
            obj.put("yearOfPublication", book.getYear());

                AuthorInfo authorInfo = book.getAuthorInfo();
                JSONObject jsonBook = new JSONObject();
                jsonBook.put("fullName", authorInfo.getFullName());
                jsonBook.put("placeOfBirth", authorInfo.getPlaceOfBirth());
                jsonBook.put("yearOfBirth", authorInfo.getYearOfBirth());
                obj.put("authorInfo", jsonBook);

            HashMap<Integer, String> isbnNumber = book.getISBNnumber();
            obj.put("ISBNnumber", isbnNumber);
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
            Integer mapKey = 0;
            String mapValue = "";
            JSONObject obj = new JSONObject(jsonString);
            String title = obj.getString("title");
            String genre = obj.getString("genre");
            String authorName = obj.getString("authorName");
            int year = obj.getInt("yearOfPublication");

            JSONObject jsonAuthorInfo = obj.getJSONObject("authorInfo");
            AuthorInfo authorInfo = parseJSONtoAuthorInfo(jsonAuthorInfo);

            JSONObject ISBNnumber = obj.getJSONObject("ISBNnumber");
            HashMap<Integer, String> finalMap = parseJSONtoMap(ISBNnumber);

            for ( Map.Entry<Integer, String> entry : finalMap.entrySet()) {
                mapKey = entry.getKey();
                mapValue = entry.getValue();
            }

            Book book = new Book(title, genre, authorName, year, authorInfo, mapKey, mapValue);
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

    /**
     * @param jsonObject - The original JSON object that has to be parsed to AuthorInfo object.
     * @return
     * @throws JSONException
     */
    private static AuthorInfo parseJSONtoAuthorInfo(JSONObject jsonObject) throws JSONException {
        AuthorInfo authorInfo= new AuthorInfo(
                jsonObject.getString("fullName"),
                jsonObject.getString("placeOfBirth"),
                jsonObject.getInt("yearOfBirth")
        );
        return authorInfo;
    }

    /**
     * @param jsonObject - the original JSON object that has to be parsed to HashMap.
     * @return Book ISBN number as a HashMap object.
     * @throws JSONException
     */
    private static HashMap<Integer, String> parseJSONtoMap(JSONObject jsonObject) throws JSONException {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            Integer keyInt = Integer.parseInt(key);
            String value = jsonObject.getString(key);
            map.put(keyInt, value);
        }

        return map;
    }
}
