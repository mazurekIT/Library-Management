package pl.mazurekit.cognifide;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.mazurekit.cognifide.model.Book;
import pl.mazurekit.cognifide.model.BooksFile;

import java.io.File;
import java.util.List;


@Component
public class JSONBookListProvider implements BookListProvider {

    private String filePath;

    public JSONBookListProvider(@Value("${bookFilePath}") String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Book> getAvailableBooks() {
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
