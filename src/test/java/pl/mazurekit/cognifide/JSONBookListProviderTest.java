package pl.mazurekit.cognifide;

import org.junit.Test;
import pl.mazurekit.cognifide.model.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JSONBookListProviderTest {

    @Test
    public void shouldGetProperSizeOfBooksList() {
        JSONBookListProvider jsonBookListProvider = new JSONBookListProvider(filePath());
        int expectedSizeOfBookList = 2;
        assertEquals(expectedSizeOfBookList, jsonBookListProvider.getAvailableBooks().size());
    }

    @Test
    public void shouldGetTheSameListOfBooks() {
        JSONBookListProvider jsonBookListProvider = new JSONBookListProvider(filePath());
        List<Book> actualBooksList = jsonBookListProvider.getAvailableBooks();
        List<Book> expectedBooksList = creatExpectedBookList();
        assertEquals(expectedBooksList.hashCode(), actualBooksList.hashCode());
    }

    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("booksTest.json").getFile());
        return file.getAbsolutePath();
    }


    private List<Book> creatExpectedBookList() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(creatFirstBook());
        expectedBooks.add(creatSecondBook());
        return expectedBooks;
    }

    private Book creatFirstBook() {
        return new Book(
                "7tkN1CYzn2cC",
                "9781592432172",
                "A Hypervista of the Java Landscape",
                null,
                "InfoStrategist.com",
                new Long(0),
                null,
                null,
                "http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                "en",
                "http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api",
                null,
                null,
                null,
                null);
    }

    private Book creatSecondBook() {
        ArrayList<String> authors = new ArrayList<>();
        authors.add("Clifford Geertz");
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Religion");

        return new Book(
                "-SYM4PW-YAgC",
                "9780226285108",
                "The Religion of Java",
                null,
                "University of Chicago Press",
                new Long(193190400),
                "Written with a rare combination of analysis and speculation, this comprehensive study of Javanese religion is one of the few books on the religion of a non-Western people which emphasizes variation and conflict in belief as well as similarity and harmony. The reader becomes aware of the intricacy and depth of Javanese spiritual life and the problems of political and social integration reflected in the religion. The Religion of Java will interest specialists in Southeast Asia, anthropologists and sociologists concerned with the social analysis of religious belief and ideology, students of comparative religion, and civil servants dealing with governmental policy toward Indonesia and Southeast Asia.",
                new Integer(392),
                "http://books.google.com/books/content?id=-SYM4PW-YAgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                "en",
                "http://books.google.pl/books?id=-SYM4PW-YAgC&printsec=frontcover&dq=java&hl=&cd=2&source=gbs_api",
                new Double(4.0),
                new Integer(4),
                authors,
                categories);
    }

}