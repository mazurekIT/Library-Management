package pl.mazurekit.cognifide;

import org.junit.Test;
import pl.mazurekit.cognifide.model.Book;
import pl.mazurekit.cognifide.model.BookDto;

import java.util.ArrayList;

public class BookMapperTest {

    @Test
    public void mapperBookShouldWorkProperly() {
        BookMapper bookMapper = new BookMapper();
        ArrayList<String> strings = new ArrayList<>();
        Book book = new Book("1", "12", "title", "sub", "pub", new Long(1234), "desc", new Integer(123), "th", "pl", "prv", new Double((4.5)), new Integer(5), strings, strings);
        BookDto bookDto = new BookDto("12", "title", "sub", "pub", new Long(1234), "desc", new Integer(123), "th", "pl", "prv", new Double((4.5)), strings, strings);
        assert(bookMapper.mapperBook(book).equals(bookDto));

    }

}