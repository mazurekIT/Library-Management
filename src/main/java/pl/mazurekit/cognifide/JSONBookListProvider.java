package pl.mazurekit.cognifide;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
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

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            String items = jsonNode.get(BOOKS_PROVIDER_KEY).asText();

            //TODO jak to pobrać ???????????????
//            List<Book> booksList = objectMapper.readValue(items,new TypeReference<List<Book>>(){});

//            booksList.toString();
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
