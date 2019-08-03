package pl.mazurekit.cognifide;

import pl.mazurekit.cognifide.model.Book;

import java.util.List;

public interface BookListProvider {
    List<Book> getAvailableBooks();
}
