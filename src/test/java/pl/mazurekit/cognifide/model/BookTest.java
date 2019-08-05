package pl.mazurekit.cognifide.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private static final String SOURCE_JSON = "{\n" +
            "      \"id\": \"-SYM4PW-YAgC\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"The Religion of Java\",\n" +
            "        \"authors\": [\n" +
            "          \"Clifford Geertz\"\n" +
            "        ],\n" +
            "        \"publisher\": \"University of Chicago Press\",\n" +
            "        \"publishedDate\": \"1976-02-15\",\n" +
            "        \"description\": \"Written with\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"0226285103\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9780226285108\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"pageCount\": 392,\n" +
            "        \"categories\": [\n" +
            "          \"Religion\"\n" +
            "        ],\n" +
            "        \"averageRating\": 4.0,\n" +
            "        \"ratingsCount\": 4,\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=-SYM4PW-YAgC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=-SYM4PW-YAgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.pl/books?id=-SYM4PW-YAgC&printsec=frontcover&dq=java&hl=&cd=2&source=gbs_api\"\n" +
            "      }\n" +
            "    }";

    @Test
    public void creatBook() throws IOException {

        Book book = new ObjectMapper()
                .readerFor(Book.class)
                .readValue(SOURCE_JSON);

        assertEquals("-SYM4PW-YAgC", book.getId());
        assertEquals("9780226285108", book.getIsbn());
        assertEquals("The Religion of Java", book.getTitle());
        assertEquals(null, book.getSubtitle());
        assertEquals("University of Chicago Press", book.getPublisher());
        assertEquals(new Long(193186800), book.getPublishedDate());
        assertEquals("Written with", book.getDescription());
        assertEquals(new Integer(392), book.getPageCount());
        assertEquals("http://books.google.com/books/content?id=-SYM4PW-YAgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api", book.getThumbnailUrl());
        assertEquals("en", book.getLanguage());
        assertEquals("http://books.google.pl/books?id=-SYM4PW-YAgC&printsec=frontcover&dq=java&hl=&cd=2&source=gbs_api", book.getPreviewLink());
        assertEquals(new Double(4.0), book.getAverageRating());
        assertEquals(new Integer(4), book.getRatingsCount());

        List<String> authors =new ArrayList<>();
        authors.add("Clifford Geertz");
        assertEquals(authors,book.getAuthors());


        List<String> categories = new ArrayList<>();
        categories.add("Religion");
        assertEquals(categories, book.getCategories());
    }

}