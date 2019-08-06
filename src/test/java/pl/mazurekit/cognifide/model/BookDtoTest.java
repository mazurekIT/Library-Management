package pl.mazurekit.cognifide.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookDtoTest {

    @Test
    public void creat() {
        ArrayList<String> strings = new ArrayList<>();
        BookDto bookDto = new BookDto(
                "12",
                "title",
                "sub",
                "pub",
                new Long(1234),
                "desc",
                new Integer(123),
                "th",
                "pl",
                "prv",
                new Double((4.5)),
                strings,
                strings);
        assertEquals("12", bookDto.getIsbn());
        assertEquals("title", bookDto.getTitle());
        assertEquals("sub", bookDto.getSubtitle());
        assertEquals("pub", bookDto.getPublisher());
        assertEquals(new Long(1234), bookDto.getPublishedDate());
        assertEquals("desc", bookDto.getDescription());
        assertEquals(new Integer(123), bookDto.getPageCount());
        assertEquals("th", bookDto.getThumbnailUrl());
        assertEquals("pl", bookDto.getLanguage());
        assertEquals("prv", bookDto.getPreviewLink());
        assertEquals(new Double(4.5), bookDto.getAverageRating());
        assertEquals(strings, bookDto.getAuthors());
        assertEquals(strings, bookDto.getCategories());

    }

}