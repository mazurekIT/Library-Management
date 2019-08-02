package pl.mazurekit.cognifide;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONBookListProvider implements BookListProvider {

    private String filePath;
    private static final String BOOKS_PROVIDER_KEY = "items";

    public JSONBookListProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Book> getAvailableBooks() {
        List<Book> booksList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {


            booksList.toString();
        } catch (Exception e) {
            //TODO make it good
            e.printStackTrace();
        }

        return null;

    }

    private List<JSONObject> getJsonObjectsList(JSONObject jsonObject) {
        JSONArray jsonBooks = (JSONArray) jsonObject.get(BOOKS_PROVIDER_KEY);
        List<JSONObject> jsonObjectList = new ArrayList<>();
        Iterator<JSONObject> jsonObjectIterator = jsonBooks.iterator();

        while (jsonObjectIterator.hasNext()) {
            jsonObjectList.add(jsonObjectIterator.next());
        }
        return jsonObjectList;
    }


}
