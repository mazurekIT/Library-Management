package pl.mazurekit.cognifide;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.mazurekit.cognifide.model.Book;
import pl.mazurekit.cognifide.model.BooksFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JSONBookListProvider implements BookListProvider {

    private String filePath;

    public JSONBookListProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Book> getAvailableBooks() {
        ArrayList<Book> books = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            BooksFile booksFile = objectMapper.readValue(new File(filePath), BooksFile.class);
            return booksFile.getItems();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
