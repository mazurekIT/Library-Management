package pl.mazurekit.cognifide;

import org.springframework.stereotype.Component;
import pl.mazurekit.cognifide.model.Book;

import java.util.List;

@Component
public interface BookListProvider {
    List<Book> getAvailableBooks();
}
