package pl.mazurekit.cognifide;


import org.springframework.stereotype.Component;
import pl.mazurekit.cognifide.model.Book;
import pl.mazurekit.cognifide.model.BookDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

    public BookDto mapperBook(Book book) {
        return new BookDto(book.getIsbn(), book.getTitle(), book.getSubtitle(), book.getPublisher(), book.getPublishedDate(), book.getDescription(), book.getPageCount(), book.getThumbnailUrl(), book.getLanguage(), book.getPreviewLink(), book.getAverageRating(), book.getAuthors(), book.getCategories());
    }


    public List<BookDto> mapperBooksList(List<Book> booksList) {
        List<BookDto> booksDto = new ArrayList<>();
        for (Book book : booksList) {
            booksDto.add(mapperBook(book));
        }
        return booksDto;
    }
}
