package pl.mazurekit.cognifide;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.mazurekit.cognifide.model.Book;

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
        ArrayList<Book> books = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {


            JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            JsonNode booksJSON = jsonNode.get(BOOKS_PROVIDER_KEY);
            Iterator<JsonNode> iterator = booksJSON.iterator();
            while (iterator.hasNext()){
                String next = iterator.next().toString();
                Book book = new ObjectMapper()
                        .readerFor(Book.class)
                        .readValue(next);
                books.add(book);
            }



            System.out.println("good");
        } catch (Exception e) {
            //TODO make it good
            e.printStackTrace();
        }

        return null;

    }


}
